package com.suggestion.county.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.suggestion.county.dto.CountySuggestion;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-04T16:22:42.033Z[GMT]")
@Validated
public interface SuggestApi {

    @Operation(summary = "Suggest Counties", description = "Get suggested counties based on provided query string. Responds with an array, limited to 5 results, of counties where the county name or state matches the provided query string.", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "County Suggestions", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CountySuggestion.class)))) })
    @RequestMapping(value = "/suggest",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<CountySuggestion>> suggestCounties(@NotNull @Parameter(in = ParameterIn.QUERY, description = "county name and/or state fragment" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "q", required = true) String q);

}