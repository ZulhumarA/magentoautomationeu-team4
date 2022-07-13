package regression.uitest.testngframework;

import com.seleniummaster.configutility.*;
import com.seleniummaster.ui.backend.catalogmodule.*;
import com.seleniummaster.ui.backend.customersmodule.AddNewCustomerPage;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CatalogModuleRunner extends TestBase {
    TestUtility testUtility;
    AdminLoginPage adminLoginPage;
    AddAttributeUnderCatalogPage addAttributeUnderCatalogPage;
    DeleteSubCategories deleteSubCategories ;

    AddSubCategories addSubCategories ;
    EditSubCategories editSubCategories ;
    @BeforeClass
    public void setUp(ITestContext context) {
        testUtility = new TestUtility(driver);

        browserSetUp(ApplicationConfig.readFromConfigProperties(
                "config.properties", "backEndURL"));
        context.setAttribute("driver", driver);
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("catalogManager");
        deleteSubCategories = new DeleteSubCategories(driver);
        addSubCategories = new AddSubCategories(driver);
        editSubCategories= new EditSubCategories(driver);
    }

    @Test(description = "Add new attributes under a catalog-Zulhumar")
    public void addNewAttributes() {
        addAttributeUnderCatalogPage = new AddAttributeUnderCatalogPage(driver);
        addAttributeUnderCatalogPage.addNewAttributeMethod();
        Assert.assertTrue(addAttributeUnderCatalogPage.verifyAttributeAddedSuccessfully());


//    addAttributeUnderCatalogPage.moveToCatalogLink();
//    addAttributeUnderCatalogPage.moveToAttributesLink();
//    addAttributeUnderCatalogPage.moveToManageAttributesLink();
//addAttributeUnderCatalogPage.clickOnAddNewAttributeLink();
//addAttributeUnderCatalogPage.enterattributeCode(ApplicationConfig.readFromConfigProperties(
//        "config.properties","attributeCode"));
//addAttributeUnderCatalogPage.enterDefaultValue(ApplicationConfig.readFromConfigProperties(
//        "config.properties","defaultValue"));
//    addAttributeUnderCatalogPage.clickSaveAttributeButton();
//addAttributeUnderCatalogPage.enterAdminField(ApplicationConfig.readFromConfigProperties(
//        "config.properties","admin"));
//addAttributeUnderCatalogPage.clickSaveAttributeBTN();
        Assert.assertTrue(addAttributeUnderCatalogPage.verifyAttributeAddedSuccessfully());
    }

    @Test
    public void AddRootCategories() {
        AddRootCategories addRootCategories = new AddRootCategories(driver);
        addRootCategories.NewRootCategoryInformation("Car");
        Assert.assertTrue(addRootCategories.VerifyAddRootCategoriesSuccessfully());
    }

    @Test(description = "Ramile")
    public void DeleteSubCategories() {
        deleteSubCategories.SubCategoryDelete();
        Assert.assertTrue(deleteSubCategories.verifyDeleteSubCategorySuccessful());
    }

    @Test(description = "Ramile")
    public void AddSubCategories() {
        addSubCategories.SubCategoryAdd();
        Assert.assertTrue(addSubCategories.verifyAddSubCategorySuccessful());
    }

    @Test(description = "Ramile")
    public void EditSubCategories() {
        editSubCategories.SubCategoryEdit();
        Assert.assertTrue(editSubCategories.verifyEditSubCategorySuccessful());
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}

