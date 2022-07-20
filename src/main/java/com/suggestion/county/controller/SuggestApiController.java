package com.suggestion.county.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suggestion.county.dto.CountySuggestion;
import com.suggestion.county.service.CountyService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-04T16:22:42.033Z[GMT]")
@RestController
public class SuggestApiController implements SuggestApi {

	private static final Logger log = LoggerFactory.getLogger(SuggestApiController.class);

	private final HttpServletRequest request;

	@Autowired
	private CountyService countyService;

	@org.springframework.beans.factory.annotation.Autowired
	public SuggestApiController(HttpServletRequest request) {
		this.request = request;
	}

	public ResponseEntity<List<CountySuggestion>> suggestCounties(
			@NotNull @Parameter(in = ParameterIn.QUERY, description = "county name and/or state fragment", required = true, schema = @Schema()) @Valid @RequestParam(value = "q", required = true) String q) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<CountySuggestion>>(countyService.getSuggestedCounties(q), HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't fetch data for County", e);
				return new ResponseEntity<List<CountySuggestion>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<CountySuggestion>>(HttpStatus.NOT_FOUND);
	}

}
