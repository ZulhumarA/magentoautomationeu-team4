package com.seleniummaster.ui.backend.catalogmodule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductsPage {

    @FindBy(id="id_c1592bf502871cd5d25ace2477e1cf85")
    WebElement AddProductsLink;

    @FindBy(id="attribute_set_id")
    WebElement AttributeSetLink;

    @FindBy(id="product_type")
    WebElement ProductTypeLink;

    @FindBy(xpath = "//td[contains(.,'Continue')]")
    WebElement ContinueButton;

    @FindBy(name="product[name]")
    WebElement NameLink;

    @FindBy(id="description")
    WebElement DescriptionLink;

    @FindBy(id="short_description")
    WebElement ShoreDescription;

    @FindBy(name="product[sku]")
    WebElement SKU;

    @FindBy(id="weight")
    WebElement Weight;

    @FindBy(id="status")
    WebElement StatusDropDownList;

    @FindBy(name="product[visibility]")
    WebElement VisibilityLink;

    @FindBy(id="id_276556512183203cc7eba4de11c98c8d")
    WebElement SaveButton;

    @FindBy(id="price")
    WebElement PriceLink;

    @FindBy(id="tax_class_id")
    WebElement TextClass;

    @FindBy(xpath="//*[contains(text(),\"The product has been saved.\")]")
    WebElement SucccessMessage;











}
