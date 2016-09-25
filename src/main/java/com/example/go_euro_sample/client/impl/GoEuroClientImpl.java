package com.example.go_euro_sample.client.impl;

import com.example.go_euro_sample.Utils;
import com.example.go_euro_sample.client.GoEuroClient;
import com.example.go_euro_sample.models.Position;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by nikhil.p on 25/09/16.
 */
public class GoEuroClientImpl implements GoEuroClient {
    private static final Logger log = Logger.getLogger(GoEuroClientImpl.class);
    private static final String GOEURO_BASE_URL = "http://api.goeuro.com/api";
    private static final ObjectMapper objectMapper;
    private int a = 1;

    static {
        objectMapper = new ObjectMapper();
    }

    @Override
    public List<Position> getPostionsFromGoEuro(String city) {
        String encodedCity = Utils.getUrlEncodedCity(city);
        if(Objects.isNull(encodedCity) || encodedCity.isEmpty()) return null;

        String _url = GOEURO_BASE_URL+"/v2/position/suggest/en/"+ encodedCity;
        List<Position> positions = new ArrayList<>();
        log.info("Calling "+ _url + " to get data for city: "+ city);

        try {
            URL url = new URL(_url);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpCon.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            log.debug("Getting Position from the response " + response);
            positions = getPositionsFromResponse(response.toString());
            if(positions.size() == 0) {
                log.info("No data found for city "+city);
            }
        } catch (IOException e) {
            log.error("Error occured while getting data for city: "+ city);
            log.error(e);
        }
        return positions;
    }

    private List<Position> getPositionsFromResponse(String response) throws IOException {
        return objectMapper.readValue(response,new TypeReference<List<Position>>() {});
    }
}