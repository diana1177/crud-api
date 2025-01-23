package com.example.crudapi.client;

import com.example.crudapi.client.model.ZipCodeData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface ZipCodeClient {

    @GetExchange("/us/{zipcode}")
    ZipCodeData getZipCodeInformation(@PathVariable String zipcode);
}
