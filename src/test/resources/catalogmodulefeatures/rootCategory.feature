@RootCategoryTests
  Feature: Catalog Manager can manage root categories

    @addRootCategories
    Scenario: Catalog Manager can add root categories
      Given catalog manager on the dashboard page
      When catalog manager add a new root catagory
      Then the root category should be displayed

