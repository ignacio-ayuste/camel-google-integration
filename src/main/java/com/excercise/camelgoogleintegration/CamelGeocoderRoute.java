package com.excercise.camelgoogleintegration;

import com.google.maps.model.GeocodingResult;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.apache.camel.model.rest.RestParamType.query;

@Component
public class CamelGeocoderRoute extends RouteBuilder {


    @Value("${google.api.key}")
    private String apiKey;

    @Override
    public void configure() throws Exception {
        System.out.println("API KEY" + apiKey);

        rest("/geocoder").description("Geocoder REST service")
                .consumes("application/json")
                .produces("application/json")
                .get()
                .description("Geocoder address lookup")
                .outType(GeocodingResult[].class)
                .param().name("address").type(query).description("The address to lookup").dataType("string").endParam()
                .responseMessage().code(200).message("Geocoder successful").endResponseMessage()
                .toD("geocoder:address:${header.address}?apiKey=" + apiKey);

    }

}
