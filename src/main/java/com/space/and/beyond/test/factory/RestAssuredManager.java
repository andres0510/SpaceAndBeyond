package com.space.and.beyond.test.factory;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.ValidatableResponse;

public class RestAssuredManager {

    private RestAssuredManager() {}

    public static ValidatableResponse callGET(String baseUri, String resource) {
        return RestAssured.given()
                              .baseUri(baseUri)
                           .when()
                              .get(resource)
                           .then();
    }

    public static ValidatableResponse callPOST(String baseUri, String resource, Object body) {
        Header header = new Header("Content-Type", "application/json");
        return RestAssured.given()
                              .header(header).baseUri(baseUri)
                          .when()
                              .body(body).post(resource)
                          .then();
    }

}
