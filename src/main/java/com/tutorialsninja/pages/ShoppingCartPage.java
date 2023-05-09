package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListener;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate ;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qtyField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement qtyUpdateBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;

    public String getShoppingCartText() {
        Reporter.log("Verify Shopping cart");
        CustomListener.test.log(Status.PASS,"Verify Shopping cart");
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        Reporter.log("Verify Text Product");
        CustomListener.test.log(Status.PASS,"Verify text product");
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        Reporter.log("Get delivery date");
        CustomListener.test.log(Status.PASS,"Get delivery date");
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
        Reporter.log("Get Model");
        CustomListener.test.log(Status.PASS,"Get Model");
        return getTextFromElement(model);
    }

    public String getTotal() {
        Reporter.log("Get Total");
        CustomListener.test.log(Status.PASS,"Get Total");
        return getTextFromElement(total);
    }

    public void changeQuantity(String qty) {
        Reporter.log("Change Quantity");
        sendTextToElement(qtyField, "1");
        CustomListener.test.log(Status.PASS,"Change Quantity");
    }

    public void clickOnQtyUpdateButton() {
        Reporter.log("Click on QtyButton");
        clickOnElement(qtyUpdateBtn);
        CustomListener.test.log(Status.PASS,"Click on Qty Button");
    }

    public String getSuccessModifiedMessage() {
        Reporter.log("Verify Success Modified Message");
        CustomListener.test.log(Status.PASS,"Verify Success Modified Message");
        return getTextFromElement(successModifiedMessage);
    }
}
