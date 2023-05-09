package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListener;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class AccountRegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;

    @CacheLookup
    @FindBy(id  = "input-firstname")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement LastNameField;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement  telephoneField;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement  passwordConfirmField;

    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    List<WebElement> subscribeRadios;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement  continueBtn;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;


    public String getRegisterAccountText() {
        Reporter.log("Verify Register Account Text");
        CustomListener.test.log(Status.PASS,"Verify Register Account Text");
        return getTextFromElement(registerAccountText);

    }

    public void enterFirstName(String fName) {
        Reporter.log("Enter First Name");
        CustomListener.test.log(Status.PASS,"Enter First Name");
        sendTextToElement(firstNameField, fName);
    }

    public void enterLastName(String lName) {
        Reporter.log("Enter Last Name");
        CustomListener.test.log(Status.PASS,"Enter Last Name");
        sendTextToElement(LastNameField, lName);
    }

    public void enterEmail(String email) {
        Reporter.log("Enter Email");
        CustomListener.test.log(Status.PASS,"Enter Email");
        sendTextToElement(emailField, email);
    }

    public void enterTelephone(String telephone) {
        Reporter.log("Enter Telephone");
        sendTextToElement(telephoneField, telephone);
        CustomListener.test.log(Status.PASS,"Enter Telephone");
    }

    public void enterPassword(String password) {
        Reporter.log("Enter Password");
        sendTextToElement(passwordField, password);
        CustomListener.test.log(Status.PASS,"Enter Password");
    }

    public void enterConfirmPassword(String cPassword) {
        Reporter.log("Enter Confirmed Password");
        sendTextToElement(passwordConfirmField, cPassword);
        CustomListener.test.log(Status.PASS,"Enter Confirmed Password");
    }

    public void selectSubscription(String option) {
        List<WebElement> radioButtons = (subscribeRadios);
        for (WebElement e : radioButtons) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckBox() {
        Reporter.log("Click on Privacy Policy Checkboax");
        clickOnElement(privacyPolicyCheckBox);
        CustomListener.test.log(Status.PASS,"Click on Privacy policy checkbox");
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on Continue Button");
        clickOnElement(continueBtn);
        CustomListener.test.log(Status.PASS,"Click on Continue Button");
    }
}
