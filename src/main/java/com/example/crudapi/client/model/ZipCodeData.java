package com.example.crudapi.client.model;

import lombok.Data;

import java.util.List;

@Data
public class ZipCodeData {
    private String country;
    private List<Place> places;
}
