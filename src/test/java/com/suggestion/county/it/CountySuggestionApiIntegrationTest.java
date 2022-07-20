package com.suggestion.county.it;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.suggestion.county.CountyApplication;
import com.suggestion.county.dto.CountySuggestion;

@SpringBootTest(classes = CountyApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CountySuggestionApiIntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port;

	@Test
	@DisplayName("Suggest counties postive scenario")
	public void suggestCounties() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl("http://localhost:" + port + "/suggest")
				.queryParam("q", "AL").build();
		ResponseEntity<List<CountySuggestion>> responseEntity = testRestTemplate.exchange(uriBuilder.toUriString(),
				HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<CountySuggestion>>() {
				});
		Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
