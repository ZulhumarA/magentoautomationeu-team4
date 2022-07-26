
@ViewCouponsCreditMemosAndShoppingCart
Feature: Sales Manager should be able to view coupons in the Reports, view and add credit memos,  manage view shopping cart for customers

  @ViewCouponsInTheReports
  Scenario: Sales Manager can view coupons in the Reports
    Given Sales Manager on the dashboard page
    When Sales Manager enters the dates in the Reports
    Then Sales Manager can view coupons between dates in Reports

  @ManageViewShoppingCartForCustomers
  Scenario: Sales Manager can manage view shopping cart for customers
    Given Sales Manager on the dashboard page
    When Sales Manager views shopping cart
    Then Shopping cart should be viewed


  @ViewAndAddCreditMemos
  Scenario: Sales Manager can view and add credit memos
    Given Sales Manager on the dashboard page
    When Sales Manager views and add credit memos
    Then The credit memos should be added
