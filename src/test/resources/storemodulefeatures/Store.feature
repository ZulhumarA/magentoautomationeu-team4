@ManageStoreTest
Feature: Store manager can manage stores


Background:
  Given user Already on the login page
  When user enter valid userName  and valid Password and click on login Button
  Then user should able to login successfully

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

 # Kadirya
  @CanAddProduct
  Scenario: store manager can add product
    Given store manager on the dashboard page
    When store manager should be able to add product
    Then a new product should be added