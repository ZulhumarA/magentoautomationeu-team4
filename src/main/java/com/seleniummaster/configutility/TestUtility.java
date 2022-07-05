package com.seleniummaster.configutility;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtility {

    private WebDriver driver;

    private int timeout=Integer.parseInt(ApplicationConfig.readFromConfigProperties(
            "config.properties","timeout"
    ));

    Faker faker = new Faker();

    public TestUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String generateFirstName() {
        String firstName=faker.name().firstName();
        return firstName;
    }

    public String generateLastName() {
        String lastName=faker.name().lastName();
        return lastName;
    }

    public String fakeProductName(){
        String productName=faker.commerce().productName();
        return productName;
    }

    public String fakeEmail(){
       String email=faker.internet().emailAddress();
       return email;
    }

    public void waitForAlertPresent(){
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void selectValueFromDropDown(WebElement webelement,String value){
        Select s=new Select(webelement);
        s.selectByValue(value);
    }

    public void selectValueFromDropDown(WebElement webelement,int index){
        Select s=new Select(webelement);
        s.selectByIndex(index);
    }

}


