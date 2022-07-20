package com.suggestion.county;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suggestion.county.dto.CountySuggestion;
import com.suggestion.county.service.CountyService;

@SpringBootApplication
public class CountyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountyApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CountyService countyService) {
		return args -> {

			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<CountySuggestion>> typeReference = new TypeReference<List<CountySuggestion>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
			try {
				List<CountySuggestion> counties = mapper.readValue(inputStream, typeReference);
				System.out.println("Number of counties loaded " + counties.size());
				countyService.saveCounties(counties);
			} catch (IOException e) {

			}
		};
	}
}
