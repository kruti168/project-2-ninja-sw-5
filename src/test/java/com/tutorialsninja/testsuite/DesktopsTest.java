package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlistener.CustomListener;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListener.class)
public class DesktopsTest extends BaseTest {

    HomePage homePage;
    DesktopsPage desktopsPage;
    ProductPage productPage;
    ShoppingCartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();

    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {
        homePage.selectCurrency("£ Pound Sterling");
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show All Desktops");
        List<WebElement> beforeFilterNameZtoAList = getListOfElements(By.xpath("//h4"));
        List<String> beforeFileNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : beforeFilterNameZtoAList) {
            beforeFileNameZtoAList.add(nameZtoA.getText());
        }
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");

        List<WebElement> afterFilterNameZtoAList = driver.findElements(By.xpath("//h4"));
        List<String> afterFileNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : afterFilterNameZtoAList) {
            afterFileNameZtoAList.add(nameZtoA.getText());
        }

        // Verify the Product will arrange in Descending order
        Collections.reverse(beforeFileNameZtoAList);
        System.out.println("Before :-" + beforeFileNameZtoAList);
        System.out.println("After :-" + afterFileNameZtoAList);
        Assert.assertEquals(beforeFileNameZtoAList, afterFileNameZtoAList);


    } @Test(groups = {"smoke","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully(){
        {
            homePage.selectCurrency("£ Pound Sterling");
            homePage.mouseHoverOnDesktopsLinkAndClick();
            homePage.selectMenu("Show All Desktops");
            desktopsPage.selectSortByOption("Name (A - Z)");
            desktopsPage.selectProductByName("HP LP3065");
            Assert.assertEquals(productPage.getProductText(), "HP LP3065", "HP LP3065 Product not display");
            productPage.selectDeliveryDate("30", "November", "2023");
            productPage.enterQuantity("1");
            productPage.clickOnAddToCartButton();
            Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added HP LP3065 to your shopping cart!"),
                "Product not added to cart");
           productPage.clickOnShoppingCartLinkIntoMessage();
      //     Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"));
           Assert.assertEquals(cartPage.getProductName(), "HP LP3065", "Product name not matched");
           Assert.assertTrue(cartPage.getDeliveryDate().contains("2023-11-30"), "Delivery date not matched");
           Assert.assertEquals(cartPage.getModel(), "Product 21", "Model not matched");
           Assert.assertEquals(cartPage.getTotal(), "£74.73", "Total not matched");
        }
    }
}