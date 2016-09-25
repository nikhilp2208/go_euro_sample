package com.example.go_euro_sample.client.impl;

import com.example.go_euro_sample.client.GoEuroDataExporter;
import com.example.go_euro_sample.models.Position;
import com.opencsv.CSVWriter;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikhil.p on 25/09/16.
 */
public class CsvDataExporter implements GoEuroDataExporter {
    private static final Logger log = Logger.getLogger(CsvDataExporter.class);

    @Override
    public void exportPositionsData(List<Position> positions, String file) throws IOException {
        log.info("Exporting data to csv");
        log.debug(positions);
        CSVWriter writer = new CSVWriter(new FileWriter(file), ',');
        List<String[]> csvList = new ArrayList<>();
        positions.forEach(position -> {
            csvList.add(new String[]{position.getId().toString(),
                    position.getName(),
                    position.getType(),
                    position.getGeoPosition().getLatitude().toString(),
                    position.getGeoPosition().getLongitude().toString()});
        });
        writer.writeAll(csvList,true);
        writer.close();
        log.info("Exported data to csv");
    }
}
