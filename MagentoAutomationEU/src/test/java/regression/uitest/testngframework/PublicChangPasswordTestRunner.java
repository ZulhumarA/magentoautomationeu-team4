package regression.uitest.testngframework;


import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.PublicLoginPage;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.frontend.ChangPasswordPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class PublicChangPasswordTestRunner extends TestBase {



    @BeforeTest
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties", "frontEndURL"));
        PublicLoginPage publicLoginPage = new PublicLoginPage(driver);
        publicLoginPage.changPasswordLogin();

    }

    @Test(dataProvider = "publicChangPasswordTest",description = "a user should be able chang password")
    public void clickChangPassword(String currentPassword, String newPassword, String confirmationPassword) {
        ChangPasswordPage changPasswordPage = new ChangPasswordPage(driver);
        boolean changPasswordTestResult = changPasswordPage.clickChangPassword(currentPassword, newPassword, confirmationPassword);
        Assert.assertTrue(changPasswordTestResult);
    }

    @DataProvider
    public Object[][] publicChangPasswordTest() {
        Object[][] clickChangPassword = new Object[][]
                {
                        {"112233445566", "112233445577", "112233445577"}
                };
        return clickChangPassword;
    }
    @AfterTest
    public void teardown(){

    }
}
