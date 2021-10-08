Feature: Login page feature


  Scenario: Login page title
    Given user is on login page
    When forgot your password link is displayed
    Then page title should be "Login - My Store"
    

  Scenario: Login with correct credentials
    Given user is on login page
    When user logs into the application
    Then user will be navigated to Accounts Page