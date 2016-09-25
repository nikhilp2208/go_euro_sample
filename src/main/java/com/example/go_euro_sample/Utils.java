package com.example.go_euro_sample;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by nikhil.p on 25/09/16.
 */
public class Utils {
    private static final Logger log = Logger.getLogger(Utils.class);

    public static String getUrlEncodedCity(String city) {
        String encodedCity = "";
        try {
            encodedCity = URLEncoder.encode(city, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("Error occured while encoding the city");
            return null;
        }
        return encodedCity;
    }
}
