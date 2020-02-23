package be.jv.bmw;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.jv.bmw.data.dynamic.Dynamic;
import be.jv.bmw.data.efficiency.Efficiency;
import be.jv.bmw.data.efficiency.LastTripList;
import be.jv.bmw.data.location.Location;
import be.jv.bmw.data.repositories.DynamicRespository;
import be.jv.bmw.data.repositories.EfficiencyRespository;
import be.jv.bmw.data.repositories.LocationRespository;

@Component
public class DBConnector {

	@Autowired
	DynamicRespository dynamicRespository;

	@Autowired
	LocationRespository locationRespository;

	@Autowired
	EfficiencyRespository efficiencyRespository;
	
	private static final Logger log = LoggerFactory.getLogger(DBConnector.class);

	public void storeDynamicInfo(Dynamic dynamic) {
		// get last stored id
		List<Dynamic> ids = dynamicRespository.findLast();
		Object id = ids.get(0);
		int intId = 0;
		if (ids.get(0) != null) {
			intId = Integer.parseInt(id.toString());
		}

		boolean storeInfo = false;
		// get last dynamic info registered
		Optional<Dynamic> storedDynamic = dynamicRespository.findById(intId);

		if (storedDynamic.isPresent()) {
			Dynamic storedDynamicInfo = storedDynamic.get();
			String lastStoredDateTime = storedDynamicInfo.getAttributesMap().getUpdateTime_converted();
			String deliveredDateTime = dynamic.getAttributesMap().getUpdateTime_converted();
			if (!deliveredDateTime.equals(lastStoredDateTime)) {
				storeInfo= true;
			}
		} else {
			storeInfo = true;
		}

		if (storeInfo) {
			dynamicRespository.save(dynamic);
			log.info("Dynamic stored successfully ");
		} else {
			log.info("No new dynamic data found");

		}
	}

	private void storeLocationInfo(Location location) {
		// get last stored id
		List<Location> ids = locationRespository.findLast();
		Object id = ids.get(0);
		int intId = 0;
		if (ids.get(0) != null) {
			intId = Integer.parseInt(id.toString());
		}

		// get last dynamic info registered
//		Optional<Dynamic> storedDynamic = dynamicRespository.findById(intId);
		locationRespository.save(location);

	}

	
	public Efficiency storeEfficiency(Efficiency providedEfficiency) {
		boolean storeData = false;
		// get last stored id
		List<Efficiency> ids = efficiencyRespository.findLast();
		Object id = ids.get(0);
		int intId = 0;
		
		try {
			intId= Integer.parseInt(id.toString());
		} catch (Exception e) {
		}

		// get last efficiency registered
		Optional<Efficiency> storedEfficiency = efficiencyRespository.findById(intId);
		String lastDatTimeProvided = "last";
		String lastDatTime ="";
		
		if (storedEfficiency.isPresent()) {
			// Get last stored date from provided efficiency
			Optional<LastTripList> optional1 = Arrays.stream(providedEfficiency.getLastTripList())
					.filter(x -> "LASTTRIP_TIME_SEGMENT_END".equals(x.getName())).findFirst();

			if (optional1.isPresent()) {// Check whether optional has element you are looking for
				LastTripList p = optional1.get();// get it from optional
				lastDatTimeProvided = p.getLastTrip();
				log.debug("Lastdatetime from trip from BMW API " + lastDatTimeProvided);
			}
			
			// Get last stored date from stored efficiency
			Efficiency lastStored = storedEfficiency.get();
			Optional<LastTripList> optional = Arrays.stream(lastStored.getLastTripList())
					.filter(x -> "LASTTRIP_TIME_SEGMENT_END".equals(x.getName())).findFirst();

			if (optional.isPresent()) {// Check whether optional has element you are looking for
				LastTripList p = optional.get();// get it from optional
				lastDatTime = p.getLastTrip();
				log.debug("Lastdatetime from trip in db "+lastDatTime);
			}

			if (!lastDatTimeProvided.equals(lastDatTime)) {
				storeData = true;
			}
		} else {
			// no information stored yet, so store the one that came in
			storeData = true;
		}

		Efficiency newEfficiency = null;
		if (storeData) {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formatDate = now.format(formatter);
			DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
			String formatTime = now.format(formatterTime);
			providedEfficiency.setDate(formatDate);
			providedEfficiency.setTime(formatTime);

			newEfficiency = efficiencyRespository.save(providedEfficiency);
			log.info("Efficiency stored successfully ");
		}
		return newEfficiency;
	}

}
