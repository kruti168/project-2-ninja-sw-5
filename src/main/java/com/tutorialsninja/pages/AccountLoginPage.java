package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListener;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[1]//h2")
    WebElement newCustomerText;


    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddressField;


    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;


    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;


    public String getReturningCustomerText() {
        Reporter.log("Verify Returning Customer Text");
        CustomListener.test.log(Status.PASS, "Verify Returning Customer Text");
        return getTextFromElement(returningCustomerText);

    }

    public String getNewCustomerText() {
        Reporter.log("Verify New Customer Text");
        CustomListener.test.log(Status.PASS, "Verify New Customet Text");
        return getTextFromElement(newCustomerText);
    }

    public void enterEmailAddress(String email) {
        Reporter.log("Enter Email");
        sendTextToElement(emailAddressField, email);
        CustomListener.test.log(Status.PASS, "Enter Email");
    }

    public void enterPassword(String password)
    {   Reporter.log("Enter Password");
        sendTextToElement(passwordField, password);
        CustomListener.test.log(Status.PASS,"Enter Password");
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on Login Button");
        clickOnElement(loginBtn);
        CustomListener.test.log(Status.PASS,"Click on Login Button");
    }
}