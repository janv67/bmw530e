package be.jv.bmw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import be.jv.bmw.GeoCodeServiceConnector;
import be.jv.bmw.data.dynamic.Dynamic;
import be.jv.bmw.data.repositories.DynamicRespository;

@RestController
public class DynamicController {

	@Autowired
	DynamicRespository dynamicRespository;

	@Autowired
	GeoCodeServiceConnector geocodeService;
	
    @CrossOrigin
	@GetMapping("/dynamic")
	public List<Dynamic> showAll() {
    	List<Dynamic> dyn = dynamicRespository.findAll();
		return dyn;
	}

    @CrossOrigin
    @GetMapping("/dynamic/date/{datum}")
	public List<Dynamic> showByDate(@PathVariable String datum) {
    	//Dateformat in attributesmap is different
    	String dynamicDate = datum.substring(8)+"."+datum.substring(5,7)+"."+datum.substring(0,4);
    	List<Dynamic> dyns = dynamicRespository.findByDate(dynamicDate);
		return dyns;
	}

    @CrossOrigin
	@GetMapping("/dynamic/{id}")
	public Dynamic show(@PathVariable String id) {
		int dynamicId = Integer.parseInt(id);
		Optional<Dynamic> dynamic = dynamicRespository.findById(dynamicId);

		if (dynamic.isPresent()) {
			return dynamic.get();
		} else {
			return new Dynamic();
		}
	}
    
}