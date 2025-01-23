package com.example.crudapi.configuration;

import com.example.crudapi.client.ZipCodeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ZipCodeClientConfiguration {

    @Value("${zip.code.url}")
    private String ZIP_CODE_URL;


    @Bean
    public ZipCodeClient zipCodeClient() {
        RestClientAdapter adapter = RestClientAdapter.create(restClient());
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(ZipCodeClient.class);
    }

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(ZIP_CODE_URL)
                .build();
    }
}
