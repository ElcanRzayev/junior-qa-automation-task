package com.elcan.jokes.steps;

import com.elcan.jokes.client.JokeApiClient;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static org.junit.Assert.*;

public class JokeSteps {

    private final JokeApiClient client = new JokeApiClient();
    private Response response;

    @Given("the Joke API is available")
    public void theJokeApiIsAvailable() {
        // Public API - no dedicated health endpoint required for this task.
        // This step exists mainly to demonstrate "Background" usage.
    }

    @When("I request a random joke")
    public void iRequestARandomJoke() {
        response = client.getRandomJoke();

    }