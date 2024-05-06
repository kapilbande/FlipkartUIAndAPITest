package com.mystore.testcases;


import io.restassured.RestAssured;
import io.restassured.response.Response;
public class FlipkartAPI {
    private String baseURI = "https://your-dummy-flipkart-api.com";
    private String endpoint = "/products/search";

    public Response searchProducts(String mobileName, boolean flipkartAssured, int storage) {
        return RestAssured.given()
                .baseUri(baseURI)
                .basePath(endpoint)
                .queryParam("mobileName", mobileName)
                .queryParam("flipkartAssured", flipkartAssured ? "yes" : "no")
                .queryParam("storage", storage)
                .header("Authorization", "Bearer your_dummy_token")
                .when()
                .get();

    }


}
