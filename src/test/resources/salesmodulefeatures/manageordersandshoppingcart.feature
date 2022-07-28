                             #***********Abide************
@ManageOrdersAndUpdateShoppingCart
  Feature: sales manager should be able to manage orders and update shopping cart

    @SalesManagerCanManageOrders
    Scenario: sales manage should be able to create,edit and delete orders
      Given sales Manager on the dashboard page
      When sales manager should be able to create orders
      Then orders should be created successfully
      When sales manager should be able to edit orders
      Then orders edited successfully
      When sales manager should be able to cancel orders
      Then orders canceled successfully


    @SalesManagerCanUpdateShoppingCart
    Scenario: sales manager should be able to update customers shopping cart
      Given sales Manager on the dashboard page
      When Sales Manager update the customers shopping cart
      Then shopping cart should be updated successfully