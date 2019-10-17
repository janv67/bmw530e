package be.jv.bmw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class BMWConnector {

	private static final Logger log = LoggerFactory.getLogger(BmwConnectedRequester.class);

	private static final String userid = "janv@telenet.be";
	private static final String password = "Jva0730--";
	private static final String AUTHORIZATION_URL = "https://customer.bmwgroup.com/gcdm/oauth/authenticate";

	private String authorizationCode = ""; // "Bearer 43guP9HemLHc1r88IlRre1Bo3ojHBdUu";

	public String authenticate() {
		ResponseEntity<String> response1 = callBMWAuthenticate("code");
		log.debug("Response 1: " + response1.toString());
		ResponseEntity<String> response2 = callBMWAuthenticate("token");
		log.debug("Response 2: " + response2.toString());
		// extract authentication code and type
		String temp = response2.toString().substring(response2.toString().indexOf("access_token"));
		temp = temp.substring(temp.indexOf('=') + 1);
		authorizationCode = temp.substring(0, temp.indexOf('&'));
		String type = temp.substring(temp.indexOf('=') + 1);
		type = type.substring(0, type.indexOf('&'));
		authorizationCode = type + " " + authorizationCode;
		log.info("Authorization code found:" + authorizationCode);
		return authorizationCode;
	}

	private ResponseEntity<String> callBMWAuthenticate(String responseType) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Accept", "application/json");
		headers.set("Content-Type", "application/x-www-form-urlencoded");
		headers.set("Origin", "https://customer.bmwgroup.com");
		headers.set("Referer",
				"https://customer.bmwgroup.com/one/signin.html?client_id=dbf0a542-ebd1-4ff0-a9a7-55172fbfce35&redirect_uri=https:%2F%2Fwww.bmw-connecteddrive.com%2Fapp%2Fstatic%2Fexternal-dispatch.html&response_type=token&scope=authenticate_user%20fupo&state=eyJtYXJrZXQiOiJiZSIsImxhbmd1YWdlIjoibmwiLCJkZXN0aW5hdGlvbiI6ImxhbmRpbmdQYWdlIiwicGFyYW1ldGVycyI6Int9In0&locale=BE-nl");
		headers.set("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("client_id", "dbf0a542-ebd1-4ff0-a9a7-55172fbfce35");
		map.add("redirect_uri", "https://www.bmw-connecteddrive.com/app/static/external-dispatch.html");
		map.add("response_type", responseType);
		map.add("scope", "authenticate_user fupo");
		map.add("state",
				"eyJtYXJrZXQiOiJiZSIsImxhbmd1YWdlIjoibmwiLCJkZXN0aW5hdGlvbiI6ImxhbmRpbmdQYWdlIiwicGFyYW1ldGVycyI6Int9In0");
		map.add("locale", "BE-nl");
		map.add("username", userid);
		map.add("password", password);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> response = restTemplate.postForEntity(AUTHORIZATION_URL, request, String.class);

		return response;
	}

}
