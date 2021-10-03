#Author
#Date
#Description
#@SmokeFeature
Feature: Feature to kite login fuctionality

  #@SmokeTest
  Scenario Outline: Check kite login is Successfully
    Given User is at kite loginpage
    When enters kite <username> and <password>
    And Click on kite Login button
    Then Validate Pin Page
 
    

    Examples: 
      | username | password    |
      | YE4707   | OK@ojas1805 |
      | YE4707   | OK@ojas1805 |
