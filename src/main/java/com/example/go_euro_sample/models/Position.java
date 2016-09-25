package com.example.go_euro_sample.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * Created by nikhil.p on 25/09/16.
 */

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {
    @JsonProperty("_id")
    private Long id;
    private String key;
    private String name;
    private String fullName;
    @JsonProperty("iata_airport_code")
    private String iataAirportCode;
    private String type; //Can be changed to Enum if a list of types are provided.
    private String country;
    @JsonProperty("geo_position")
    private GeoPosition geoPosition;
    private Long locationId;
    private Boolean inEurope;
    private Long countryId;
    private String countryCode;
    private Boolean coreCountry;
    private Double distance;
    private Map<String,String> names;
    private Map<String,String> alternativeNames;
}
