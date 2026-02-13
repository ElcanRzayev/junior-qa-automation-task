Feature: Random Joke

  Scenario: Get a random joke and verify response structure
    When I request a random joke
    Then the response status should be 200
    And the response should contain field "setup"
    And the response should contain field "punchline"