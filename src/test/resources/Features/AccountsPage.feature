Feature: Accounts Page Feature

  Background:
    Given user has already logged in to application

@accounts
  Scenario: Accounts page title
    Given user is on Accounts page
    When my account label is displayed
    Then user clicks on home page icon