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

  @ViewCustomersNewAccountReport
  Scenario: reporting manager can view Customers New Account Report
    Given reporting manager on the dashboard page
    When reporting manager opens the Customers New Account Report
    Then Customers New Account Report should be displayed


  @ViewCustomersByOrdersTotalReport
  Scenario: reporting manager can view Customers By Orders Total Report
    Given reporting manager on the dashboard page
    When reporting manager opens the Customers By Ordes Total Report
    Then Customers By Orders Total Report should be displayed