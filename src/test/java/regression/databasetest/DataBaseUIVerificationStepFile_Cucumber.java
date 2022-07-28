package regression.databasetest;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import com.seleniummaster.database.databaseTestPages.VerifyNewStoreViewPage;
import com.seleniummaster.database.databaseUtility.DataAccess;
import com.seleniummaster.database.databaseUtility.DatabaseMethods;
import com.seleniummaster.database.databaseUtility.TestDataHolder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.sql.Connection;

public class DataBaseUIVerificationStepFile_Cucumber extends TestBase {

    VerifyNewStoreViewPage verifyNewStoreViewPage;
    TestUtility testUtility;
    AdminLoginPage adminLoginPage;
    TestDataHolder testDataHolder=new TestDataHolder();
    DataAccess dataAccess=new DataAccess();
    String configFile="config.properties";
    String backEndURL=ApplicationConfig.readFromConfigProperties(configFile,"backEndURL");
    Connection databaseConnection= DatabaseMethods.databaseConnectionSetUp();

    @Before("@VerifyNewlyAddedStoreView")
    public void setUp() {
        browserSetUp(backEndURL);
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("storeManager");
        verifyNewStoreViewPage=new VerifyNewStoreViewPage(driver);
        testUtility=new TestUtility(driver);
    }

    @Given("store manager on the Dashboard page")
    public void storeManagerOnTheDashboardPage() {
        Assert.assertTrue(adminLoginPage.verifyAdminLoginSuccessfully());
    }


    @When("store manager creates a new store view")
    public void storeManagerCreatesANewStoreView() {
        String storeName="team4test"+testUtility.fakeName();
        String storeCode="team4test"+testUtility.generateRandomStoreCode();
        testDataHolder.setStoreName(storeName);
        verifyNewStoreViewPage.createNewStoreView(storeName,storeCode);
    }

    @Then("a new store view should be created")
    public void aNewStoreViewShouldBeCreated() {
        Assert.assertTrue(verifyNewStoreViewPage.
                verifyNewStoreViewSuccessfullyCreated(testDataHolder.getStoreName()));
    }

    @And("store manager is able to verify the store view in the database")
    public void storeManagerIsAbleToVerifyTheStoreViewInTheDatabase() {
        boolean isCustomerExist=dataAccess.getStoreName(testDataHolder.getStoreName(),databaseConnection);
        Assert.assertTrue(isCustomerExist);
    }

    @After("@VerifyNewlyAddedStoreView")
    public void tearDown(){
        driver.close();
        driver.quit();
        DatabaseMethods.closeDatabaseConnection();
    }



}
