Feature: Home Page Feature

  Background:
    Given user has already logged in to application
    And user clicks on home page icon

  Scenario: Home Page Title
    Given user is on Home Page
    When homePage logo is displayed
    Then home page title should be "My Store"

  
  Scenario Outline: Search an Item
    Given search bar is displayed
    When user enters the Item "<SheetName>" <Rownum>
    Then user clicks on search icon

    Examples:
    |SheetName| Rownum |
    | Items   | 0      |