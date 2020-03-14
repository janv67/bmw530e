package be.jv.bmw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import be.jv.bmw.GeoCodeServiceConnector;
import be.jv.bmw.data.geocode.BMWGeocodes;
import be.jv.bmw.data.location.Location;
import be.jv.bmw.data.repositories.LocationRespository;

@RestController
public class DynamicController {

	@Autowired
	LocationRespository locationRespository;

	@Autowired
	GeoCodeServiceConnector geocodeService;
	
    @CrossOrigin
	@GetMapping("/dynamic")
	public List<Location> showAll() {
    	List<Location> locs = locationRespository.findAll();
		return locs;
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
    
	@GetMapping("/dynamicwithgeocodes")
	public List<Location> loadgeocode() {
		boolean loaded = false;
		List<Location> locations = locationRespository.findAll();
		for (Location location : locations) {
			if (location.getGeo_city() == null || location.getGeo_city().length() == 0) {
				BMWGeocodes geo = geocodeService.storeGeoCodeCalls(String.valueOf(location.getLatitude()),
						String.valueOf(location.getLongitude()));
				if (geo.getCity() != null) {
					location.setGeo_city(geo.getCity());
					location.setGeo_postal(geo.getPostal());
					location.setGeo_street(geo.getStaddress());
					location.setGeo_number(geo.getStnumber());
					locationRespository.save(location);
				}
			}
		}
		return locations;
	}


}