package com.suggestion.county.dto;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * CountySuggestion
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-04T16:22:42.033Z[GMT]")


public class CountySuggestion   {
  @JsonProperty("fips")
  private String fips = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("name")
  private String name = null;

  public CountySuggestion fips(String fips) {
    this.fips = fips;
    return this;
  }

  /**
   * Get fips
   * @return fips
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getFips() {
    return fips;
  }

  public void setFips(String fips) {
    this.fips = fips;
  }

  public CountySuggestion state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public CountySuggestion name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CountySuggestion countySuggestion = (CountySuggestion) o;
    return Objects.equals(this.fips, countySuggestion.fips) &&
        Objects.equals(this.state, countySuggestion.state) &&
        Objects.equals(this.name, countySuggestion.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fips, state, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CountySuggestion {\n");
    
    sb.append("    fips: ").append(toIndentedString(fips)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
