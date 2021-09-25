package com.sparta.sdet.tests;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.CartPage;
import org.junit.jupiter.api.*;

import static com.sparta.sdet.base.TestBase.webDriver;

public class CartTests {
    private CartPage cartPage;

    @BeforeEach
    void setup() {
        TestBase.initialisation();
        cartPage = new CartPage();
        webDriver.get("https://www.saucedemo.com/");
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
