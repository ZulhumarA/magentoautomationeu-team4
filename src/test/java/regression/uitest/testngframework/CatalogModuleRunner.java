package regression.uitest.testngframework;

import com.seleniummaster.configutility.*;
import com.seleniummaster.ui.backend.catalogmodule.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CatalogModuleRunner extends TestBase {
    TestUtility testUtility;
    AdminLoginPage adminLoginPage;
    AddAttributeUnderCatalogPage addAttributeUnderCatalogPage;
    DeleteSubCategories deleteSubCategories;
    AddSubCategories addSubCategories;
    EditSubCategories editSubCategories;
    AddSubcategoriesPage addSubcategoriesPage;
    AddProduct addProduct;
    DeleteProduct deleteProduct;
    EditProduct editProduct;

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
        editSubCategories = new EditSubCategories(driver);
        addSubcategoriesPage = new AddSubcategoriesPage(driver);
        addProduct = new AddProduct(driver);
        deleteProduct=new DeleteProduct(driver);
        editProduct=new EditProduct(driver);
    }

    @Test(description = "AddAttribute-Zulhumar")
    public void addNewAttributes() {
        addAttributeUnderCatalogPage = new AddAttributeUnderCatalogPage(driver);
        addAttributeUnderCatalogPage.addNewAttributeMethod();
        Assert.assertTrue(addAttributeUnderCatalogPage.verifyAttributeAddedSuccessfully());
    }

    @Test(description = "AddRootCategory-Zulhumar")
    public void addNewRootCategories() throws InterruptedException {
        AddRootCategoriesZulhumar addRootCategoriesZulhumar = new AddRootCategoriesZulhumar(driver);
        addRootCategoriesZulhumar.openAddNewRootCategoryPage();
        addRootCategoriesZulhumar.fillCategoryInformationAndSave();
        Assert.assertTrue(addRootCategoriesZulhumar.verifyAddRootCategories());
    }

    @Test(description = "Edit-Zulhumar")
    public void editRootCategory() throws InterruptedException {
        EditRootCategories editRootCategories = new EditRootCategories(driver);
        editRootCategories.openCategoriesPage();
        editRootCategories.editRootCatalogInformation();
        Assert.assertTrue(editRootCategories.verifyEditRootCategories());
    }

    @Test(description = "Edit-Zulhumar")
    public void deleteRootCategory() {
        DeleteRootCategories deleteRootCategories = new DeleteRootCategories(driver);
        deleteRootCategories.openCategoriesPage();
        deleteRootCategories.deleteRootCategory();
        deleteRootCategories.verifyDeleteRootCategory();
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

    @Test(description = "add subcategories page--Abide")
    public void addSubcategories() {
        addSubcategoriesPage.addSubcategories();
        Assert.assertTrue(addSubcategoriesPage.verifySubcategoriesAddedSuccessfully());
    }

    @Test(description = "Add product--Arzugul")
    public void addProductsTest() throws InterruptedException {
        addProduct.addProductInformation("Team4");
        Assert.assertTrue(addProduct.verifyAddProductTest());
    }

    @Test(description="Delete Product--Arzugul")
    public void DeleteProductTest() throws InterruptedException {
        deleteProduct.deleteAddedProduct("Team4");
        Assert.assertTrue(deleteProduct.verifyDeleteProduct());

    }
    @Test(description = "Edit Product--arzugul")
    public void EditProductTest() throws InterruptedException {
        editProduct.editProductInfo("Team4");
        Assert.assertTrue(editProduct.verifyEditProductTest());

    }

        @AfterClass
        public void tearDown () {
            closeBrowser();
        }


    }


