package com.seleniummaster.configutility;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

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
    public String generatePassword(){
        long length=8;
        String generateLong= RandomStringUtils.randomNumeric((int) length);
        return generateLong;
    }


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

    public String generateRandomSentence() {
        return faker.lorem().sentence();
    }


    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100);

    }


    public void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String fakeCartPriceRulesName(){
     String fakeRuleNames=faker.business().creditCardType().toUpperCase();
     return  fakeRuleNames;
    }

}


