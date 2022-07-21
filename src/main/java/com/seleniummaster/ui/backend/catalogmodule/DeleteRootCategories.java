package com.seleniummaster.ui.backend.catalogmodule;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteRootCategories extends TestBase {
TestUtility testUtility;
WebDriver driver;
    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement CatalogButton;
    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement ManageCategoriesButton;
    @FindBy(xpath="//span[@id=\"extdd-276\"]")
    WebElement ZulhumarCategory;
@FindBy(xpath="//span[contains(text(),\"Delete Category\")]")
WebElement DeleteCategory;

@FindBy(xpath="//span[contains(text(),\"The category has been deleted.\")]")
WebElement successfullyDeletedMessage;


    public DeleteRootCategories(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }
    public void openCategoriesPage() {
        testUtility.waitForElementPresent(CatalogButton);
        CatalogButton.click();
        testUtility.waitForElementPresent(ManageCategoriesButton);
        ManageCategoriesButton.click();
    }
public void deleteRootCategory(){
        testUtility.waitForElementPresent(ZulhumarCategory);
        ZulhumarCategory.click();
        testUtility.waitForElementPresent(DeleteCategory);
        DeleteCategory.click();
    driver.switchTo().alert().accept();

}
  public boolean verifyDeleteRootCategory(){
      testUtility.waitForElementPresent(successfullyDeletedMessage);
      return true;
  }

}
