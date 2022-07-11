package regression.uitest.testngframework;

import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.PublicLoginPage;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import com.seleniummaster.ui.frontend.*;
import org.testng.Assert;
import org.testng.annotations.*;


public class PublicModuleRunner extends TestBase {

    UpdateCartPage updateCartPage;
    PublicLoginPage publicLoginPage;
    ViewAccountInformationPage viewAccountInformationPage;
    CheckOutTheOrderPage checkOutTheOrderPage;
    ViewDownloadableOrdersPage viewDownloadableOrdersPage;
    ViewOrderPage ViewOrderPage;
    UpdateAddressBookPage updateAddressBookPage;
    EditAccountInformationPage editAccountInformationPage;
    ViewMyWishListPage viewMyWishListPage;
    ViewNewsletterSubscriptionLinkAndContentPage viewNewsletterSubscriptionLinkAndContentPage;
    SeeMyProductReviewsLinkAndContents seeMyProductReviewsLinkAndContents;
    CreateAnAccountPage createAnAccountPage;
    ChangPasswordPage changPasswordPage;
    TestUtility testUtility;


    @BeforeClass
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties", "frontEndURL"));
        updateCartPage = new UpdateCartPage(driver);
        publicLoginPage = new PublicLoginPage(driver);
        createAnAccountPage = new CreateAnAccountPage(driver);
        ViewOrderPage = new ViewOrderPage(driver);
        updateAddressBookPage = new UpdateAddressBookPage(driver);
        viewAccountInformationPage = new ViewAccountInformationPage(driver);
        checkOutTheOrderPage = new CheckOutTheOrderPage(driver);
        viewDownloadableOrdersPage = new ViewDownloadableOrdersPage(driver);
        editAccountInformationPage = new EditAccountInformationPage(driver);
        seeMyProductReviewsLinkAndContents = new SeeMyProductReviewsLinkAndContents(driver);
        viewMyWishListPage=new ViewMyWishListPage(driver);
        changPasswordPage = new ChangPasswordPage(driver);
        viewNewsletterSubscriptionLinkAndContentPage=new ViewNewsletterSubscriptionLinkAndContentPage(driver);
    }


    @Test(description = "Gulmire",priority = 1)
    public void addLinenBlazerProductToCart() {
        updateCartPage.addLinenBlazerToCart();
        Assert.assertTrue(updateCartPage.verifyLinenBlazerSuccessfullyAddedMessage());
    }

    @Test(description = "Gulmire",dependsOnMethods = "addLinenBlazerProductToCart",priority = 2)
    public void updateProductSize() {
        updateCartPage.changeProductSizeMethod();
        Assert.assertTrue(updateCartPage.verifyLinenBlazerProductUpdatedSuccessfully());
    }

    @Test(description = "Mahmut")
    public void ViewAccountInformation() {
        publicLoginPage.Login();
        viewAccountInformationPage.openAccountInformation();
        Assert.assertTrue(viewAccountInformationPage.verifyAccountInformation());
        publicLoginPage.LogOutAndBackToLogInPage();

    }

    @Test(description = "Shohret")
    public void CheckOutTheOrder() {
        publicLoginPage.Login();
        checkOutTheOrderPage.openMyOrders();
        Assert.assertTrue(checkOutTheOrderPage.verifyMyOrders());
        publicLoginPage.LogOutAndBackToLogInPage();
    }

    @Test(description = "Arzugul")
    public void viewDownloadableOrders() {
        publicLoginPage.Login();
        viewDownloadableOrdersPage.ViewDownloableOrders();
        Assert.assertTrue(viewDownloadableOrdersPage.verifyviewDownloadableorders());
        publicLoginPage.LogOutAndBackToLogInPage();
    }

    // Test Case Id: MAGE2022-314 A user should be able to create an account
    @Test(description = "habibulla",priority = 3)
    public void createAnAccount() {
        createAnAccountPage.fillAccountRegistrationForm();
        Assert.assertTrue(createAnAccountPage.verifyCreateAnAccountSuccessful());

    }

    @Test(dataProvider = "publicChangPasswordTest",description = "a user should be able chang password",dependsOnMethods = "createAnAccount",priority = 4)
    public void clickChangPassword(String currentPassword, String newPassword, String confirmationPassword) {
        boolean changPasswordTestResult = changPasswordPage.clickChangPassword(currentPassword, newPassword, confirmationPassword);
        Assert.assertTrue(changPasswordTestResult);
        publicLoginPage.LogOutAndBackToLogInPage();
    }

    @DataProvider
    public Object[][] publicChangPasswordTest() {
        Object[][] clickChangPassword = new Object[][]
                {
                        {"12345678943", "112233445577", "112233445577"}
                };
        return clickChangPassword;
    }

    @Test(description = "Zulpikar")
    public void ViewOrder() {
        publicLoginPage.Login();
        ViewOrderPage.OpenMyOrders();
        ViewOrderPage.ViewOrder();
        Assert.assertTrue(ViewOrderPage.VerifyOrders());
        publicLoginPage.LogOutAndBackToLogInPage();
    }

    @Test(description = "kadirya")
    public void UpdateAddress() {
        publicLoginPage.updateAddressLogin();
        updateAddressBookPage.UpdateAddress();
        Assert.assertTrue(updateAddressBookPage.verifyUpdatedAddress());
        publicLoginPage.LogOutAndBackToLogInPage();
    }

    @Test(description = "Zulhumar")
    public void addProductsToCart() {
        AddProductsToShoppingCartPage addProductsToShoppingCartPage = new AddProductsToShoppingCartPage(driver);
        addProductsToShoppingCartPage.addChelseaTeaToCart();
        Assert.assertTrue(addProductsToShoppingCartPage.verifySuccessfullyAddProduct());
    }

    @Test(description = "Ramile")
    public void EditAccountInformation() {
        publicLoginPage.Login();
        viewAccountInformationPage.openAccountInformation();
        EditAccountInformationPage editAccountInformationPage1 = new EditAccountInformationPage(driver);
        editAccountInformationPage1.editAccountInformationPage();
        Assert.assertTrue(editAccountInformationPage1.verifyEditAccountInformation());
        publicLoginPage.LogOutAndBackToLogInPage();

    }

    @Test(description = "izzet")
    public void SeeMyProductsReview() {
        publicLoginPage.Login();
        seeMyProductReviewsLinkAndContents.SeeMyProductReviews();
        seeMyProductReviewsLinkAndContents.Verify();
        publicLoginPage.LogOutAndBackToLogInPage();
    }

    @Test(description = "Abide")
    public void ViewMyWishList(){
     publicLoginPage.Login();
     viewMyWishListPage.clickMyWishList();
     Assert.assertTrue(viewMyWishListPage.existMyWishListContent());
     publicLoginPage.LogOutAndBackToLogInPage();
    }

    @Test(description = "Abide")
    public void ViewNewsletterSubscriptionLinkAndContent(){
        publicLoginPage.Login();
        viewNewsletterSubscriptionLinkAndContentPage.ViewNewsletterSubscriptionLinkAndContent();
        Assert.assertTrue(viewNewsletterSubscriptionLinkAndContentPage.VerifyViewNewsletterSubscriptionLinkAndContent());
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}


//    @Test
//    public void addMultipleProducts(){
//        cartPage=new CartPage(driver);
//        cartPage.addMultipleProductsToCartMethod();
//        Assert.assertTrue(cartPage.verifyChelseaTeaAdded());
//    }
//
//    @Test
//    public void addProduct(){
//        cartPage=new CartPage(driver);
//        WebElement linenBlazer=driver.findElement(By.xpath("//*[text()=\"Linen Blazer\"]"));
//        cartPage.addProductToCart(linenBlazer,"22","78");
//    }
//





