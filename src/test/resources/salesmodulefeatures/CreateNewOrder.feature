@CreateNewOrderTest

  Feature: Sales Manager should be able to create a new order

    @CreateNewOrder
    Scenario: Sales Manager should be able to create a new order
      Given Sales Manager on the dashboard page
      When Sales Manager create a new order
      Then New Order is created
