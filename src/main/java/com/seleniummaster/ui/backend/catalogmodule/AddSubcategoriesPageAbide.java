package com.seleniummaster.ui.backend.catalogmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddSubcategoriesPageAbide {
    WebDriver driver;
    TestUtility testUtility;

    //Element Location
    @FindBy(css = "ul#nav>li>a.active")
    WebElement catalogLink;

    @FindBy(css = "#nav > li.active.parent.level0 > ul > li:nth-child(2) > a")
    WebElement manageCategoriesLink;

    @FindBy(css = "#page\\:left > div > div.tree-actions > a:nth-child(3)")
    WebElement expandAllButton;

    @FindBy(css = "#extdd-4")
    WebElement fatherCategoryButton;

    @FindBy(css = "div.content-header>button[title=\"Add Subcategory\"]")
    WebElement addSubcategoryButton;

    @FindBy(id = "group_4name")
    WebElement subcategoryNameInputBox;

    @FindBy(xpath = "//*[@id=\"group_4is_active\"]")
    WebElement isActiveDropdownField;

    @FindBy(xpath = "//*[@id=\"group_4is_active\"]/option[1]")
    WebElement isActiveYesOptionField;

    @FindBy(css = "div.content-header>div>p>button[title=\"Save Category\"]")
    WebElement saveCategoryButton;

    @FindBy(xpath= "//*[@id=\"messages\"]/ul/li/ul/li/span")
    WebElement successfullyMassage;

    //Constructor creation
    public AddSubcategoriesPageAbide(WebDriver driver) {
        this.driver = driver;
        testUtility=new TestUtility(driver);
        PageFactory.initElements(driver,this);
    }

    //methods
    public void addSubcategories(){
       testUtility.waitForElementPresent(catalogLink);
       catalogLink.click();
       testUtility.waitForElementPresent(manageCategoriesLink);
       manageCategoriesLink.click();
       testUtility.waitForElementPresent(expandAllButton);
       expandAllButton.click();
       testUtility.sleep(2);
       testUtility.waitForElementPresent(fatherCategoryButton);
       fatherCategoryButton.click();
       testUtility.sleep(2);
       testUtility.waitForElementPresent(addSubcategoryButton);
       addSubcategoryButton.click();
       testUtility.sleep(2);
       testUtility.waitForElementPresent(subcategoryNameInputBox);
       subcategoryNameInputBox.sendKeys(testUtility.fakeCategoryName());
       testUtility.waitForElementPresent(isActiveDropdownField);
       isActiveDropdownField.click();
       testUtility.sleep(3);
       testUtility.waitForElementPresent(isActiveYesOptionField);
       isActiveYesOptionField.click();
       testUtility.waitForElementPresent(saveCategoryButton);
       saveCategoryButton.click();
    }

    public boolean verifySubcategoriesAddedSuccessfully(){
        testUtility.waitForElementPresent(successfullyMassage);
        if (successfullyMassage.isDisplayed())
            return true;
        else
            return false;
    }


}
