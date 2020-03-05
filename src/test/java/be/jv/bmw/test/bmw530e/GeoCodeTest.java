package be.jv.bmw.test.bmw530e;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import be.jv.bmw.GeoCodeServiceConnector;
import be.jv.bmw.data.geocode.Geocode;

public class GeoCodeTest {

	@Test
	public void test() {
		String latitude = "51.155693";
		String longitude = "4.5149717";
		GeoCodeServiceConnector geocodeConnector = new GeoCodeServiceConnector();
		Geocode geo = geocodeConnector.getGeoCodeFromUrl(latitude, longitude);
		if (geo == null) {
			fail("Nothing received");
		} else {
			assertEquals(geo.getCity(), "Boechout");
			System.out.println(geo.getCity());
		}
	}

}
