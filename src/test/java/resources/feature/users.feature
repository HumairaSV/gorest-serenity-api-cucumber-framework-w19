Feature: Testing Users features on GoRest Application

  Scenario: Check if the GoRest application can be accessed by users
    When User sends a GET request to users endpoint
    Then User must get back a valid status code 200

  Scenario: Create new user and verify if the user is added
    When User creates a new user by providing the information name "Jimmy Smith" gender "male" email "jimmysmith@gmail.com" status "active"
    Then User verifies that the user is created

    Scenario: Update the created user and verify user is updated with status 200
      When User updates created user by providing the information name "Jimmy Smiths" email "jimmysmith1@gmail.com"
      Then User verifies user is updated

      Scenario: Delete created user using id
        When User delete created user using id
        Then User verifies user is deleted with status code 204