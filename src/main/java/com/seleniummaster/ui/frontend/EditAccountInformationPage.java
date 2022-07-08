package com.seleniummaster.ui.frontend;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountInformationPage {
    TestUtility testUtility;

    WebDriver driver;
    @FindBy(css = "div.account-cart-wrapper a.skip-link.skip-account .label")
    WebElement AccountButton;

    @FindBy(xpath="//a[contains(text(),'Account Information')]")
    WebElement AccountInformationButton;

    @FindBy(id = "middlename")
    WebElement MiddleName;

    @FindBy(css=".main")
    WebElement SelectAll;

    @FindBy(css="button[title='Save']")
    WebElement SaveButton;

    @FindBy(id="current_password")
    WebElement CurrentPassword;

    @FindBy(css=".success-msg li span")
    WebElement EditAccountInformationSuccessfulMessage;

    public EditAccountInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void editAccountInformationPage() {
        testUtility.waitForElementPresent(AccountInformationButton);
        AccountInformationButton.click();
        testUtility.waitForElementPresent(MiddleName);
        MiddleName.click();
        SelectAll.click();
        MiddleName.sendKeys("Team4");
        testUtility.waitForElementPresent(CurrentPassword);
        CurrentPassword.click();
        CurrentPassword.sendKeys("team4test!");
        testUtility.waitForElementPresent(SaveButton);
        SaveButton.click();

    }
    public boolean verifyEditAccountInformation() {
        testUtility.waitForElementPresent(EditAccountInformationSuccessfulMessage);
        return EditAccountInformationSuccessfulMessage.isDisplayed();
    }
}
