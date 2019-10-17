package be.jv.bmw.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import be.jv.bmw.BMWConnector;
import be.jv.bmw.DBConnector;
import be.jv.bmw.data.efficiency.Efficiency;
import be.jv.bmw.data.efficiency.LastTripList;
import be.jv.bmw.data.repositories.EfficiencyRespository;

@RestController
public class EfficiencyController {

	private static final Logger log = LoggerFactory.getLogger(EfficiencyController.class);

	@Autowired
	EfficiencyRespository efficiencyRespository;

	@Autowired 
	DBConnector dbConnector;

	@GetMapping("/efficiency")
	public List<Efficiency> showAll() {
		return efficiencyRespository.findAll();
	}

	@GetMapping("/efficiency/last")
	public List<Efficiency> lastRecord() {
		return efficiencyRespository.findLast();
	}

	@GetMapping("/efficiency/{id}")
	public Efficiency show(@PathVariable String id) {
		int efficiencyId = Integer.parseInt(id);
		Optional<Efficiency> efficiency = efficiencyRespository.findById(efficiencyId);

		if (efficiency.isPresent()) {
			return efficiency.get();
		} else {
			return new Efficiency();
		}
	}

	@PostMapping("/efficiency")
	public Efficiency create(@RequestBody String body) {

		// JSON from file to Object
		Efficiency providedEfficiency = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			providedEfficiency = mapper.readValue(body, Efficiency.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Efficiency newEfficiency = dbConnector.storeEfficiency(providedEfficiency);
		return newEfficiency;
	}


}