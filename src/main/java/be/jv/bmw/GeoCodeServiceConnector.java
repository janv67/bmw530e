package be.jv.bmw;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import be.jv.bmw.data.geocode.BMWGeocodes;
import be.jv.bmw.data.geocode.Geocode;

@Configuration
@EnableAutoConfiguration
@ComponentScan("be.jv.bmw")


@Component
public class GeoCodeServiceConnector { 

	private static final Logger log = LoggerFactory.getLogger(GeoCodeServiceConnector.class);

	private static final String GEOCODE_URL = "https://geocode.xyz/longitude,latitude?geoit=json";
//	private static final String GEOCODE_URL = "http://127.0.0.1:5500/geocode.json";

	@Autowired
	DBConnector dbConnector;

	
	public boolean storeGeoCodeCalls(String latitude, String longitude) {
		boolean isFetched = dbConnector.fetchGeoCode(latitude, longitude);
		if (!isFetched) {
			BMWGeocodes geocodes = new BMWGeocodes();
			Geocode geo = getGeoCodeFromUrl(latitude, longitude);
			if (geo != null) {
				geocodes.setLatitude(latitude);
				geocodes.setLongitude(longitude);
				geocodes.setStaddress(geo.getStaddress());
				geocodes.setCity(geo.getCity());
				geocodes.setStnumber(geo.getStnumber().toString());
				geocodes.setPostal(geo.getPostal());
				geocodes.setGeonumber(geo.getGeonumber());
				dbConnector.storeGeoCode(geocodes);
			}
		}
		return true;
	}
	
	public Geocode getGeoCodeFromUrl(String longitude, String latitude) {
		// get the information from BMW
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Geocode> geocodeAnswer = null;
		String geoCodeUrl = GEOCODE_URL.replaceAll("longitude", longitude);
		geoCodeUrl = geoCodeUrl.replaceAll("latitude", latitude);
		try {
			geocodeAnswer = restTemplate.exchange(geoCodeUrl, HttpMethod.GET, getHttpEntity(), Geocode.class);
		} catch (Exception e) {
			if (geocodeAnswer == null) {
				log.error("GEOCODE Connection error, retrying");
				log.error(e.getMessage());
				return null;
			}
		}
		return geocodeAnswer.getBody();
	}

	private HttpEntity<String> getHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("", headers);
		return entity;
	}
}
