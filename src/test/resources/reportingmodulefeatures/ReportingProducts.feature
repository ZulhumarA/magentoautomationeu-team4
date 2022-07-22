Feature: Reporting manager can view products related reports

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

