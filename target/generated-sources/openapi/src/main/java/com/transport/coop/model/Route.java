package com.transport.coop.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.transport.coop.model.Stop;
import com.transport.coop.model.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Route
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-01T10:44:36.661087500-05:00[America/New_York]", comments = "Generator version: 7.9.0")
public class Route {

  private String routeId;

  private String circuit;

  private String startTime;

  private String endTime;

  private String duration;

  private String occupation;

  @Valid
  private List<@Valid Stop> stops = new ArrayList<>();

  @Valid
  private List<@Valid Student> students = new ArrayList<>();

  public Route routeId(String routeId) {
    this.routeId = routeId;
    return this;
  }

  /**
   * Get routeId
   * @return routeId
   */
  
  @Schema(name = "routeId", example = "73401AM", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("routeId")
  public String getRouteId() {
    return routeId;
  }

  public void setRouteId(String routeId) {
    this.routeId = routeId;
  }

  public Route circuit(String circuit) {
    this.circuit = circuit;
    return this;
  }

  /**
   * Get circuit
   * @return circuit
   */
  
  @Schema(name = "circuit", example = "601", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("circuit")
  public String getCircuit() {
    return circuit;
  }

  public void setCircuit(String circuit) {
    this.circuit = circuit;
  }

  public Route startTime(String startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Get startTime
   * @return startTime
   */
  
  @Schema(name = "startTime", example = "07:15", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startTime")
  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public Route endTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Get endTime
   * @return endTime
   */
  
  @Schema(name = "endTime", example = "08:15", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("endTime")
  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public Route duration(String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Get duration
   * @return duration
   */
  
  @Schema(name = "duration", example = "60.49", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("duration")
  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public Route occupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  /**
   * Get occupation
   * @return occupation
   */
  
  @Schema(name = "occupation", example = "Lucien-Guilbault-les 2 Pavillons", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("occupation")
  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public Route stops(List<@Valid Stop> stops) {
    this.stops = stops;
    return this;
  }

  public Route addStopsItem(Stop stopsItem) {
    if (this.stops == null) {
      this.stops = new ArrayList<>();
    }
    this.stops.add(stopsItem);
    return this;
  }

  /**
   * Get stops
   * @return stops
   */
  @Valid 
  @Schema(name = "stops", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("stops")
  public List<@Valid Stop> getStops() {
    return stops;
  }

  public void setStops(List<@Valid Stop> stops) {
    this.stops = stops;
  }

  public Route students(List<@Valid Student> students) {
    this.students = students;
    return this;
  }

  public Route addStudentsItem(Student studentsItem) {
    if (this.students == null) {
      this.students = new ArrayList<>();
    }
    this.students.add(studentsItem);
    return this;
  }

  /**
   * Get students
   * @return students
   */
  @Valid 
  @Schema(name = "students", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("students")
  public List<@Valid Student> getStudents() {
    return students;
  }

  public void setStudents(List<@Valid Student> students) {
    this.students = students;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Route route = (Route) o;
    return Objects.equals(this.routeId, route.routeId) &&
        Objects.equals(this.circuit, route.circuit) &&
        Objects.equals(this.startTime, route.startTime) &&
        Objects.equals(this.endTime, route.endTime) &&
        Objects.equals(this.duration, route.duration) &&
        Objects.equals(this.occupation, route.occupation) &&
        Objects.equals(this.stops, route.stops) &&
        Objects.equals(this.students, route.students);
  }

  @Override
  public int hashCode() {
    return Objects.hash(routeId, circuit, startTime, endTime, duration, occupation, stops, students);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Route {\n");
    sb.append("    routeId: ").append(toIndentedString(routeId)).append("\n");
    sb.append("    circuit: ").append(toIndentedString(circuit)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    stops: ").append(toIndentedString(stops)).append("\n");
    sb.append("    students: ").append(toIndentedString(students)).append("\n");
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

