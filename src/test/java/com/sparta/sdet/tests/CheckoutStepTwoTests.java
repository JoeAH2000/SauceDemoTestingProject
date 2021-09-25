package com.sparta.sdet.tests;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.*;
import com.sparta.sdet.util.PropertiesLoader;
import io.cucumber.java.sl.In;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.sparta.sdet.base.TestBase.Properties;
import static com.sparta.sdet.base.TestBase.webDriver;

public class CheckoutStepTwoTests {
    private CheckoutStepTwoPage checkoutStepTwoPage;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutStepOnePage checkoutStepOnePage;

    private String itemName;
    @BeforeEach
    void setup() {
        TestBase.initialisation();
        webDriver.get("https://www.saucedemo.com/");
        itemName = "Sauce Labs Backpack";

        moveToCheckOutStepTwo();

        checkoutStepTwoPage = new CheckoutStepTwoPage();
        PageFactory.initElements(webDriver, checkoutStepTwoPage);
    }

    @Nested
    @DisplayName("Checkout-Step-Two Functional Tests")
    class CheckoutStepTwoFunctionalTests {
        @Test
        @DisplayName("finaliseCheckoutTest")
        void finaliseCheckoutTest() {
            checkoutStepTwoPage.finaliseCheckout();
            Assertions.assertEquals("https://www.saucedemo.com/checkout-complete.html", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("cancelCheckoutTests")
        void cancelCheckoutTests() {
            checkoutStepTwoPage.cancelCheckout();
            Assertions.assertEquals("https://www.saucedemo.com/inventory.html", webDriver.getCurrentUrl());
        }
    }

    @Nested
    @DisplayName("Checkout-Step-Two Data Tests")
    class CheckoutStepTwoDataTests {
        @Test
        @DisplayName("Sub-Total Test")
        void subTotalTest() {
            double subTotal = checkoutStepTwoPage.getItemTotal();
            Assertions.assertEquals(29.99, subTotal);
        }

        @Test
        @DisplayName("Tax Test")
        void taxTest() {
            double tax = checkoutStepTwoPage.getTax();
            Assertions.assertEquals(2.40, tax);
        }

        @Test
        @DisplayName("Total Test")
        void totalTest() {
            double total = checkoutStepTwoPage.getTotal();
            Assertions.assertEquals(32.39, total);
        }

        @Test
        @DisplayName("paymentInfoTest")
        void paymentInfoTest() {
            String paymentInfo = checkoutStepTwoPage.getPaymentInformation();
            Assertions.assertEquals("SauceCard #31337", paymentInfo);
        }

        @Test
        @DisplayName("shippingInfoTest")
        void shippingInfoTest() {
            String shippingInfo = checkoutStepTwoPage.getShippingInformation();
            Assertions.assertEquals("FREE PONY EXPRESS DELIVERY!", shippingInfo);
        }

        @Test
        @DisplayName("itemPriceTest")
        void itemPriceTest() {
            double itemPrice = checkoutStepTwoPage.getItemPrice(itemName);
            Assertions.assertEquals(29.99, itemPrice);
        }

        @Test
        @DisplayName("itemDescTest")
        void itemDescTest() {
            String itemDesc = checkoutStepTwoPage.getItemDescription(itemName);
            Assertions.assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", itemDesc);
        }

        @Test
        @DisplayName("itemQuantityTest")
        void itemQuantityTest() {
            int itemQuantity = checkoutStepTwoPage.getItemQuantity(itemName);
            Assertions.assertEquals(1, itemQuantity);
        }
    }

    private void moveToCheckOutStepTwo() {
        loginPage = new LoginPage();

        loginPage.setUsername(PropertiesLoader.getProperties().getProperty("Username"));
        loginPage.setPassword(PropertiesLoader.getProperties().getProperty("Password"));
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.loginButtonClick();

        inventoryPage = new InventoryPage();
        inventoryPage.clickAddToCardButton();
        inventoryPage.clickShoppingCart();

        cartPage = new CartPage();

        PageFactory.initElements(webDriver, cartPage);
        checkoutStepOnePage = cartPage.goToCheckout();
        PageFactory.initElements(webDriver, checkoutStepOnePage);
        checkoutStepOnePage.fillInAllFields();
        checkoutStepOnePage.goToCheckoutStepTwoPage();
    }

    @AfterEach
    void teardown() {
        webDriver.quit();
    }

}
