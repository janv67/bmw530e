package be.jv.bmw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import be.jv.bmw.data.location.Location;
import be.jv.bmw.data.repositories.LocationRespository;

@RestController
public class DynamicController {

	@Autowired
	LocationRespository locationRespository;

    @CrossOrigin
	@GetMapping("/dynamic")
	public List<Location> showAll() {
		return locationRespository.findAll();
	}

    @CrossOrigin
	@GetMapping("/dynamic/{id}")
	public Location show(@PathVariable String id) {
		int locationId = Integer.parseInt(id);
		Optional<Location> location = locationRespository.findById(locationId);

		if (location.isPresent()) {
			return location.get();
		} else {
			return new Location();
		}
	}
}