package regression.uitest.cucumberframework.marketingmodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.marketingmodule.AddNewsletterTemplatePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MarketingModuleSteps extends TestBase {

    AdminLoginPage adminLoginPage;
    AddNewsletterTemplatePage addNewsletterTemplatePage;
    String configFile="config.properties";

    @Before
    public void setUp(){
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile,"marketingManager"));
    }

    @Given("marketing manager on the dashboard page")
    public void marketingManagerOnTheDashboardPage() {
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.verifyAdminLoginSuccessfully();
        addNewsletterTemplatePage=new AddNewsletterTemplatePage(driver);
    }

    @When("marketing manager add a newsletter template")
    public void marketingManagerAddANewsletterTemplate() {
        addNewsletterTemplatePage.addNewsletterTemplate();
    }

    @Then("a new newsletter template should be added")
    public void aNewNewsletterTemplateShouldBeAdded() {
        addNewsletterTemplatePage.verifyNewsletterTemplateAddedSuccessfully();
    }


}
