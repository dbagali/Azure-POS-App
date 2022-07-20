package com.suggestion.county.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import com.suggestion.county.dto.CountySuggestion;
import com.suggestion.county.entity.CountyEntity;
import com.suggestion.county.repository.CountyRepository;

@ExtendWith(MockitoExtension.class)
public class CountyServiceTest {

	@InjectMocks
	private CountyService countyService;

	@Mock
	CountyRepository countyRepository;

	@Test
	public void suggestCounty() {

		Page<CountyEntity> results = Page.empty();
		Mockito.when(countyRepository.findByNameOrStateIgnoreCase(ArgumentMatchers.anyString(), ArgumentMatchers.any()))
				.thenReturn(results);
		List<CountySuggestion> suggestedCounties = countyService.getSuggestedCounties("AL");
		Assertions.assertNotNull(suggestedCounties);
	}
}
