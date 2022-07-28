@CatalogPriceRuleTest
  Feature: Marketing Manager Can Add,Update Catalog price Rule

    @AddNewCatalogPriceRule
    Scenario: Marketing manger can add catalog price rule
      Given Marketing manager on the dashboard page
      When  Marketing Manger add a new catalog price rule
      Then  The new catalog price rule should be added

    @UpdateExistingCatalogPriceRule
    Scenario: Marketing Manger Can update existing catalog price rule
      Given Marketing Manager on the dashboard page
      When  Marketing Manger update the existing catalog price rule
      Then  The new catalog price rule should be updated