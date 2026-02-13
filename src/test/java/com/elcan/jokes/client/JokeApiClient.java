package com.elcan.jokes.client;

import com.elcan.jokes.config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JokeApiClient {

    public JokeApiClient() {
        RestAssured.baseURI = ApiConfig.BASE_URL;
    }

    // GET https://official-joke-api.appspot.com/random_joke
    public Response getRandomJoke() {
        return RestAssured
                .given()
                .when()
                .get("/random_joke")
                .then()
                .extract()
                .response();
    }

    // GET https://official-joke-api.appspot.com/jokes/{id}
    public Response getJokeById(int id) {
        return RestAssured
                .given()
                .when()
                .get("/jokes/" + id)
                .then()
                .extract()
                .response();
    }
}
