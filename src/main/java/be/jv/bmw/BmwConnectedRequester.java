package be.jv.bmw;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import be.jv.bmw.data.dynamic.Dynamic;
import be.jv.bmw.data.efficiency.Efficiency;
import be.jv.bmw.data.location.Location;
import be.jv.bmw.scheduling.ScheduledTimer;

@Configuration
@EnableAutoConfiguration
@ComponentScan("be.jv.bmw")
@Component
public class BmwConnectedRequester { 
	private static final Logger log = LoggerFactory.getLogger(BmwConnectedRequester.class);
	private String authorizationCode = ""; // "Bearer 43guP9HemLHc1r88IlRre1Bo3ojHBdUu";

	private static final String NAVIGATION_URL = "https://www.bmw-connecteddrive.be/api/vehicle/navigation/v1/WBAJA91010B306212";
	private static final String EFFICIENCY_URL = "https://www.bmw-connecteddrive.be/api/vehicle/efficiency/v1/WBAJA91010B306212";
	private static final String DYNAMIC_URL = "https://www.bmw-connecteddrive.be/api/vehicle/dynamic/v1/WBAJA91010B306212?offset=-60";
	
	// to create a java class from json, use http://jsongen.byingtondesign.com/
	@Autowired 
	DBConnector dbConnector;

	@Autowired 
	GeoCodeServiceConnector geocodeConnector;

	@Autowired 
	BMWConnector bmwConnector;

	@Value("${application.url}")
	private String applicationUrl;

	@Autowired
	ScheduledTimer timer;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	public BmwConnectedRequester() {
		super();
	}

	public void scheduledCalls() {
		log.info("---------------------------------------------------------------");
		log.info("Connecting to the car services : the time is now {}", dateFormat.format(new Date()));
		locationCalls();
		efficiencyCalls();
		boolean carMoved = dynamicCalls();
		// if car service was connected, set the next time the service should be executed
		if (carMoved) {
			timer.decrementTimer();
		} else {
			timer.incrementTimer();
		}
	}
	
	private void locationCalls() {
		// get the information from BMW
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Location> bmwAnswer = null;
		if (authorizationCode.length() == 0) {
			authorizationCode = bmwConnector.authenticate();
		}
		try {
			bmwAnswer = restTemplate.exchange(NAVIGATION_URL, HttpMethod.GET, getHttpEntity(), Location.class);
		} catch (Exception e) {
			if (bmwAnswer == null) {
				// re-Authorise at BMW
				log.error("BMW Connection error, retrying");
				authorizationCode = bmwConnector.authenticate();
				bmwAnswer = restTemplate.exchange(NAVIGATION_URL, HttpMethod.GET, getHttpEntity(), Location.class);
			}
		}
		log.info("Navigation fetched successfully ");

		Location location = bmwAnswer.getBody();
		dbConnector.storeLocationInfo(location);
	}

	private void efficiencyCalls() {
		// get the information from BMW
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Efficiency> bmwAnswer = null;
		if (authorizationCode.length() == 0) {
			authorizationCode = bmwConnector.authenticate();
		}
		try {
			bmwAnswer = restTemplate.exchange(EFFICIENCY_URL, HttpMethod.GET, getHttpEntity(), Efficiency.class);
		} catch (Exception e) {
			if (bmwAnswer == null) {
				// re-Authorise at BMW Connecteddrive
				log.error("BMW Connection error, retrying");
				authorizationCode = bmwConnector.authenticate();
				bmwAnswer = restTemplate.exchange(EFFICIENCY_URL, HttpMethod.GET, getHttpEntity(), Efficiency.class);
			}
		}
		log.info("Efficiency fetched successfully ");

		Efficiency efficiency = bmwAnswer.getBody();
		// store the information using internal API
		dbConnector.storeEfficiency(efficiency);

	}

	private boolean dynamicCalls() {
	
		boolean carMoved = false;
		// get the information from BMW
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Dynamic> bmwAnswer = null;
		if (authorizationCode.length() == 0) {
			authorizationCode = bmwConnector.authenticate();
		}
		try {
			bmwAnswer = restTemplate.exchange(DYNAMIC_URL, HttpMethod.GET, getHttpEntity(), Dynamic.class);
		} catch (Exception e) {
			if (bmwAnswer == null) {
				// re-Authorise at BMW Connecteddrive
				log.error("BMW Connection error, retrying");
				authorizationCode = bmwConnector.authenticate();
				bmwAnswer = restTemplate.exchange(DYNAMIC_URL, HttpMethod.GET, getHttpEntity(), Dynamic.class);
			}
		}
		String longitude = bmwAnswer.getBody().getAttributesMap().getGps_lng();
		String latitude = bmwAnswer.getBody().getAttributesMap().getGps_lat();
		geocodeConnector.storeGeoCodeCalls(latitude, longitude);
		log.info("Dynamic fetched successfully ");

		// store the information using internal API
		Dynamic dynamic = bmwAnswer.getBody();
		carMoved = dbConnector.storeDynamicInfo(dynamic); 
		return carMoved;
	}

	private HttpEntity<String> getHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("authorization", authorizationCode);
		HttpEntity<String> entity = new HttpEntity<>("", headers);
		return entity;
	}

}
