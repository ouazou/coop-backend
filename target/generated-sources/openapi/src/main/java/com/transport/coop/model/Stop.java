package com.transport.coop.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.transport.coop.model.StopLocation;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Stop
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-01T10:44:36.661087500-05:00[America/New_York]", comments = "Generator version: 7.9.0")
public class Stop {

  private String stopId;

  private StopLocation location;

  private String time;

  public Stop stopId(String stopId) {
    this.stopId = stopId;
    return this;
  }

  /**
   * Get stopId
   * @return stopId
   */
  
  @Schema(name = "stopId", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("stopId")
  public String getStopId() {
    return stopId;
  }

  public void setStopId(String stopId) {
    this.stopId = stopId;
  }

  public Stop location(StopLocation location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   */
  @Valid 
  @Schema(name = "location", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("location")
  public StopLocation getLocation() {
    return location;
  }

  public void setLocation(StopLocation location) {
    this.location = location;
  }

  public Stop time(String time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
   */
  
  @Schema(name = "time", example = "07:15", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("time")
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stop stop = (Stop) o;
    return Objects.equals(this.stopId, stop.stopId) &&
        Objects.equals(this.location, stop.location) &&
        Objects.equals(this.time, stop.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stopId, location, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stop {\n");
    sb.append("    stopId: ").append(toIndentedString(stopId)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

