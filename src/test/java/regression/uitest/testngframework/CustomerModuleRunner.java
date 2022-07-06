package regression.uitest.testngframework;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.customersmodule.ResetCustomerPassword;
import com.seleniummaster.ui.backend.customersmodule.UpdateAnExistingCustomerPage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomerModuleRunner extends TestBase {

    AdminLoginPage adminLoginPage;

    @BeforeClass
    public void setUp(ITestContext context) {
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties", "backEndURL"));
        context.setAttribute("driver", driver);
    }

    @Test
    public void customerManagerLogin() {
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("customerManager");
    }

    @Test
    public void ResetCustomerPassword() {
        adminLoginPage = new AdminLoginPage(driver);
        ResetCustomerPassword resetCustomerPassword=new ResetCustomerPassword(driver);
        adminLoginPage.adminLogin("customerManager");
        resetCustomerPassword.EditCustomerInformation(1234567);
       Assert.assertTrue( resetCustomerPassword.VerifyEditPasswordSuccessfully());
    }

    @Test
    public void UpdateAnExistingCustomerPage() {
        adminLoginPage = new AdminLoginPage(driver);
        UpdateAnExistingCustomerPage updateAnExistingCustomerPage=new UpdateAnExistingCustomerPage(driver);
        adminLoginPage.adminLogin("customerManager");
        updateAnExistingCustomerPage.EditAccountInformation("123");
        Assert.assertTrue( updateAnExistingCustomerPage.VerifyEditPasswordSuccessfully());
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }


}
