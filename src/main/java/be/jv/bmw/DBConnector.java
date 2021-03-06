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
import be.jv.bmw.data.geocode.BMWGeocodes;
import be.jv.bmw.data.location.Location;
import be.jv.bmw.data.repositories.DynamicRespository;
import be.jv.bmw.data.repositories.EfficiencyRespository;
import be.jv.bmw.data.repositories.GeocodeRepository;
import be.jv.bmw.data.repositories.LocationRespository;

@Component
public class DBConnector {

	@Autowired
	DynamicRespository dynamicRespository;

	@Autowired
	LocationRespository locationRespository;

	@Autowired
	EfficiencyRespository efficiencyRespository;

	@Autowired
	GeocodeRepository geocodeRepository;

	private static final Logger log = LoggerFactory.getLogger(DBConnector.class);

	public boolean storeDynamicInfo(Dynamic dynamic) {
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
			
//			no longer checking on times as too much info was stored and the UI became too slow
			
//			String lastStoredDateTime = storedDynamicInfo.getAttributesMap().getUpdateTime_converted();
//			String deliveredDateTime = dynamic.getAttributesMap().getUpdateTime_converted();
//			if (!deliveredDateTime.equals(lastStoredDateTime)) {
//				storeInfo = true;
//			}
			String lastStoredMileage = storedDynamicInfo.getAttributesMap().getMileage();
			String deliveredMileage = dynamic.getAttributesMap().getMileage();
			if (!lastStoredMileage.equals(deliveredMileage)) {
				storeInfo = true;
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
		return storeInfo;
	}

	public void storeLocationInfo(Location location) {
		boolean storeData = false;
		// get last stored id
		List<Location> ids = locationRespository.findLast();
		Object id = ids.get(0);
		int intId = 0;
		if (ids.get(0) != null) {
			intId = Integer.parseInt(id.toString());
		}
		// get last efficiency registered
		Optional<Location> storedLocation = locationRespository.findById(intId);
		if (storedLocation.isPresent()) {
			Location loc = storedLocation.get();
			if (location.getLatitude()==loc.getLatitude() && location.getLongitude()==loc.getLongitude()) {
				storeData = false;
			} else {
				// Location changed, so upload the data
				storeData = true;
			}
		}

		if (storeData) {
			locationRespository.save(location);
		}

	}

	public Efficiency storeEfficiency(Efficiency providedEfficiency) {
		boolean storeData = false;
		// get last stored id
		List<Efficiency> ids = efficiencyRespository.findLast();
		Object id = ids.get(0);
		int intId = 0;

		try {
			intId = Integer.parseInt(id.toString());
		} catch (Exception e) {
		}

		// get last efficiency registered
		Optional<Efficiency> storedEfficiency = efficiencyRespository.findById(intId);
		String lastDatTimeProvided = "last";
		String lastDatTime = "";

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
				log.debug("Lastdatetime from trip in db " + lastDatTime);
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

	public void storeGeoCode(BMWGeocodes bmwgeo) {
		log.info("Geolocation is being stored");

		try {
			geocodeRepository.save(bmwgeo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<BMWGeocodes> fetchGeoCode(String latitude, String longitude) {
		List<BMWGeocodes> geocodes = geocodeRepository.findGeocodeInfoByLongLat(latitude, longitude);
		return geocodes;
	}

}
