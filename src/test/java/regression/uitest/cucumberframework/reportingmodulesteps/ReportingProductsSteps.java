package regression.uitest.cucumberframework.reportingmodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.reportingmodule.ProductsLowStockReportPage;
import com.seleniummaster.ui.backend.reportingmodule.ProductsMostViewedReportPage;
import com.seleniummaster.ui.backend.reportingmodule.ProductsOrderedReportPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ReportingProductsSteps extends TestBase {

    AdminLoginPage adminLoginPage;
    ProductsOrderedReportPage productsOrderedReportPage;
    ProductsMostViewedReportPage productsMostViewedReportPage;
    ProductsLowStockReportPage productsLowStockReportPage;
    String configFile="config.properties";

    @Before("@ViewProductsOrderedReport or @ViewProductsMostViewedReport or @ViewProductsLowStockReport")
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile,"backEndURL"));
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
    }

    @Given("reporting manager on the dashboard page")
    public void reportingManagerOnTheDashboardPage() {
        adminLoginPage=new AdminLoginPage(driver);
        Assert.assertTrue(adminLoginPage.verifyAdminLoginSuccessfully());
        productsOrderedReportPage=new ProductsOrderedReportPage(driver);
        productsMostViewedReportPage=new ProductsMostViewedReportPage(driver);
        productsLowStockReportPage=new ProductsLowStockReportPage(driver);
    }

    // products ordered report test case (Gvlmihre)
    @When("reporting manager opens the products ordered report")
    public void reportingManagerOpensTheProductsOrderedReport() {
        productsOrderedReportPage.viewProductsOrderedReport("01/01/2020","01/01/2022");
    }

    @Then("products ordered report should be displayed")
    public void productsOrderedReportShouldBeDisplayed() {
        productsOrderedReportPage.verifyProductsOrderedReportDisplayed();
    }

    //products most viewed report test case (Gvlmihre)
    @When("reporting manager opens the products most viewed report")
    public void reportingManagerOpensTheProductsMostViewedReport() {
        productsMostViewedReportPage.viewProductsMostViewedReport("1/1/2020","1/1/2022");
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

    @After("@ViewProductsOrderedReport or @ViewProductsMostViewedReport or @ViewProductsLowStockReport")
    public void tearDown(){
        closeBrowser();
    }
}
