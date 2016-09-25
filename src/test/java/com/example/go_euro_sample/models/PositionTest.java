package com.example.go_euro_sample.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nikhil.p on 25/09/16.
 */
public class PositionTest {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static String testString = "{\"_id\":1223,\"key\":null,\"name\":\"Berlin\",\"fullName\":null,\"iata_airport_code\":null,\"type\":\"airport\",\"country\":null,\"geo_position\":{\"latitude\":10.23,\"longitude\":123.23},\"locationId\":null,\"inEurope\":null,\"countryId\":null,\"countryCode\":null,\"coreCountry\":null,\"distance\":null,\"names\":null,\"alternativeNames\":null}";
    @Test
    public void testPositionSerializationDeserialization() throws Exception {
        Position position = Position.builder()
                .id(1223L)
                .name("Berlin")
                .type("airport")
                .geoPosition(new GeoPosition(10.23,123.23))
                .build();

        position.toString();

        String serializedString = objectMapper.writeValueAsString(position);
        Position position1 = objectMapper.readValue(serializedString,Position.class);
        Assert.assertEquals(testString,serializedString);
        Assert.assertEquals(position,position1);
    }
}