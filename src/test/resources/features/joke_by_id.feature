Feature: Joke API response structure validation

  Background:
    Given the Joke API is available

  Scenario: Verify random joke contains required fields
    When I request a random joke
    Then the response status should be 200
    And the response should contain required fields:
      | id        |
      | type      |
      | setup     |
      | punchline |
