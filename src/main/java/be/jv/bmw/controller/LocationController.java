package be.jv.bmw.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import be.jv.bmw.GeoCodeServiceConnector;
import be.jv.bmw.data.geocode.BMWGeocodes;
import be.jv.bmw.data.location.Location;
import be.jv.bmw.data.repositories.GeocodeRepository;
import be.jv.bmw.data.repositories.LocationRespository;

@RestController
public class LocationController {

	@Autowired
	LocationRespository locationRespository;
	@Autowired
	GeocodeRepository geocodeRepository;
	@Autowired 
	GeoCodeServiceConnector geocodeConnector;

	private static final Logger log = LoggerFactory.getLogger(LocationController.class);
	
    @CrossOrigin
    @GetMapping("/location")
	public List<Location> showAll() {
    	List<Location> locs = locationRespository.findAll();
		return locs;
	}

    @CrossOrigin
    @GetMapping("/location/date/{datum}")
	public List<Location> showByDate(@PathVariable String datum) {
    	List<Location> locs = locationRespository.findByDate(datum);
    	for (Location location : locs) {
    		if (location.getGeo_postal()==null || location.getGeo_street().length()==0 ) {
	    		List <BMWGeocodes> geocodes = geocodeRepository.findGeocodeInfoByLongLat(location.getLatitude(), location.getLongitude());
	    		if (geocodes!=null && geocodes.size()>0) {
	    			location.setGeo_street(geocodes.get(0).getStaddress());
	    			location.setGeo_number(geocodes.get(0).getStnumber());
        			location.setGeo_postal(geocodes.get(0).getPostal());
        			location.setGeo_city(geocodes.get(0).getCity());
	    			locationRespository.save(location);
	    		} else {
	    			log.info("Location not found in database for "+location.getLatitude()+"\t"+location.getLongitude());
	    			BMWGeocodes geocode = geocodeConnector.getGeoCode(location.getLatitude(), location.getLongitude());    			
	        		if (geocode!=null) {
	        			location.setGeo_street(geocode.getStaddress());
	        			location.setGeo_number(geocode.getStnumber());
	        			location.setGeo_postal(geocode.getPostal());
	        			location.setGeo_city(geocode.getCity());
		    			locationRespository.save(location);
	        		}
	    		}
    		}
		}
    	
		return locs;
	}

    @CrossOrigin
    @GetMapping("/location/loadgeocodes")
	public List<Location> loadGeocodes() {
    	List<Location> locs = locationRespository.findAll();
    	for (Location location : locs) {
    		List <BMWGeocodes> geocodes = geocodeRepository.findGeocodeInfoByLongLat(location.getLatitude(), location.getLongitude());
    		if (geocodes==null || geocodes.size()==0) {
    			geocodeConnector.getGeoCode(location.getLatitude(), location.getLongitude());    			
    		}
		}
    	
		return locs;
	}

    @CrossOrigin
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

    @CrossOrigin
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