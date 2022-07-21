package com.seleniummaster.ui.backend.customersmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FilterCustomersByGroupPage {

    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[3]/div/div[2]/div/table/thead/tr[2]/th[5]/select/option[3]")
    WebElement GroupNameField;

    @FindBy(xpath ="//*[@title=\"Search\" and @class=\"scalable task\"]")
    WebElement searchButton;

    @FindAll(@FindBy(css = "table#customerGrid_table>tbody>tr"))
    List<WebElement> customerRowList;

    //constructor
    public FilterCustomersByGroupPage(WebDriver driver) {
        this.driver = driver;
        testUtility = new TestUtility(driver);
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void filterCustomersByGroup() {
     testUtility.waitForElementPresent(GroupNameField);
     GroupNameField.click();
     testUtility.sleep(6);
     testUtility.waitForElementPresent(searchButton);
     searchButton.click();
     testUtility.sleep(6);
    }


    public void verifyFilteredSuccessfully() {
        int rowNum = customerRowList.size();
         List<String> groupNameList = new ArrayList<>();
         int i;
        for (i = 0; i < rowNum; i++) {
            String groupNameLocation = String.format("//*[@id=\"customerGrid_table\"]/tbody/tr[%d]/td[5]", i+1);
            String groupName =driver.findElement(By.xpath(groupNameLocation)).getText();
            groupNameList.add(groupName);
            System.out.println(groupNameList);
            if (groupNameList.get(i).equals(GroupNameField.getText())){
                System.out.println("tets pass in row "+(i+1));
            }
            else{
                System.out.println("test fail in row "+(i+1));
            }


       }
      }
}
