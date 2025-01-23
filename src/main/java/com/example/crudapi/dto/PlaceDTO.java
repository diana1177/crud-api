package com.example.crudapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceDTO {
    private String placeName;
    private String longitude;
    private String latitude;
    private String state;
}
