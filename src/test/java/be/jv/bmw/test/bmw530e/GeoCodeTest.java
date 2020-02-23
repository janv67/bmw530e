package be.jv.bmw.test.bmw530e;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import be.jv.bmw.GeoCodeServiceConnector;
import be.jv.bmw.data.geocode.Geocode;

public class GeoCodeTest {

	@Test
	public void test() {
		String longitude = "51.155693";
		String latitude = "4.5149717";
		GeoCodeServiceConnector geocodeConnector = new GeoCodeServiceConnector();
		Geocode geocode = geocodeConnector.scheduleGeoCodeCalls(longitude, latitude);
		if (geocode == null || geocode.getStaddress().length()==0) {
			fail("Nothing received");
		} else {
			System.out.println(geocode.getStaddress()+" "+geocode.getStnumber());
		}
	}

}
