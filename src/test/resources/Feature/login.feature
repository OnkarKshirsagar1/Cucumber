#Author
#Date
#Description
Feature: Feature to test login fuctionality

  Scenario: Check login is Successfully
    Given User is on login page
    When User enters username and password
    And Click on Login button
    Then User is Navigated to Home Page
