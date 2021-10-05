Feature: Order Page Feature

  Background:
    Given user has already logged in to application
    Then user clicks on home page icon
    When user enters the Item "Printed Dress"
    Then user clicks on search icon
    When Item is displayed
    Then click on the Item
    Then user clicks on add to cart

    Scenario: validate the cart item
      Given user in on Order Page
      Then searched Item and cart Item are "Printed Dress"