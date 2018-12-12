# Spring Boot Example with Camel REST DSL, Geocoder and Swagger

### Introduction

This example illustrates integration with Google Geocoder Api using Spring Boot, Swagger
and geocoder component.

### Build

First you need to enter in application.properties and edit this key

google.api.key=<REPLACE_WITH_YOUR_API_KEY>

NOTE: if you don't have a key you need to create one https://developers.google.com/maps/documentation/javascript/get-api-key

You can build this example using:

    $ mvn package

### Run

You can run this example using:

    $ mvn spring-boot:run

After the Spring Boot application is started

You can also access the REST endpoint from the command line:

    $ curl --header "Content-Type: application/json" http://localhost:8080/camel/geocoder/?address=Paris


The command will produce the following output:

----
{
  "status" : "OK",
  "results" : [ {
    "types" : [ "locality", "political" ],
    "formattedAddress" : "Paris, France",
    "addressComponents" : [ {
      "longName" : "Paris",
      "shortName" : "Paris",
      "types" : [ "locality", "political" ]
    }, {
      "longName" : "Paris",
      "shortName" : "Paris",
      "types" : [ "administrative_area_level_2", "political" ]
    }, {
      "longName" : "Île-de-France",
      "shortName" : "Île-de-France",
      "types" : [ "administrative_area_level_1", "political" ]
    }, {
      "longName" : "France",
      "shortName" : "FR",
      "types" : [ "country", "political" ]
    } ],
    "geometry" : {
      "location" : {
        "lat" : 48.856614,
        "lng" : 2.3522219
      },
      "locationType" : "APPROXIMATE",
      "viewport" : {
        "southwest" : {
          "lat" : 48.815573,
          "lng" : 2.225193
        },
        "northeast" : {
          "lat" : 48.9021449,
          "lng" : 2.4699208
        }
      },
      "bounds" : {
        "southwest" : {
          "lat" : 48.815573,
          "lng" : 2.224199
        },
        "northeast" : {
          "lat" : 48.9021449,
          "lng" : 2.4699208
        }
      }
    },
    "partialMatch" : false
  } ]
}
----

The Swagger documentation is located at: http://localhost:8080/camel/api-doc and can be retrieved with the following command:

    $ curl http://localhost:8080/camel/api-doc

The Spring Boot application can be stopped pressing `[CTRL]`+`[C]` in the shell.