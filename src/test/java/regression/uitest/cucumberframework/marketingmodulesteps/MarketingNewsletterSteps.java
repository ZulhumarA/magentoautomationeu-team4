package regression.uitest.cucumberframework.marketingmodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.marketingmodule.AddNewsletterTemplatePage;
import com.seleniummaster.ui.backend.marketingmodule.DeleteNewsletterTemplatePage;
import com.seleniummaster.ui.backend.marketingmodule.UpdateNewsletterTemplatePage;
import com.seleniummaster.ui.backend.marketingmodule.ViewNewsletterSubscribersPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MarketingNewsletterSteps extends TestBase {

    AdminLoginPage adminLoginPage;
    AddNewsletterTemplatePage addNewsletterTemplatePage;
    UpdateNewsletterTemplatePage updateNewsletterTemplatePage;
    DeleteNewsletterTemplatePage deleteNewsletterTemplatePage;
    ViewNewsletterSubscribersPage viewNewsletterSubscribersPage;
    String configFile="config.properties";

    @Before
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile,"backEndURL"));
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("marketingManager");
    }

    //add newsletter template test case(Gvlmihre)
    @Given("marketing manager on the dashboard page")
    public void marketingManagerOnTheDashboardPage() {
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.verifyAdminLoginSuccessfully();
        addNewsletterTemplatePage=new AddNewsletterTemplatePage(driver);
        updateNewsletterTemplatePage=new UpdateNewsletterTemplatePage(driver);
        deleteNewsletterTemplatePage=new DeleteNewsletterTemplatePage(driver);
        viewNewsletterSubscribersPage=new ViewNewsletterSubscribersPage(driver);
    }

    @When("marketing manager adds a newsletter template")
    public void marketingManagerAddsANewsletterTemplate() {
        addNewsletterTemplatePage.addNewsletterTemplate();
    }

    @Then("a new newsletter template should be added")
    public void aNewNewsletterTemplateShouldBeAdded() {
        addNewsletterTemplatePage.verifyNewsletterTemplateAddedSuccessfully();
    }

    //update newsletter template test case(Gvlmihre)
    @When("marketing manager updates a newsletter template")
    public void marketingManagerUpdatesANewsletterTemplate() {
        updateNewsletterTemplatePage.updateExistingNewsletterTemplate();
    }

    @Then("the newsletter template should be updated")
    public void theNewsletterTemplateShouldBeUpdated() {
        Assert.assertTrue(updateNewsletterTemplatePage.verifyTemplateUpdatedSuccessfully());
    }

    //delete newsletter template test case(Gvlmihre)
    @When("marketing manager deletes a newsletter template")
    public void marketingManagerDeletesANewsletterTemplate() {
        deleteNewsletterTemplatePage.deleteTemplate();
    }

    @Then("the newsletter template should be deleted")
    public void theNewsletterTemplateShouldBeDeleted() {
        Assert.assertTrue(deleteNewsletterTemplatePage.verifyTemplateDeletedSuccessfully());
    }

    //view newsletter subscribers test case(Gvlmihre)
    @When("marketing manager views newsletter subscribers")
    public void marketingManagerViewsNewsletterSubscribers() {
        viewNewsletterSubscribersPage.viewNewsletterSubscribers();
    }

    @Then("newsletter subscribers should be viewed")
    public void newsletterSubscribersShouldBeViewed() {
        Assert.assertTrue(viewNewsletterSubscribersPage.verifyNewsletterSubscribersViewed());
    }

    @After
    public void teardown(){
        closeBrowser();
    }
}
