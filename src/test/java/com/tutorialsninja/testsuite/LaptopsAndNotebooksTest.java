package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlistener.CustomListener;
import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collections;
import java.util.List;
@Listeners(CustomListener.class)
public class LaptopsAndNotebooksTest extends BaseTest {


    HomePage homePage;
    DesktopsPage desktopsPage;
    ProductPage productPage;
    ShoppingCartPage cartPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        SoftAssert softAssert = new SoftAssert();

    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        homePage.selectCurrency("£ Pound Sterling");
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
        // Get all the products price and stored into array list
        List<Double> originalProductsPrice = laptopsAndNotebooksPage.getProductsPriceList();
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        // Select sort by Price (High > Low)
    //    laptopsAndNotebooksPage.selectSortByOption("Price (High > Low)");
        // After filter Price (High > Low) Get all the products name and stored into array list
    //    ArrayList<Double> afterSortByPrice = laptopsAndNotebooksPage.getProductsPriceList();
   //     Assert.assertEquals(originalProductsPrice, afterSortByPrice, "Product not sorted by price High to Low");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatUserPlaceOrderSuccessfully() {
        homePage.selectCurrency("£ Pound Sterling");
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
    //    laptopsAndNotebooksPage.selectSortByOption("Price (High > Low)");
        laptopsAndNotebooksPage.selectProductByName("MacBook");
        Assert.assertEquals(productPage.getProductText(), "MacBook", "MacBook Product not display");
        productPage.clickOnAddToCartButton();
        Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added MacBook to your shopping cart!"),
                "Product not added to cart");
        productPage.clickOnShoppingCartLinkIntoMessage();
        Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"));
        Assert.assertEquals(cartPage.getProductName(), "MacBook", "Product name not matched");
        cartPage.changeQuantity("2");
        cartPage.clickOnQtyUpdateButton();
        Assert.assertTrue(cartPage.getSuccessModifiedMessage().contains("Success: You have modified your shopping cart!"));
    //    softAssert.assertEquals(cartPage.getTotal(), "£737.45", "Total not matched");
    //    softAssert.assertAll();
    }


}
