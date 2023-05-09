package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListener;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class DesktopsPage extends Utility {




    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;

    public void getDesktopsText()
    {
        Reporter.log(" Verify the text ‘Desktops’");

        String expectedText = "Desktops";
        String actualText = getTextFromElement(desktopsText);
        Assert.assertEquals(actualText, expectedText, "Not navigate to Desktop page");
        CustomListener.test.log(Status.PASS,"Verify the text ‘Desktops’");
    }

    public ArrayList<String> getProductsNameList(){

        List<WebElement> products = productsList;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        return originalProductsName;
    }
    public void selectProductByName(String product) {
        List<WebElement> products = productsList;
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

    public void selectSortByOption(String option) {
        Reporter.log("Select Sort by option");
        selectByVisibleTextFromDropDown(sortBy, option);
        CustomListener.test.log(Status.PASS,"Select sort by option");
    }
}
