package com.suggestion.county.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.suggestion.county.dto.CountySuggestion;
import com.suggestion.county.entity.CountyEntity;
import com.suggestion.county.repository.CountyRepository;

@Service
public class CountyService {

	@Autowired
	CountyRepository countyRepository;

	public void saveCounties(List<CountySuggestion> counties) {
		List<CountyEntity> countyEntities = new ArrayList<CountyEntity>();
		counties.forEach(county -> {
			countyEntities.add(convertDtoToEntity(county));
		});
		countyRepository.saveAll(countyEntities);
	}

	public List<CountySuggestion> getSuggestedCounties(String query) {
		List<CountySuggestion> countySuggestions = new ArrayList<CountySuggestion>();
		Pageable pageRequest = PageRequest.of(0, 5, Sort.by("name").ascending());
		countyRepository.findByNameOrStateIgnoreCase(query, pageRequest).forEach(county -> {
			countySuggestions.add(convertEntityToDto(county));
		});
		return countySuggestions;
	}

	private CountyEntity convertDtoToEntity(CountySuggestion county) {
		CountyEntity countyEntity = new CountyEntity();
		countyEntity.setFips(county.getFips());
		countyEntity.setName(county.getName());
		countyEntity.setState(county.getState());
		return countyEntity;
	}

	private CountySuggestion convertEntityToDto(CountyEntity county) {
		CountySuggestion countySuggestion = new CountySuggestion();
		countySuggestion.setFips(county.getFips());
		countySuggestion.setName(county.getName());
		countySuggestion.setState(county.getState());
		return countySuggestion;
	}

}
