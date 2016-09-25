package com.example.go_euro_sample;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nikhil.p on 25/09/16.
 */
public class UtilsTest {
    @Test
    public void getUrlEncodedCityWithSpace() throws Exception {
        String encodedCity = Utils.getUrlEncodedCity("New York");
        Assert.assertEquals("New+York",encodedCity);
    }

    @Test
    public void getUrlEncodedCityWithoutSpace() throws Exception {
        String encodedCity = Utils.getUrlEncodedCity("Berlin");
        Assert.assertEquals("Berlin",encodedCity);
    }
}