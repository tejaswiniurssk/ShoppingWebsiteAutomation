Feature: Search Page Feature

  Background:
    Given user has already logged in to application
    And user clicks on home page icon
    And user enters the Item "Printed Dress"
    And user clicks on search icon
    

  Scenario: Go to Searched Item Page
    Given user is on search page
    When Item is displayed
    Then click on the Item