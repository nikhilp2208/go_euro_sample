package com.example.go_euro_sample;

import com.example.go_euro_sample.client.GoEuroClient;
import com.example.go_euro_sample.client.GoEuroDataExporter;
import com.example.go_euro_sample.client.impl.CsvDataExporter;
import com.example.go_euro_sample.client.impl.GoEuroClientImpl;
import com.example.go_euro_sample.models.Position;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by nikhil.p on 25/09/16.
 */
public class GoEuro {
    private static final Logger log = Logger.getLogger(GoEuro.class);
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java -jar goEuro.jar <CityName1> <CityName2>..");
        }
        List<String> cityNames = ArgumentsParser.getCityNames(args);

        GoEuroClient goEuroClient = new GoEuroClientImpl();
        List<Position> allPositions = new ArrayList<>();
        cityNames.forEach(city -> {
            List<Position> positions = goEuroClient.getPostionsFromGoEuro(city);
            if (Objects.nonNull(positions)) allPositions.addAll(positions);
        });

        GoEuroDataExporter goEuroDataExporter = new CsvDataExporter();
        goEuroDataExporter.exportPositionsData(allPositions,"goeuro_data.csv");
    }
}
