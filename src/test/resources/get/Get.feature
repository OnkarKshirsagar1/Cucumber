@tag
Feature: Validating GET API

  @tag1
  Scenario: GET request verification
    Given User Send the GET request to Server
    When User will get GET response from Server
    Then User Validate GET Responce Status code and Response Body