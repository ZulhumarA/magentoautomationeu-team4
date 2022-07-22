Feature: Marketing manager can manage Newsletter templates and can see the newsletter subscribers

    @AddNewsletterTemplate
    Scenario: marketing manager can add a newsletter template
      Given marketing manager on the dashboard page
      When marketing manager adds a newsletter template
      Then a new newsletter template should be added

    @UpdateNewsletterTemplate
    Scenario: marketing manager can update a newsletter template
      Given marketing manager on the dashboard page
      When marketing manager updates a newsletter template
      Then the newsletter template should be updated

    @deleteNewsletterTemplate
    Scenario: marketing manager can delete a newsletter template
      Given marketing manager on the dashboard page
      When marketing manager deletes a newsletter template
      Then the newsletter template should be deleted

    @ViewNewsletterSubscribers
    Scenario: marketing manager can view newsletter subscribers
      Given marketing manager on the dashboard page
      When marketing manager views newsletter subscribers
      Then newsletter subscribers should be viewed


      