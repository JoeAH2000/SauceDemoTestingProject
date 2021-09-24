package com.sparta.sdet.tests;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.CheckoutStepTwoPage;
import org.junit.jupiter.api.*;

import static com.sparta.sdet.base.TestBase.webDriver;

public class CheckoutStepTwoTests {
    private CheckoutStepTwoPage checkoutStepTwoPage;

    private String itemName;
    @BeforeEach
    void setup() {
        TestBase.initialisation();
        //Get to CheckoutPage AND add an item
        checkoutStepTwoPage = new CheckoutStepTwoPage();
        itemName = "";
        webDriver.get("https://www.saucedemo.com/");
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
        @DisplayName("subTotalTest")
        void subTotalTest() {
            double subTotal = checkoutStepTwoPage.getItemTotal();
            Assertions.assertEquals(29.99, subTotal);
        }

        @Test
        @DisplayName("texTest")
        void texTest() {
            double tax = checkoutStepTwoPage.getTax();
            Assertions.assertEquals(2.40, tax);
        }

        @Test
        @DisplayName("totalTest")
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
}
