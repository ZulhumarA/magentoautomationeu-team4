@ReportingModuleTests
Feature: Reporting manager can view related reports

  @ViewProductsOrderedReport
  Scenario: reporting manager can view Products Ordered Report
    Given reporting manager on the dashboard page
    When reporting manager opens the products ordered report
    Then products ordered report should be displayed

  @ViewProductsMostViewedReport
  Scenario: reporting manager can view Products Most Viewed Report
    Given reporting manager on the dashboard page
    When reporting manager opens the products most viewed report
    Then products most viewed report should be displayed

  @ViewProductsLowStockReport
  Scenario: reporting manager can view Products Low Stock Report
    Given reporting manager on the dashboard page
    When reporting manager opens the products low stock report
    Then products low stock report should be displayed
   #zulhumar
  @ViewCustomersNewAccountReport
  Scenario: reporting manager can view Customers New Account Report
    Given reporting manager on the dashboard page
    When reporting manager opens the Customers New Account Report
    Then Customers New Account Report should be displayed

   #zulhumar
  @ViewCustomersByOrdersTotalReport
  Scenario: reporting manager can view Customers By Orders Total Report
    Given reporting manager on the dashboard page
    When reporting manager opens the Customers By Orders Total Report
    Then Customers By Orders Total Report should be displayed
   #zulhumar
  @ViewCustomersByNumberOfOrdersReport
  Scenario: reporting manager can view Customers By Number Of Orders Report
    Given reporting manager on the dashboard page
    When reporting manager opens the Customers By Number Of Orders Report
    Then Customers By Number Of Orders Report should be displayed
    @ViewReviewers
    Scenario: Reporting Manage Should be able to see Product Reviewers
      Given reporting manager on the dashboard page
      When reporting manager opens the Products Reviews page
      Then product reviews should be displayed

       # ***************** Kadirya ************************


  @SeeSalesTotalShippedReport
  Scenario: Reporting Manage Should be able to see sales Total Shipping Report
    Given reporting manager on the dashboard page
    When reporting manager opens the Sales Total Shipping Report
    Then  Total Shipping should be displayed



     @SeeSalesTotalRefundedReport
     Scenario: Reporting Manage Should be able to see sales Total Refunded Report
       Given reporting manager on the dashboard page
       When reporting manager opens the Sales Total Refunded Report
       Then  Total Refunded should be displayed


  @SeeSalesCouponsUsageReport
  Scenario: Reporting Manage Should be able to see sales Coupons Usage Report
    Given reporting manager on the dashboard page
    When reporting manager opens the Sales Coupons Report
    Then  Coupons Usage should be displayed
