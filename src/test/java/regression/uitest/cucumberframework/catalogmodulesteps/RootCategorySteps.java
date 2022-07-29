package regression.uitest.cucumberframework.catalogmodulesteps;

import com.seleniummaster.configutility.*;
import com.seleniummaster.ui.backend.catalogmodule.AddRootCategoriesZulhumar;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RootCategorySteps extends TestBase {
    AdminLoginPage adminLoginPage;
    AddRootCategoriesZulhumar addRootCategoriesZulhumar;
    String configFile="config.properties";


    @Before("@RootCategoryTests")
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile,"backEndURL"));
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("catalogManager");

    }

    @Given("catalog manager on the dashboard page")
    public void catalogManagerOnTheDashboardPage() {
        adminLoginPage=new AdminLoginPage(driver);
        Assert.assertTrue(adminLoginPage.verifyAdminLoginSuccessfully());
            addRootCategoriesZulhumar =new AddRootCategoriesZulhumar(driver);
addRootCategoriesZulhumar=new AddRootCategoriesZulhumar(driver);
    }

    @When("catalog manager add a new root catagory")
    public void catalogManagerAddANewRootCatagory() throws InterruptedException {
addRootCategoriesZulhumar.openAddNewRootCategoryPage();
addRootCategoriesZulhumar.fillCategoryInformationAndSave();

    }

    @Then("the root category should be displayed")
    public void theRootCategoryShouldBeDisplayed() throws InterruptedException {
Assert.assertTrue(addRootCategoriesZulhumar.verifyAddRootCategories());
    }

    @After("@RootCategoryTests")
    public void tearDown() {
        closeBrowser();
    }

}

