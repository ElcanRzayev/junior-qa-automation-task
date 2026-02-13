Feature: Joke by ID

  Scenario Outline: Retrieve a joke by id using different ids
    When I request a joke with id <id>
    Then the response status should be 200
    And the response field "id" should equal <id>
    And the response should contain field "setup"
    And the response should contain field "punchline"

    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |