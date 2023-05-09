package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListener;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Utility {

    @CacheLookup
     @FindBy(linkText = "Desktops")
    WebElement  mouseHoverDesktops;

    @CacheLookup
    @FindBy(linkText = "Show AllDesktops")
    WebElement  clickShowAllDesktops;


    //Mouse hover on Desktops Tab.and click
    public void mouseHoverOnDesktopsTabAndClick(){
      mouseHoverToElementAndClick(mouseHoverDesktops);
        CustomListener.test.log(Status.PASS,"mouseHover Desktopsan"+ mouseHoverDesktops);

    }
    //Click on “Show All Desktops”
    public void clickOnShowAllDesktops(){

       clickOnElement(clickShowAllDesktops);
       CustomListener.test.log(Status.PASS,"clickOnAllDeskTops" + clickShowAllDesktops);
    }
}
