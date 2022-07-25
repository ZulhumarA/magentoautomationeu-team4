package regression.uitest.cucumberframework.salesmodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.salesmodule.ViewAndAddCreditMemos;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewsAndAddCreditMemosSteps extends TestBase {

    AdminLoginPage adminLoginPage;
    ViewAndAddCreditMemos viewAndAddCreditMemos;
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
        viewAndAddCreditMemos=new ViewAndAddCreditMemos(driver);

    }
    @When("Sales Manager views and add credit memos")
    public void SalesManagerViewsAndAddCreditMemos() {
        viewAndAddCreditMemos.CreditMemos();

    }
    @Then("The credit memos should be added")
    public void TheCreditMemosShouldBeAdded() {
        viewAndAddCreditMemos.VerifySendSuccessfulMessage();

    }

    @After("@ViewAndAddCreditMemos")
    public void teardown(){
        closeBrowser();
    }




}
