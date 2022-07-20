Feature: admin user can login the system successfully

  Scenario: store manager can login with valid username and password
    Given admin user already on the login page
    When store manager enters valid username and password to click on login button
    Then store manager should be able to login successfully

  Scenario: marketing manager can login with valid username and password
    Given admin user already on the login page
    When marketing manager enters valid username and password to click on login button
    Then marketing manager should be able to login successfully

  Scenario: sales manager can login with valid username and password
    Given admin user already on the login page
    When marketing manager enters valid username and password to click on login button
    Then marketing manager should be able to login successfully

  Scenario: reporting manager can login with valid username and password
    Given admin user already on the login page
    When reporting manager enters valid username and password to click on login button
    Then reporting manager should be able to login successfully
