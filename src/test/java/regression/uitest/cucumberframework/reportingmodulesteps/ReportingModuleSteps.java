package regression.uitest.cucumberframework.reportingmodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.reportingmodule.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ReportingModuleSteps extends TestBase {

    AdminLoginPage adminLoginPage;
    ProductsOrderedReportPage productsOrderedReportPage;
    ProductsMostViewedReportPage productsMostViewedReportPage;
    ProductsLowStockReportPage productsLowStockReportPage;
    SeeCustomersNewAccountReport seeCustomersNewAccountReport;
    SeeCustomerByOrdersTotalReport seeCustomerByOrdersTotalReport;
    SeeCustomerByNumberOfOrders seeCustomerByNumberOfOrders;
    SeeProductReviews seeProductReviews;
    String configFile = "config.properties";

    @Before("@ReportingModuleTests")
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile, "backEndURL"));
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
    }

    @Given("reporting manager on the dashboard page")
    public void reportingManagerOnTheDashboardPage() {
        adminLoginPage = new AdminLoginPage(driver);
        Assert.assertTrue(adminLoginPage.verifyAdminLoginSuccessfully());
        productsOrderedReportPage = new ProductsOrderedReportPage(driver);
        productsMostViewedReportPage = new ProductsMostViewedReportPage(driver);
        productsLowStockReportPage = new ProductsLowStockReportPage(driver);
        seeCustomersNewAccountReport = new SeeCustomersNewAccountReport(driver);
        seeCustomerByOrdersTotalReport = new SeeCustomerByOrdersTotalReport(driver);
        seeCustomerByNumberOfOrders = new SeeCustomerByNumberOfOrders(driver);
        seeProductReviews=new SeeProductReviews(driver);
    }

    // products ordered report test case (Gvlmihre)
    @When("reporting manager opens the products ordered report")
    public void reportingManagerOpensTheProductsOrderedReport() {
        productsOrderedReportPage.viewProductsOrderedReport("01/01/2020", "01/01/2022");
    }

    @Then("products ordered report should be displayed")
    public void productsOrderedReportShouldBeDisplayed() {
        productsOrderedReportPage.verifyProductsOrderedReportDisplayed();
    }

    //products most viewed report test case (Gvlmihre)
    @When("reporting manager opens the products most viewed report")
    public void reportingManagerOpensTheProductsMostViewedReport() {
        productsMostViewedReportPage.viewProductsMostViewedReport("1/1/2020", "1/1/2022");
    }

    @Then("products most viewed report should be displayed")
    public void productsMostViewedReportShouldBeDisplayed() {
        productsMostViewedReportPage.verifyProductsMostViewedReportDisplayed();
    }

    //products low stock report test case (Gvlmihre)
    @When("reporting manager opens the products low stock report")
    public void reportingManagerOpensTheProductsLowStockReport() {
        productsLowStockReportPage.viewProductsLowStockReport();
    }

    @Then("products low stock report should be displayed")
    public void productsLowStockReportShouldBeDisplayed() {
        productsLowStockReportPage.verifyProductsLowStockReportDisplayed();
    }


    //open the Customers New Account Report-Zulhumar
    @When("reporting manager opens the Customers New Account Report")
    public void reportingManagerOpensTheCustomersNewAccountReport() throws InterruptedException {
        seeCustomersNewAccountReport.OpenCustomersNewAccountReportPage();
        seeCustomersNewAccountReport.ShowNewAccountReportMethod(ApplicationConfig.readFromConfigProperties(
                        "config.properties", "startDate"),
                ApplicationConfig.readFromConfigProperties(
                        "config.properties", "endDate"));

    }

    @Then("Customers New Account Report should be displayed")
    public void customersNewAccountReportShouldBeDisplayed() {
        Assert.assertTrue(seeCustomersNewAccountReport.verifyReportsDisplayed());
    }

    //open the Customers By Orders Total Report-Zulhumar
    @When("reporting manager opens the Customers By Orders Total Report")
    public void reportingManagerOpensTheCustomersByOrdersTotalReport() throws InterruptedException {
        seeCustomerByOrdersTotalReport.OpenCustomerByOrdersTotalReportPage();
        seeCustomerByOrdersTotalReport.ShowCustomersByOrdersTotalReportMethod(
                ApplicationConfig.readFromConfigProperties(
                        "config.properties", "startDate1"),
                ApplicationConfig.readFromConfigProperties(
                        "config.properties", "endDate1"));
    }

    @Then("Customers By Orders Total Report should be displayed")
    public void customersByOrdersTotalReportShouldBeDisplayed() {
        Assert.assertTrue(seeCustomerByOrdersTotalReport.verifyReportsDisplayed());
    }

    //open the Customers By Number Of Orders Report-Zulhumar
    @When("reporting manager opens the Customers By Number Of Orders Report")
    public void reportingManagerOpensTheCustomersByNumberOfOrdersReport() throws InterruptedException {

        seeCustomerByNumberOfOrders.OpenCustomerByNumberOfOrdersPage();
        seeCustomerByNumberOfOrders.ShowCustomersByNumberOfOrdersReportMethod(
                ApplicationConfig.readFromConfigProperties(
                        "config.properties", "startDate2"),
                ApplicationConfig.readFromConfigProperties(
                        "config.properties", "endDate2"));
    }

    @Then("Customers By Number Of Orders Report should be displayed")
    public void customersByNumberOfOrdersReportShouldBeDisplayed() {
        Assert.assertTrue(seeCustomerByNumberOfOrders.verifyReportsDisplayed());

    }
    //Zulhumar
    @When("reporting manager opens the Products Reviews page")
    public void reportingManagerOpensTheProductsReviewersPage() {
        seeProductReviews.seeProductReviewsMethod();
    }

    @Then("product reviews should be displayed")
    public void productReviewsShouldBeDisplayed() {
        Assert.assertTrue(seeProductReviews.verifyReviewsDisplayed());
    }


    @After("@ReportingModuleTests")
    public void tearDown() {
        closeBrowser();
    }


}
