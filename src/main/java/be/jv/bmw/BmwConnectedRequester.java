package be.jv.bmw;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import be.jv.bmw.data.dynamic.Dynamic;
import be.jv.bmw.data.efficiency.Efficiency;
import be.jv.bmw.data.location.Location;

@EnableScheduling
@Configuration
@EnableAutoConfiguration
@ComponentScan("be.jv.bmw")
@Component
public class BmwConnectedRequester { //implements SchedulingConfigurer {

	private static final Logger log = LoggerFactory.getLogger(BmwConnectedRequester.class);
	private String authorizationCode = ""; // "Bearer 43guP9HemLHc1r88IlRre1Bo3ojHBdUu";

	private static final String NAVIGATION_URL = "https://www.bmw-connecteddrive.be/api/vehicle/navigation/v1/WBAJA91010B306212";
	private static final String EFFICIENCY_URL = "https://www.bmw-connecteddrive.be/api/vehicle/efficiency/v1/WBAJA91010B306212";
	private static final String DYNAMIC_URL = "https://www.bmw-connecteddrive.be/api/vehicle/dynamic/v1/WBAJA91010B306212?offset=-60";
	
	// to create a java class from json, use http://jsongen.byingtondesign.com/
	
	private String locationUrl = "/location";
	private String efficiencyUrl = "/efficiency";
	private String dynamicUrl = "/dynamic";

	private int milliSeconds = 60000;

	@Autowired 
	DBConnector dbConnector;

	@Autowired 
	GeoCodeServiceConnector geocodeConnector;

	@Autowired 
	BMWConnector bmwConnector;

	@Bean
	public BmwConnectedRequester myBean() {
		return this;
	}

	@Value("${application.url}")
	private String applicationUrl;

	@Autowired
	Environment environment;

	@Scheduled(fixedDelay = 300000)
	public void scheduleLocationCalls() {
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

		callService(restTemplate, bmwAnswer);
	}

	private void callService(RestTemplate restTemplate, ResponseEntity<Location> bmwAnswer) {
		// store the information using internal API
		Location location = bmwAnswer.getBody();
		String body = location.toString();
		HttpHeaders headers2 = new HttpHeaders();
		headers2.setContentType(MediaType.APPLICATION_JSON);
		headers2.add("content-type", "application/json");
		HttpEntity<String> entity2 = new HttpEntity<>(body, headers2);
		ResponseEntity<Object> result = restTemplate.exchange(applicationUrl + locationUrl, HttpMethod.POST, entity2,
				Object.class);
		log.info("Location stored successfully ");
		if (result.getBody() == null) {
			incrementTimer();
		} else {
			decrementTimer();
		}
	}

	@Scheduled(fixedDelay = 300000)
	public void scheduleEfficiencyCalls() {
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
		//callEfficiencyAPI(restTemplate, efficiency);
		dbConnector.storeEfficiency(efficiency);

	}

	private void callEfficiencyAPI(RestTemplate restTemplate, Efficiency efficiency) {
		String body = efficiency.toString();
		HttpHeaders headers2 = new HttpHeaders();
		headers2.setContentType(MediaType.APPLICATION_JSON);
		headers2.add("content-type", "application/json");
		HttpEntity<String> entity2 = new HttpEntity<>(body, headers2);
//		ResponseEntity<Object> result = restTemplate.exchange(applicationUrl + efficiencyUrl, HttpMethod.POST, entity2,
//				Object.class);
	}

	@Scheduled(fixedDelay = 300000)
	public void scheduleDynamicCalls() {
	
		String port = environment.getProperty("server.port");
		String datasource = environment.getProperty("spring.datasource.url");
		
		log.info("---------------------------------------------------------------");
		log.info("Op deze poort kan je connecteren!    "+port);
		log.info("Datasource waarnaar wordt geschreven "+datasource);
		log.info("---------------------------------------------------------------");
		
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
		dbConnector.storeDynamicInfo(dynamic); 
	}

	private HttpEntity<String> getHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("authorization", authorizationCode);
		HttpEntity<String> entity = new HttpEntity<>("", headers);
		return entity;
	}


//	@Bean(destroyMethod = "shutdown")
//	public Executor taskExecutor() {
//		return Executors.newScheduledThreadPool(100);
//	}
//
//	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//		taskRegistrar.setScheduler(taskExecutor());
//		taskRegistrar.addTriggerTask(new Runnable() {
//			@Override
//			public void run() {
//				myBean().scheduleLocationCalls();
//			}
//		}, new Trigger() {
//			@Override
//			public Date nextExecutionTime(TriggerContext triggerContext) {
//				Calendar nextExecutionTime = new GregorianCalendar();
//				Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
//				if (lastActualExecutionTime == null) {
//					lastActualExecutionTime = new Date();
//				}
//				nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
//				nextExecutionTime.add(Calendar.MILLISECOND, milliSeconds); // you can get
//				log.info("Next execution: " + nextExecutionTime.getTime().toGMTString());
//				return nextExecutionTime.getTime();
//			}
//		});
//	}
//
	public void incrementTimer() {
		milliSeconds = milliSeconds * 2;
		if (milliSeconds > 300000) {
			milliSeconds = 300000;
		}
		log.info("Incremented timer to " + milliSeconds);
	}

	public void decrementTimer() {
		milliSeconds = milliSeconds / 2;
		if (milliSeconds < 10000) {
			milliSeconds = 10000;
		}
		log.info("Decremented timer to " + milliSeconds);
	}

}
