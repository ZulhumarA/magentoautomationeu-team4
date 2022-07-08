package regression.uitest.testngframework;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import com.seleniummaster.ui.backend.customersmodule.AddNewCustomerPage;
import com.seleniummaster.ui.backend.customersmodule.AssignCustomerGroupPage;
import com.seleniummaster.ui.backend.customersmodule.ResetCustomerPassword;
import com.seleniummaster.ui.backend.customersmodule.UpdateAnExistingCustomerPage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomerModuleRunner extends TestBase {
    TestUtility testUtility;
    AdminLoginPage adminLoginPage;
    AddNewCustomerPage addNewCustomerPage;
    AssignCustomerGroupPage assignCustomerGroupPage;

    ResetCustomerPassword resetCustomerPassword;
    UpdateAnExistingCustomerPage updateAnExistingCustomerPage;
    @BeforeClass
    public void setUp(ITestContext context) {
        testUtility = new TestUtility(driver);
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties", "backEndURL"));
        context.setAttribute("driver", driver);
        adminLoginPage.adminLogin("customerManager");
        adminLoginPage = new AdminLoginPage(driver);
        resetCustomerPassword = new ResetCustomerPassword(driver);
        addNewCustomerPage = new AddNewCustomerPage(driver);
        updateAnExistingCustomerPage=new UpdateAnExistingCustomerPage(driver);
        assignCustomerGroupPage = new AssignCustomerGroupPage(driver);
    }

    @Test
    public void customerManagerLogin() {
        adminLoginPage.adminLogin("customerManager");
    }

    @Test
    public void ResetCustomerPassword() {
        resetCustomerPassword.EditCustomerInformation(1234567);
        Assert.assertTrue(resetCustomerPassword.VerifyEditPasswordSuccessfully());
    }


    @Test(description = "customer manager can add new customer-Zulhumar")
    public void addNewCustomers() {
        addNewCustomerPage.clickAddNewCustomer();
        addNewCustomerPage.enterPrefixField(ApplicationConfig.readFromConfigProperties("config.properties", "prefixfield"));
        addNewCustomerPage.enterFirstName(ApplicationConfig.readFromConfigProperties("config.properties", "userName"));
        addNewCustomerPage.enterLastName(ApplicationConfig.readFromConfigProperties("config.properties", "lastName"));
        addNewCustomerPage.enterEmail(ApplicationConfig.readFromConfigProperties("config.properties", "email"));
        addNewCustomerPage.enterTaxNumber(ApplicationConfig.readFromConfigProperties("config.properties", "taxNumber"));
        addNewCustomerPage.enterPassword(ApplicationConfig.readFromConfigProperties("config.properties", "password2"));
        addNewCustomerPage.clickSaveButton();
        Assert.assertTrue(addNewCustomerPage.verifyAddCustomer());
    }

    @Test
    public void UpdateAnExistingCustomerPage() {
        updateAnExistingCustomerPage.EditAccountInformation("123");
        Assert.assertTrue(updateAnExistingCustomerPage.VerifyEditPasswordSuccessfully());
    }

    @Test(description = "Gvlmihre")
    public void assignCustomerToNewGroupTest() {
        assignCustomerGroupPage.addNewCustomer();
        Assert.assertTrue(assignCustomerGroupPage.verifyCustomerAdded());
        assignCustomerGroupPage.assignCustomerToNewGroup();
        Assert.assertTrue(assignCustomerGroupPage.isCustomerGroupChanged());
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}
