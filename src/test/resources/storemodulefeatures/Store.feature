@ManageStoreTest
Feature: Store manager can manage stores

#store manager should be able to create a store view-Zulhumar
  @CreateStoreView
  Scenario Outline: store manager can create a store view
    Given store manager on the dashboard page
    When store manager create a new store view
    Then successfully created message should be displayed
    Examples: :
  | StoreName             | StoreID |    |StatusField|
  | Zulhumaraman          | aqswde  |    | Enabled |



 # store manager should be able to edit a store view-Zulhumar
  @EditStoreView
  Scenario: store manager can edit a store view
    Given store manager on the dashboard page
    When store manager edit a store view
    Then successfully edited message should be displayed

  # store manager should be able to update product--Kadirya
  @UpdateProduct
  Scenario: store manager can update a product
    Given store manager on the dashboard page
    When store manager uptaded product information
    Then successfully edited message should be displayed
