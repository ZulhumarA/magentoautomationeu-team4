package regression.databasetest;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import com.seleniummaster.database.databaseUtility.DataAccess;
import com.seleniummaster.database.databaseUtility.DatabaseMethods;
import com.seleniummaster.database.databaseUtility.TestDataHolder;
import com.seleniummaster.database.databaseTestPages.VerifyNewStoreViewPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;

public class DataBaseUIVerification_TestNG extends TestBase {

    String configFile="config.properties";
    String backEndURL= ApplicationConfig.readFromConfigProperties(configFile,"backEndURL");
    AdminLoginPage adminLoginPage;
    TestUtility testUtility;
    VerifyNewStoreViewPage verifyNewStoreViewPage;
    TestDataHolder testDataHolder=new TestDataHolder();
    DataAccess dataAccess=new DataAccess();

    @BeforeClass
    public void setUp(){
        browserSetUp(backEndURL);
        adminLoginPage=new AdminLoginPage(driver);
        testUtility=new TestUtility(driver);
        verifyNewStoreViewPage=new VerifyNewStoreViewPage(driver);
    }

    @Test(description = "Gvlmihre")
    public void verifyNewStoreViewCreated(){
        //create New Store View
        adminLoginPage.adminLogin("storeManager");
        String storeName="team4test"+testUtility.fakeName();
        String storeCode="team4test"+testUtility.generateRandomStoreCode();
        testDataHolder.setStoreName(storeName);
        verifyNewStoreViewPage.createNewStoreView(storeName,storeCode);
        Assert.assertTrue(verifyNewStoreViewPage.verifyNewStoreViewSuccessfullyCreated(testDataHolder.getStoreName()));
        //verify Created Store View is in the database
        Connection connection=DatabaseMethods.databaseConnectionSetUp();
        boolean isCustomerExist=dataAccess.getStoreName(testDataHolder.getStoreName(),connection);
        Assert.assertTrue(isCustomerExist);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
        DatabaseMethods.closeDatabaseConnection();
    }

}
