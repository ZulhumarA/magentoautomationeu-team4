package regression.uitest.cucumberframework;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends TestBase {

    AdminLoginPage adminLoginPage;


    @Given("admin user already on the login page")
    public void adminUserAlreadyOnTheLoginPage() {
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties","backEndURL"));
    }

    @When("store manager enters valid username and password to click on login button")
    public void storeManagerEntersValidUsernameAndPasswordToClickOnLoginButton() {
    }

    @Then("store manager should be able to login successfully")
    public void storeManagerShouldBeAbleToLoginSuccessfully() {
    }

    @When("marketing manager enters valid username and password to click on login button")
    public void marketingManagerEntersValidUsernameAndPasswordToClickOnLoginButton() {
    }

    @Then("marketing manager should be able to login successfully")
    public void marketingManagerShouldBeAbleToLoginSuccessfully() {
    }

    @When("reporting manager enters valid username and password to click on login button")
    public void reportingManagerEntersValidUsernameAndPasswordToClickOnLoginButton() {
    }

    @Then("reporting manager should be able to login successfully")
    public void reportingManagerShouldBeAbleToLoginSuccessfully() {
    }
}
