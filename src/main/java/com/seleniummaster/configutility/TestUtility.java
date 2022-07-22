package com.seleniummaster.configutility;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import com.google.gson.Gson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Map;

public class TestUtility {

    private WebDriver driver;

    private int timeout = Integer.parseInt(ApplicationConfig.readFromConfigProperties(
            "config.properties", "timeout"
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
        String firstName = faker.name().firstName();
        return firstName;
    }


    public String generateTitle(){
        String title=faker.name().title();
        return title;
    }

    public String generateLastName() {
        String lastName = faker.name().lastName();
        return lastName;
    }

    public String generateCity() {
        String city = faker.address().city();
        return city;
    }

    public String generateZip() {
        String zip = faker.address().zipCode();
        return zip;
    }
    //Zulhumar's Fakes
    public String fakeCategoryName() {
        String categoryName = faker.name().name();
        return categoryName;
    }
    public String fakePageTitle() {
        String title = faker.name().title();
        return title;
    }
        public String metaKeywords() {
            String metaKeyword = faker.commerce().productName();
            return metaKeyword;
        }
    public String metaDescriptions() {
        String metaDescription = faker.commerce().productName();
        return metaDescription;
    }

    public String generateAdminName(){
        String admin=faker.name().name();
        return admin;
    }

    public String  generateRandomLetter() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        System.out.println(generatedString.toLowerCase());
        return generatedString.toLowerCase();
    }

      //Zulhumar's finished.


    public String fakeEmail() {
        String email = faker.internet().emailAddress();
        return email;
    }

    public void waitForAlertPresent(){
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void selectValueFromDropDown(WebElement webelement, String value) {
        Select s = new Select(webelement);
        s.selectByValue(value);
    }

    public void selectValueFromDropDown(WebElement webelement, int index) {
        Select s = new Select(webelement);
        s.selectByIndex(index);
    }

    public int generateRandomNumbers(int max, int min){
        return ((int)(Math.random() * max) + min);
    }



    public void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


