package com.suggestion.county.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.suggestion.county.dto.CountySuggestion;
import com.suggestion.county.service.CountyService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = SuggestApiController.class)
public class SuggestApiControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CountyService countyService;
	
	@Test
	public void suggestCounties() throws Exception {
		List<CountySuggestion> countyResult = new ArrayList<CountySuggestion>();
		CountySuggestion county = new CountySuggestion();
		county.setFips("1002");
		county.setName("Alabama");
		county.setState("AL");
		countyResult.add(county);
		Mockito.when(countyService.getSuggestedCounties(ArgumentMatchers.anyString())).thenReturn(countyResult);
		mockMvc.perform(MockMvcRequestBuilders.get("/suggest?q=AL").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
