package com.test;

import java.nio.charset.Charset;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {
	public static final String SERVER_URI_ABC_POST ="http://localhost:10101/abc/rest/testservice/def";
	
	@Test
    public void testHttpConnectionAuthentication()
    {
		
		String plainCreds = "idAbc:Password-Test";
		HttpHeaders headers = new HttpHeaders();		
		headers.add("Authorization", "Basic " + java.util.Base64.getUrlEncoder().encodeToString(plainCreds.getBytes(Charset.forName("UTF-8"))));
			
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.postForEntity(SERVER_URI_ABC_POST, request, String.class);
		
		System.out.println(response.getBody());
    }

}
