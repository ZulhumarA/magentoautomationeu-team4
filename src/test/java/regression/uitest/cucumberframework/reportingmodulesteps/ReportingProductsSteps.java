package regression.uitest.cucumberframework.reportingmodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
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
    String configFile="config.properties";

    @Before
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
    }

    @When("reporting manager opens the products ordered report")
    public void reportingManagerOpensTheProductsOrderedReport() {
        productsOrderedReportPage.viewProductsOrderedReport("01/01/2020","01/01/2022");
    }

    @Then("products ordered report should be displayed")
    public void productsOrderedReportShouldBeDisplayed() {
        productsOrderedReportPage.verifyProductsOrderedReportDisplayed();
    }

    @After
    public void teardown(){
        closeBrowser();
    }
}
