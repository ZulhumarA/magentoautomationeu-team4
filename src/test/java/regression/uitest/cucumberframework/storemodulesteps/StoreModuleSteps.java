package regression.uitest.cucumberframework.storemodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.PublicLoginPage;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.storemodule.CreateStoreViewPage;
import com.seleniummaster.ui.backend.storemodule.EditStoreViewPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StoreModuleSteps extends TestBase {
    CreateStoreViewPage createStoreViewPage;
    EditStoreViewPage editStoreViewPage;
    String configFile="config.properties";
    AdminLoginPage adminLoginPage;
    @Before("@ManageStoreTest")
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile,"backEndURL"));
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("storeManager");
    }

//Store Manager can create a store view Zulhumar
    @Given("store manager on the dashboard page")
    public void storeManagerOnTheDashboardPage() {
       adminLoginPage=new AdminLoginPage(driver);
        Assert.assertTrue(adminLoginPage.verifyAdminLoginSuccessfully());
        CreateStoreViewPage createStoreViewPage=new CreateStoreViewPage(driver);
        EditStoreViewPage editStoreViewPage=new EditStoreViewPage(driver);
    }



    @When("store manager create a new store view")
    public void storeManagerCreateANewStoreView() throws InterruptedException {
        createStoreViewPage=new CreateStoreViewPage(driver);
        createStoreViewPage.openManageStoresPage();
      createStoreViewPage.fillOutStoreViewInformation();

    }


    @Then("successfully created message should be displayed")
    public void successfullyCreatedMessageShouldBeDisplayed() {
        createStoreViewPage.verifyStoreViewSuccessfullyCreated();

    }
    //Store Manager can edit a store view zulhumar
    @When("store manager edit a store view")
    public void storeManagerEditAStoreView() {
        editStoreViewPage.openManageStoresPage();
        editStoreViewPage.editStoreViewMethod();
    }

    @Then("successfully edited message should be displayed")
    public void successfullyEditedMessageShouldBeDisplayed() {
       editStoreViewPage.verifyStoreViewSuccessfullyUpdated();
    }
    @After("@ManageStoreTest")
    public void tearDown()
    {
        closeBrowser();
    }

}

