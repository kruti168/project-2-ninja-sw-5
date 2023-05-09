package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListener;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenu;

    @CacheLookup
    @FindBy(linkText= "Desktops")
    WebElement desktopLink ;

    @CacheLookup
    @FindBy(linkText = "Show AllDesktops")
    WebElement clickOnShowAllDesktops;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show AllLaptops & Notebooks')]")
    WebElement showAllLaptop;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink ;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement  componentsLinks ;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTab ;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    List<WebElement> currencyList ;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement  myAccountTab;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> myAccountOptions ;

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = topMenu;
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = topMenu;
        }
    }
    public void mouseHoverOnDesktopsLinkAndClick() {
        Reporter.log("MouseHoover On DeskTop link");
        mouseHoverToElementAndClick(desktopLink);
        clickOnElement(clickOnShowAllDesktops);
        CustomListener.test.log(Status.PASS,"MouseHoover On Desktop Link");
    }
    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        Reporter.log("MouseHoover On Laptops ");
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
        clickOnElement(showAllLaptop);
        CustomListener.test.log(Status.PASS,"MouseHoover On LaptopsAND Notebooks");

    }
    public void mouseHoverOnComponentLinkAndClick() {
        Reporter.log("MouseHoover Components");
        mouseHoverToElementAndClick(componentsLinks);
        CustomListener.test.log(Status.PASS,"MouseHoover On Component");

    }
    public void selectCurrency(String currency) {
        clickOnElement(currencyTab);
        List<WebElement> listOfElements = currencyList;
        for (WebElement e : listOfElements) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                break;
            }
        }
    }
    public void clickOnMyQAccountTab() {
        Reporter.log("Click On My Account Tab");
        clickOnElement(myAccountTab);
        CustomListener.test.log(Status.PASS,"Click On My Account Tab");
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = myAccountOptions;
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = myAccountOptions;
        }
    }
}




