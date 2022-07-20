Feature: Marketing manager can manage Newsletter templates and can see the newsletter subscribers

  Background:
    Given admin user already on the login page
    When marketing manager enters valid username and password and click on login button
    Then manager should be able to login successfully

    @AddNewsletterTemplate
    Scenario: marketing manager can add a newsletter template
      Given marketing manager on the dashboard page
      When marketing manager add a newsletter template
      Then marketing manager should be able to add a new newsletter template
