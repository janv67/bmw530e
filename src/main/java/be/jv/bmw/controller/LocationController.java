package be.jv.bmw.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import be.jv.bmw.data.location.Location;
import be.jv.bmw.data.repositories.LocationRespository;

@RestController
public class LocationController {

	@Autowired
	LocationRespository locationRespository;

	@GetMapping("/location")
	public List<Location> showAll() {
		return locationRespository.findAll();
	}

	@GetMapping("/location/{id}")
	public Location show(@PathVariable String id) {
		int locationId = Integer.parseInt(id);
		Optional<Location> location = locationRespository.findById(locationId);

		if (location.isPresent()) {
			return location.get();
		} else {
			return new Location();
		}
	}

	@PostMapping("/location")
	public Location create(@RequestBody String body) {

		// JSON from file to Object
		Location location = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			location = mapper.readValue(body, Location.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// get last stored id
		List<Location> ids = locationRespository.findLast();
		Object id = ids.get(0);
		int intId = 0;
		if (ids.get(0) != null) {
			intId = Integer.parseInt(id.toString());
		}

		// get last efficiency registered
		Optional<Location> storedLocation = locationRespository.findById(intId);
		String lastStoredPosition = "Last";
		String newPosition = "new";
		if (storedLocation.isPresent()) {
			Location lastStored = storedLocation.get();
			lastStoredPosition = String.valueOf(lastStored.getLatitude()) + String.valueOf(lastStored.getLongitude());
		}
		newPosition = String.valueOf(location.getLatitude()) + String.valueOf(location.getLongitude());

		Location result = null;
		if (!newPosition.equals(lastStoredPosition)) {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formatDate = now.format(formatter);
			DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
			String formatTime = now.format(formatterTime);
			location.setDate(formatDate);
			location.setTime(formatTime);
			result = locationRespository.save(location);
		} 
		return result;
	}

}