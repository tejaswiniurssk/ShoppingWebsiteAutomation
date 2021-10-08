Feature: Order Page Feature

  Background:
    Given user has already logged in to application
    And user clicks on home page icon
    And user enters the Item "Printed Dress"
    And user clicks on search icon
    And Item is displayed
    And click on the Item
    And user clicks on add to cart

    Scenario: validate the cart item
      Given user in on Order Page
      When cart summery is displayed
      Then searched Item and cart Item are "Printed Dress"