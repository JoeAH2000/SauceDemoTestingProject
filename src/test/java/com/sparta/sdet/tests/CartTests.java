package com.sparta.sdet.tests;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.CartPage;
import com.sparta.sdet.pages.InventoryItemPage;
import com.sparta.sdet.pages.LoginPage;
import com.sparta.sdet.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static com.sparta.sdet.base.TestBase.webDriver;

public class CartTests {

    private CartPage cartPage;
    private LoginPage loginPage;

    @BeforeEach
    void setup() {
        TestBase.initialisation();
        loginPage = new LoginPage();


        PageFactory.initElements(webDriver, loginPage);

        //login
        loginPage.setUsername(PropertiesLoader.getProperties().getProperty("Username"));
        loginPage.setPassword(PropertiesLoader.getProperties().getProperty("Password"));
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.login();



        cartPage = new CartPage();
        PageFactory.initElements(webDriver, cartPage);

        //Add item to cart and go to cart page
        webDriver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        webDriver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        webDriver.findElement(By.className("shopping_cart_link")).click();

        //PageFactory.initElements(webDriver, cartPage);


    }

    @Nested
    @DisplayName("Cart Functional Tests")
    class CartFunctionalTests {
        @Test
        @DisplayName("goToCheckoutTest")
        void goToCheckoutTest() {
            cartPage.goToCheckout();
            Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("goToHomepageTest")
        void goToHomepageTest() {
            cartPage.gotoHomepage();
            Assertions.assertEquals("https://www.saucedemo.com/inventory.html", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("removeItemFromCartTest")
        void removeItemFromCartTest() {
            int numItems = cartPage.getNumberOfItems();
            cartPage.removeItemFromCart("Sauce Labs Backpack");
            Assertions.assertTrue(numItems > cartPage.getNumberOfItems());
        }
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}
