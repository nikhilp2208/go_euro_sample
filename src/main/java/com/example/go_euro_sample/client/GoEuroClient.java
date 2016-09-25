package com.example.go_euro_sample.client;

import com.example.go_euro_sample.models.Position;

import java.util.List;

/**
 * Created by nikhil.p on 25/09/16.
 */
public interface GoEuroClient {
    List<Position> getPostionsFromGoEuro(String city);
}
