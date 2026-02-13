# Development Log

## Initial Setup

- Created Maven project
- Configured dependencies (RestAssured, Cucumber, JUnit)
- Set up basic project structure

## Feature Design

Started with writing feature files first to define the expected behavior of the API.  
This helped clarify what needs to be validated before implementing the test logic.

Implemented:
- Random joke scenario
- Joke by ID using Scenario Outline
- Structure validation using DataTable

## Step Definitions

Created step definitions matching the feature files.  
Used JsonPath for response validation.

Assertions include:
- Status code validation
- Field existence validation
- Field value validation

## API Client

Separated API logic into a dedicated client class.

This makes the code cleaner and easier to maintain.

## Refactoring

Moved utility classes to test scope to align with Maven structure.  
Improved naming and formatting for readability.

## Final Verification

All scenarios executed successfully using:

## mvn clean test

Build result: BUILD SUCCESS

The project is now ready for submission.
