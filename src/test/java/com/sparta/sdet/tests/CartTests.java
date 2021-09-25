package com.sparta.sdet.tests;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.CartPage;
import com.sparta.sdet.pages.InventoryPage;
import com.sparta.sdet.pages.LoginPage;
import com.sparta.sdet.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

import static com.sparta.sdet.base.TestBase.webDriver;

public class CartTests extends TestBase {
    private CartPage cartPage;

    @BeforeEach
    void setup() {
        TestBase.initialisation();
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        // webDriver.get("https://www.saucedemo.com/");

        PageFactory.initElements(webDriver, this);
        loginPage.setUsername(PropertiesLoader.getProperties().getProperty("Username"));
        loginPage.setPassword(PropertiesLoader.getProperties().getProperty("Password"));
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.login();

        inventoryPage.clickShoppingCart();
        PageFactory.initElements(webDriver, cartPage);
    }

    public CartTests() {
        super();
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
            //UNIMPLEMENTED, NEEDS INVENTORY TO BE IMPLEMENTED FIRST
        }

    }
}
