package regression.uitest.testngframework;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import com.seleniummaster.ui.backend.customersmodule.*;
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
    ExportCustomers exportCustomers;
    ResetCustomerPassword resetCustomerPassword;
    UpdateAnExistingCustomerPage updateAnExistingCustomerPage;
    FilterCustomersByEmailPage filterCustomersByEmailPage;
    AddNewAddressPage addNewAddressPage;
    DeleteCustomerGroupsPage deleteCustomerGroupsPage;
    FilterCustomersByGroupPage filterCustomersByGroupPage;
    FilterCustomerCountryStateAndWebsite filterCustomerCountryStateAndWebsite;


    @BeforeClass
    public void setUp(ITestContext context) {
        testUtility = new TestUtility(driver);
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties", "backEndURL"));
        context.setAttribute("driver", driver);
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("customerManager");
        resetCustomerPassword = new ResetCustomerPassword(driver);
        addNewCustomerPage = new AddNewCustomerPage(driver);
        updateAnExistingCustomerPage = new UpdateAnExistingCustomerPage(driver);
        assignCustomerGroupPage = new AssignCustomerGroupPage(driver);
        exportCustomers=new ExportCustomers(driver);
        filterCustomersByEmailPage=new FilterCustomersByEmailPage(driver);
        addNewAddressPage=new AddNewAddressPage(driver);
        deleteCustomerGroupsPage=new DeleteCustomerGroupsPage(driver);
        filterCustomersByGroupPage=new FilterCustomersByGroupPage(driver);
        filterCustomerCountryStateAndWebsite=new FilterCustomerCountryStateAndWebsite(driver);
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


    @Test(description = "Zulhumar")
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
    @Test(description = "addNewCustomerAddress-Faruk")
    public void AddNewAddressPage(){
        addNewAddressPage.setClickEdit();
        addNewAddressPage.setClickAddressLinks();
        addNewAddressPage.setAddNewAddressButton();
        addNewAddressPage.setEnterStreetAddress(ApplicationConfig.readFromConfigProperties("config.properties","StreetAddress"));
        addNewAddressPage.setEnterStreetAddress1(ApplicationConfig.readFromConfigProperties("config.properties","StreetAddress1"));
        addNewAddressPage.setEnterCountry();
        addNewAddressPage.setEnterState(ApplicationConfig.readFromConfigProperties("config.properties","State"));
        addNewAddressPage.setEnterCity(ApplicationConfig.readFromConfigProperties("config.properties","City"));
        addNewAddressPage.setEnterPostCode(ApplicationConfig.readFromConfigProperties("config.properties","Postcode"));
        addNewAddressPage.setEnterTelephone(ApplicationConfig.readFromConfigProperties("config.properties","Phone"));
        addNewAddressPage.setAddSaveCustomerButton();
        Assert.assertTrue(addNewAddressPage.addNewAddress());
    }

    @Test(description = "addNewCustomers")
    public void UpdateAnExistingCustomerPage() {
        updateAnExistingCustomerPage.EditAccountInformation("123");
        Assert.assertTrue(updateAnExistingCustomerPage.VerifyEditPasswordSuccessfully());
    }


    @Test(description = "customer manager can delete customer-Zulpikar",dependsOnMethods = { "addNewCustomers", "UpdateAnExistingCustomerPage" },priority = 1)
    public void DeleteCustomerPage() throws InterruptedException {
        DeleteCustomerPage deleteCustomerPage=new DeleteCustomerPage(driver);
        deleteCustomerPage.clickSearchNameField();
        deleteCustomerPage.enterSearchName(ApplicationConfig.readFromConfigProperties("config.properties", "userName"));
        deleteCustomerPage.clickSearchButton();
        Thread.sleep(3000);
        deleteCustomerPage.clickOnCustomer();
        //Thread.sleep(5000);
        deleteCustomerPage.clickOnDelete();
        Assert.assertTrue(deleteCustomerPage.deleteMessage());
    }

    @Test(description = "Gvlmihre")
    public void assignCustomerToNewGroupTest() {
        assignCustomerGroupPage.addNewCustomer();
        Assert.assertTrue(assignCustomerGroupPage.verifyCustomerAdded());
        assignCustomerGroupPage.assignCustomerToNewGroup();
        Assert.assertTrue(assignCustomerGroupPage.isCustomerGroupChanged());
    }

    @Test(description = "Ramile")
    public void ExportCustomers() {
        exportCustomers.ClikExport();
    }


    @Test(description = "Arzugul_customer manager can filter customer by email")
    public void FilterCustomersByEmailPage(){
        filterCustomersByEmailPage.filterEmail();
        filterCustomersByEmailPage.verifyCustomersByEmail();

    }

    @Test(description = "Abide")
    public void deleteCustomerGroups(){
        deleteCustomerGroupsPage.deleteCustomerGroup();
        Assert.assertTrue(deleteCustomerGroupsPage.verifyCustomerGroupDeletedSuccessfully());
    }

    @Test(description = "filter customer by group--Abide")
     public void filterCustomerByGroup(){
      filterCustomersByGroupPage.filterCustomersByGroup();
      filterCustomersByGroupPage.verifyFilteredSuccessfully();
}

     @Test(description = "Kadirya")
     public void FilterCustomerCountryStateAndWebsite(){
        filterCustomerCountryStateAndWebsite.filterCustomerByCountry();
         filterCustomerCountryStateAndWebsite.filterCustomerByWebsite();
         filterCustomerCountryStateAndWebsite.filteCustomerByState();

         Assert.assertTrue(true);
     }



    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}
