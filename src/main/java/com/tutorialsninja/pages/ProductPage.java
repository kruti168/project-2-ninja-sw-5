package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListener;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ProductPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//div[@id = 'content']//h1")
    WebElement productText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calendarButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement  monthAndYearText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
   List< WebElement> dateList;

    @CacheLookup
    @FindBy(css = "#input-quantity")
    WebElement qtyField;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCartLink;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement datePicker;

    public String getProductText() {
        Reporter.log("Verify Product Text");
        CustomListener.test.log(Status.PASS,"Verify Text PRODUCT");
        return getTextFromElement(productText);

    }

    public void selectDeliveryDate(String day, String month, String year) {
        clickOnElement(datePicker);
        while (true) {
            String monthAndYear = getTextFromElement(monthAndYearText);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
        List<WebElement> allDates = dateList;
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(day)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnAddToCartButton() {
        Reporter.log("Click on Add To Cart");
        clickOnElement(addToCartButton);
        CustomListener.test.log(Status.PASS,"Click on Add to Cart");
    }

    public String getProductAddedSuccessMessage() {
        Reporter.log("Verify Product Added Successfully ");
        CustomListener.test.log(Status.PASS,"Verify Product added succesfully");
        return getTextFromElement(successMessage);

    }

    public void clickOnShoppingCartLinkIntoMessage() {
        Reporter.log("Click on shopping cart Link");
        clickOnElement(shoppingCartLink);
        CustomListener.test.log(Status.PASS,"Click on shopping cart");

    }

    public void enterQuantity(String qty) {
        Reporter.log("Enter Quantity");
        clearQty(qtyField);
        sendTextToElement(qtyField, qty);
        CustomListener.test.log(Status.PASS,"Enter Quantity");
    }
}



