package regression.uitest.cucumberframework.marketingmodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.marketingmodule.AddNewCatalogPriceRule;
import com.seleniummaster.ui.backend.marketingmodule.UpdateExistingCatalogPriceRule;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

// Marketing manager can add and update catalog price rule--Arzugul

public class MarketingCatalogPriceRule extends TestBase {
    AdminLoginPage adminLoginPage;
    AddNewCatalogPriceRule addNewCatalogPriceRule;
    UpdateExistingCatalogPriceRule updateExistingCatalogPriceRule;
    String configFile="config.properties";
    WebDriver driver;
    @Before("@CatalogPriceTest")
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile,"backEndURL"));
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("marketingManager");

    }


    @Given("Marketing manager on the dashboard page")
    public void marketingManagerOnTheDashboardPage() {
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.verifyAdminLoginSuccessfully();
        addNewCatalogPriceRule =new AddNewCatalogPriceRule(driver);


    }

    @When("Marketing Manger add a new catalog price rule")
    public void marketingMangerAddANewCatalogPriceRule() throws InterruptedException {
        addNewCatalogPriceRule.addCatalogPriceRule("Team4","08/9/2022");

    }

    @Then("The new catalog price rule should be added")
    public void theNewCatalogPriceRuleShouldBeAdded() {
        addNewCatalogPriceRule.verifyAddNewCatalogPriceRule();
    }

    @When("Marketing Manger update the existing catalog price rule")
    public void marketingMangerUpdateTheExistingCatalogPriceRule() {
        updateExistingCatalogPriceRule.updateCatalogPriceRule("Team4");
    }

    @Then("The new catalog price rule should be updated")
    public void theNewCatalogPriceRuleShouldBeUpdated() {
        updateExistingCatalogPriceRule.verifyUpdateExistingCatalogPriceRule();
    }
    @After("@CatalogPriceRuleTest")
    public void teardown() {
        closeBrowser();
    }
}
