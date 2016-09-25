package com.example.go_euro_sample;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nikhil.p on 25/09/16.
 */
public class ArgumentsParser {
    public static List<String> getCityNames(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -jar goEuro.jar <CityName1> <CityName2>..");
            System.exit(0);
        }
        //Add validations
        return Arrays.asList(args);
    }
}
