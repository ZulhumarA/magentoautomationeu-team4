Feature: Feature: Marketing manager can manage Newsletter templates and can see the newsletter subscribers


  @AddNewsletterTemplate
  Scenario: marketing manager can add a newsletter template
    Given marketing manager on the dashboard page
    When marketing manager add a newsletter template
    Then a new newsletter template should be added