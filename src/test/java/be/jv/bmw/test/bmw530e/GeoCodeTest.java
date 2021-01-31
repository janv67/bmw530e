package be.jv.bmw.test.bmw530e;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import be.jv.bmw.GeoCodeServiceConnector;
import be.jv.bmw.data.geocode.GeoData;
import be.jv.bmw.data.geocode.Geocode;

public class GeoCodeTest {

	@Test
	public void testGeoCodeLocationFromURL() {
		//51.157036,4.4716654
		String latitude = "51.157036";
		String longitude = "4.4716654";
		GeoCodeServiceConnector geocodeConnector = new GeoCodeServiceConnector();
		GeoData geo = geocodeConnector.getGeoCodeFromUrl(latitude, longitude);
		if (geo == null) {
			fail("Nothing received");
		} else {
			assertEquals(geo.getData().get(0).getPostal_code(), "2540");
			System.out.println(geo.getData().get(0).getPostal_code());
		}
	}


}
