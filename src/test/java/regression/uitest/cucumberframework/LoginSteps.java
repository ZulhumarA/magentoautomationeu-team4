package regression.uitest.cucumberframework;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends TestBase {

    AdminLoginPage adminLoginPage;

    @Given("admin user already on the login page")
    public void adminUserAlreadyOnTheLoginPage() {
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties","backEndURL"));
    }

    @When("store manager enters valid username and password and click on login button")
    public void storeManagerEntersValidUsernameAndPasswordAndClickOnLoginButton() {
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("storeManager");
    }

    @Then("manager should be able to login successfully")
    public void managerShouldBeAbleToLoginSuccessfully() {
        adminLoginPage.verifyAdminLoginSuccessfully();
    }

    @When("marketing manager enters valid username and password and click on login button")
    public void marketingManagerEntersValidUsernameAndPasswordAndClickOnLoginButton() {
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("marketingManager");
    }

    @When("sales manager enters valid username and password and click on login button")
    public void salesManagerEntersValidUsernameAndPasswordAndClickOnLoginButton() {
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("salesManager");
    }

    @When("reporting manager enters valid username and password and click on login button")
    public void reportingManagerEntersValidUsernameAndPasswordAndClickOnLoginButton() {
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
    }
}
