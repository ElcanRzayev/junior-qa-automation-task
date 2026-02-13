# Joke API Automation Tests

This project contains automated API tests for the Official Joke API.

The goal of this task is to demonstrate basic API test automation using Java, Maven, RestAssured and Cucumber (BDD approach).

---

## Technologies Used

- Java 17
- Maven
- RestAssured
- Cucumber (BDD)
- JUnit

---

## Project Structure

src/test/java
- client → API request logic
- steps → Step definitions
- runner → Cucumber runner

src/test/resources
- features → Feature files written in Gherkin

---

## Test Coverage

The following scenarios are covered:

1. Retrieve a random joke and validate:
    - HTTP status code
    - Required fields such as setup and punchline

2. Retrieve a joke by ID:
    - Validate status code
    - Validate correct ID is returned
    - Validate response structure

3. Validate response structure using DataTable:
    - id
    - type
    - setup
    - punchline

---

## BDD Techniques Used

- Plain Scenarios
- Scenario Outline with Examples (data-driven testing)
- DataTable for validating multiple response fields
- Background section for shared setup

---

## How to Run Tests

From the project root directory:

## mvn clean test

If everything is correct, the build should finish with:


## BUILD SUCCESS

---

## Notes

The API client is implemented in a reusable way to separate request logic from step definitions.

Assertions are implemented using JUnit.

The structure follows a clean separation between:
- Test logic
- API communication
- Feature descriptions
