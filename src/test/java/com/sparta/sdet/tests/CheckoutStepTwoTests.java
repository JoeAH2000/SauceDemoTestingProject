package com.sparta.sdet.tests;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.CheckoutStepTwoPage;
import com.sparta.sdet.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CheckoutStepTwoTests {

    private LoginPage loginPage;
    private CheckoutStepTwoPage checkoutStepTwoPage;

    @BeforeEach
    void setup() {
        TestBase.initialisation();
        loginPage = new LoginPage();



    }

    @Test
    @DisplayName("Test URL is correct")
    void testUrlIsCorrect() {

    }

    @Nested
    @DisplayName("Test Navigation")
    class navigation {

        @Test
        @DisplayName("testCompletingOrder")
        void testCompletingOrder() {

        }

        @Test
        @DisplayName("Test cancelling order")
        void testCancellingOrder() {

        }

        @Test
        @DisplayName("Test clicking on cart icon")
        void testClickingOnCartIcon() {

        }

        @Test
        @DisplayName("Test moving to about page")
        void testMovingToAboutPage() {

        }

        @Test
        @DisplayName("Test moving to inventory page")
        void testMovingToInventoryPage() {

        }

        @Test
        @DisplayName("test moving to facebook page")
        void testMovingToFacebookPage() {

        }

        @Test
        @DisplayName("Test moving to twitter page")
        void testMovingToTwitterPage() {

        }

        @Test
        @DisplayName("test moving to linkedin page")
        void testMovingToLinkedinPage() {

        }

    }

    @Nested
    @DisplayName("Test Checkout Overview")
    class overview {

        @Nested
        @DisplayName("Non-Empty Cart")
        class nonEmptyCart {

            @Test
            @DisplayName("Test number of items is as expected")
            void testNumberOfItemsIsAsExpected() {

            }

            @Test
            @DisplayName("Test item name is accurate")
            void testItemNameIsAccurate() {

            }

            @Test
            @DisplayName("Test item quantity is accurate")
            void testItemQuantityIsAccurate() {

            }

            @Test
            @DisplayName("test item description is accurate")
            void testItemDescriptionIsAccurate() {

            }

            @Test
            @DisplayName("test item cost is accurate")
            void testItemCostIsAccurate() {

            }

            @Test
            @DisplayName("test payment info is correct")
            void testPaymentInfoIsCorrect() {

            }

            @Test
            @DisplayName("test shipping infois correct")
            void testShippingInfoisCorrect() {

            }

            @Test
            @DisplayName("test total item cost is correct")
            void testTotalCostIsCorrect() {

            }

            @Test
            @DisplayName("test tax is correct")
            void testTaxIsCorrect() {

            }

            @Test
            @DisplayName("test total order cost is correct")
            void testTotalOrderCostIsCorrect() {

            }

            @Test
            @DisplayName("Test item price is to 2 decimal places")
            void testItemPriceIsTo2DecimalPlaces() {

            }

            @Test
            @DisplayName("test total item cost is to two decimal places")
            void testTotalItemCostIsToTwoDecimalPlaces() {

            }

            @Test
            @DisplayName("test tax is to two decimal places")
            void testTaxIsToTwoDecimalPlaces() {

            }

            @Test
            @DisplayName("test total order cost is to two decimal places")
            void testTotalOrderCostIsToTwoDecimalPlaces() {

            }

        }

    }

}
