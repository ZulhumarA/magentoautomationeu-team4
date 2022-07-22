Feature: Reporting manager can view products related reports

  @viewProductsOrderedReport
  Scenario: reporting manager can view Products Ordered Report
    Given reporting manager on the dashboard page
    When reporting manager opens the products ordered report
    Then products ordered report should be displayed