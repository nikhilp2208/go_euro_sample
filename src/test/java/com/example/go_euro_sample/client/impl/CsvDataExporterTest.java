package com.example.go_euro_sample.client.impl;

import com.example.go_euro_sample.client.GoEuroDataExporter;
import com.example.go_euro_sample.models.GeoPosition;
import com.example.go_euro_sample.models.Position;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikhil.p on 25/09/16.
 */
public class CsvDataExporterTest {
    private static String outputFile = "test.csv";
    @Before
    public void setUp() throws Exception {
        new File(outputFile).delete();
    }

    @After
    public void tearDown() throws Exception {
        new File(outputFile).delete();
    }

    @Test
    public void exportPositionsData() throws Exception {
        GoEuroDataExporter dataExporter = new CsvDataExporter();
        List<Position> positions = new ArrayList<>();
        positions.add(Position.builder().id(1223L)
        .name("Berlin")
        .type("airport")
        .geoPosition(new GeoPosition(10.23,123.23))
        .build());
        dataExporter.exportPositionsData(positions,outputFile);

        FileReader fileReader = new FileReader(new File(outputFile));
        BufferedReader br = new BufferedReader(fileReader);
        String csvLine = br.readLine();
        String expectedLine = "\"1223\",\"Berlin\",\"airport\",\"10.23\",\"123.23\"";
        Assert.assertEquals(expectedLine,csvLine);
    }

}