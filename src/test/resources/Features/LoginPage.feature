Feature: Login page feature


  Scenario: Login page title
    Given user is on login page
    Then page title should be "Login - My Store"
    Then forgot your password link should be displayed

  Scenario: Login with correct credentials
    Given user is on login page
    When user logs into the application
    Then user will be navigated to Accounts Page