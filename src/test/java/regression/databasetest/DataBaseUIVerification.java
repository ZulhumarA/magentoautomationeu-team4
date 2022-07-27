package regression.databasetest;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import com.seleniummaster.database.databaseUtility.DatabaseMethods;
import com.seleniummaster.database.databaseUtility.TestDataHolder;
import com.seleniummaster.database.datapaseTestPages.VerifyNewStoreViewPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataBaseUIVerification extends TestBase {


    String configFile="config.properties";
    String backEndURL= ApplicationConfig.readFromConfigProperties(configFile,"backEndURL");
    AdminLoginPage adminLoginPage;
    TestUtility testUtility;
    VerifyNewStoreViewPage verifyNewStoreViewPage;
    DatabaseMethods databaseMethods=new DatabaseMethods();
    TestDataHolder testDataHolder=new TestDataHolder();

    @BeforeClass
    public void setUp(){
        browserSetUp(backEndURL);
        databaseMethods.databaseConnectionSetUp();
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
        Assert.assertTrue(verifyNewStoreViewPage.verifyNewStoreViewSuccessfullyCreated());
        //verify Created Store View is in the database


    }





    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
        databaseMethods.closeDatabaseConnection();
    }

}
