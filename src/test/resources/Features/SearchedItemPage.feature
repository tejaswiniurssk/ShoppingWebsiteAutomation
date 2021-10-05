Feature: Searched Item Page Feature

  Background:
    Given user has already logged in to application
    Then user clicks on home page icon
    When user enters the Item "Printed Dress"
    Then user clicks on search icon
    When Item is displayed
    Then click on the Item

    Scenario: add Item to cart
      Given user is on Searched Item Page
      Then user clicks on add to cart