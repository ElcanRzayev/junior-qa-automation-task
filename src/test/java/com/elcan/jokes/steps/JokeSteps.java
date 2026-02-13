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
    @When("I request a joke with id {int}")
    public void iRequestAJokeWithId(int id) {
        response = client.getJokeById(id);
    }
    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int expectedStatus) {
        assertNotNull("Response is null - request was not executed", response);
        assertEquals("Unexpected HTTP status code", expectedStatus, response.statusCode());
    }
    @Then("the response should contain field {string}")
    public void theResponseShouldContainField(String fieldName) {
        JsonPath json = response.jsonPath();
        Object value = json.get(fieldName);

        assertNotNull("Expected field '" + fieldName + "' to exist, but it was null/missing", value);

        // If it's a string, ensure it's not empty
        if (value instanceof String) {
            assertFalse("Expected field '" + fieldName + "' not to be empty",
                    ((String) value).trim().isEmpty());
        }
    }
    @Then("the response field {string} should equal {int}")
    public void theResponseFieldShouldEqual(String fieldName, int expectedValue) {
        JsonPath json = response.jsonPath();
        int actual = json.getInt(fieldName);
        assertEquals("Field '" + fieldName + "' did not match expected value", expectedValue, actual);
    }
    @Then("the response should contain required fields:")
    public void theResponseShouldContainRequiredFields(DataTable dataTable) {
        List<String> fields = dataTable.asList();
        for (String field : fields) {
            theResponseShouldContainField(field);
        }
    }
    }