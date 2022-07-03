package com.seleniummaster.ui.backend.customersmodule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomersPage {

    @FindBy(id="username")
    WebElement userNameField;

    @FindBy(id="login")
    WebElement passwordField;

    @FindBy(xpath = "//*[@value=\"Login\"]")
    WebElement loginButton;
}
