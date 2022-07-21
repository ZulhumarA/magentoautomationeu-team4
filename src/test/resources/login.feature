Feature: admin user can login the system successfully

  @StoreManagerLogin
  Scenario: store manager can login with valid username and password
    Given admin user already on the login page
    When store manager enters valid username and password and click on login button
    Then manager should be able to login successfully

  @MarketingManagerLogin
  Scenario: marketing manager can login with valid username and password
    Given admin user already on the login page
    When marketing manager enters valid username and password and click on login button
    Then manager should be able to login successfully

  @SalesManagerLogin
  Scenario: sales manager can login with valid username and password
    Given admin user already on the login page
    When sales manager enters valid username and password and click on login button
    Then manager should be able to login successfully

  @ReportingManagerLogin
  Scenario: reporting manager can login with valid username and password
    Given admin user already on the login page
    When reporting manager enters valid username and password and click on login button
    Then manager should be able to login successfully
