Feature: Searched Item Page Feature

  Background:
    Given user has already logged in to application
    And user clicks on home page icon
    And user enters the Item "Printed Dress"
    And user clicks on search icon
    And Item is displayed
    And click on the Item

    Scenario: add Item to cart
      Given user is on Searched Item Page
      When "Printed Dress" is Displayed
      Then user clicks on add to cart