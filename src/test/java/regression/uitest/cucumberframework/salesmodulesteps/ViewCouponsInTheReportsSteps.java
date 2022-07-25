package regression.uitest.cucumberframework.salesmodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.salesmodule.ViewCouponsInTheReports;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewCouponsInTheReportsSteps extends TestBase {
    AdminLoginPage adminLoginPage;
    ViewCouponsInTheReports viewCouponsInTheReports;
    String configFile="config.properties";

    @Before()
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile,"backEndURL"));
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("salesManager");
    }
    @Given("Sales Manager on the dashboard page")
    public void SalesManagerOnTheDashboardPage() {
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.verifyAdminLoginSuccessfully();
        viewCouponsInTheReports=new ViewCouponsInTheReports(driver);

    }
    @When("Sales Manager enters the dates in the Reports")
    public void SalesManagerViewsAndAddCreditMemos() {
        viewCouponsInTheReports.CouponsInTheReports();

    }
    @Then("Sales Manager can view coupons between dates in Reports")
    public void TheCreditMemosShouldBeAdded() {
        viewCouponsInTheReports.VerifyViewCoupons();

    }

    @After("@ViewCouponsInTheReports")
    public void teardown(){
        closeBrowser();
    }

}
