package com.nisumtest.personaservice;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import com.nisumtest.personaservice.domain.Persona;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PersonaServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void createPersonaInvalidHairColorTest() throws RestClientException, MalformedURLException {
		Persona p = new Persona();
		p.setId(1);
		p.setName("Sarath");
		p.setLastName("Deva");
		p.setHairColor("green");
		p.setMobileNumber("8008948106");
		p.setAddress("Eclat");
		
		HttpHeaders headers = new HttpHeaders();
		 
        HttpEntity<Persona> request = new HttpEntity<>(p, headers);
        try
        {
		restTemplate.postForEntity(new URL("http://localhost:" + port + "/persona/").toString(),request,Persona.class);
        }catch(HttpClientErrorException ex) 
	        {
	            //Verify bad request and missing header
	            Assertions.assertEquals(400, ex.getRawStatusCode());
	            Assertions.assertEquals(true, ex.getResponseBodyAsString().contains("\"rejectedValue\": \"green\""));
	        }
	}

}
