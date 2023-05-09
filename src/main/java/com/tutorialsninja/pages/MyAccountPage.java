package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListener;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MyAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreatedText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;



    public String getAccountLogoutText()
    {
        Reporter.log("Verify Account Logout Text");
        CustomListener.test.log(Status.PASS,"Verify Logout");
        return getTextFromElement(accountLogoutText);
    }

    public String getYourAccountHasBeenCreatedText()
    {   Reporter.log("Verify Account Has Been Created Text");
        CustomListener.test.log(Status.PASS,"Verify Account Has Been Created Text");
        return getTextFromElement(accountCreatedText);
    }
    public void clickOnContinueButton()
    {   Reporter.log("Click on Continue Button");
        clickOnElement(continueBtn);
        CustomListener.test.log(Status.PASS,"Click on Continue Button");
    }

}
