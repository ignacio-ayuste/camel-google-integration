package com.excercise.camelgoogleintegration;

import com.google.maps.model.GeocodingResult;
import org.apache.camel.CamelContext;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Ignore("Run this test Manual")
public class ApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CamelContext camelContext;

    @Test
    public void geocoderAddressTest() {
        ResponseEntity<GeocodingResult[]> response = restTemplate.exchange("/camel/geocoder?address=Paris",
                HttpMethod.GET, null, new ParameterizedTypeReference<GeocodingResult[]>() {
                });
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        GeocodingResult[] res = response.getBody();
        assertNotNull(res);
    }
}