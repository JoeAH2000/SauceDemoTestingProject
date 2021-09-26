package com.sparta.sdet.tests;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.*;
import com.sparta.sdet.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CheckoutStepOnePageTests extends TestBase {
    private CheckoutStepOnePage csOnePage;
    private CheckoutStepTwoPage csTwoPage;
    private CartPage cartPage;
    private InventoryPage inventoryPage;
    private LoginPage loginPage;

    @BeforeEach
    void setup() {
        initialisation();
        loginPage = new LoginPage();
        PageFactory.initElements(webDriver, loginPage);//Might be an issue
        loginPage.setUsername(PropertiesLoader.getProperties().getProperty("Username"));
        loginPage.setPassword(PropertiesLoader.getProperties().getProperty("Password"));
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.loginButtonClick();

        inventoryPage = new InventoryPage();
        PageFactory.initElements(webDriver, inventoryPage);
        inventoryPage.clickAddToCardButton();
        inventoryPage.clickShoppingCart();

        cartPage = new CartPage();
        PageFactory.initElements(webDriver, cartPage);

        csOnePage = cartPage.goToCheckout();
        PageFactory.initElements(webDriver, csOnePage);
    }

    @Nested
    @DisplayName("Getter Tests")
    class GetterTestClass {
        @Test
        @DisplayName("Test if first name is returned.")
        void testFirstNameIsReturned() {
            csOnePage.fillFirstName();
            Assertions.assertEquals(PropertiesLoader.getProperties().getProperty("firstName"), csOnePage.getFirstName().getAttribute("value"));
        }

        @Test
        @DisplayName("Test if last name is returned.")
        void testIfLastNameIsReturned() {
            csOnePage.fillLastName();
            Assertions.assertEquals(PropertiesLoader.getProperties().getProperty("lastName"), csOnePage.getLastName().getAttribute("value"));
        }

        @Test
        @DisplayName("Test if postcode is returned")
        void testIfPostcodeIsReturned() {
            csOnePage.fillPostalCode();
            Assertions.assertEquals(PropertiesLoader.getProperties().getProperty("postCode"), csOnePage.getPostcode().getAttribute("value"));
        }

        @Test
        @DisplayName("Test if current web page url is returned")
        void testIfCurrentWebPageUrlIsReturned() {
            Assertions.assertEquals(PropertiesLoader.getProperties().getProperty("UrlCheckoutStepOne") ,csOnePage.getUrl());
        }

        @Test
        @DisplayName("Test if error message is returned")
        void testIfErrorMessageIsReturned() {
            csOnePage.clickContinue();
            Assertions.assertEquals("Error: First Name is required", csOnePage.getErrorMessage());
        }
    }

    @Nested
    @DisplayName("Entering checkout info")
    class enterDetails {

        @Test
        @DisplayName("Test if all fields are entered")
        void testIfAllFieldsAreEntered() {
            csOnePage.fillInAllFields();
            Assertions.assertEquals(
                    PropertiesLoader.getProperties().getProperty("firstName")+
                    PropertiesLoader.getProperties().getProperty("lastName")+
                    PropertiesLoader.getProperties().getProperty("postCode"),
                    csOnePage.getFirstName().getAttribute("value")+
                    csOnePage.getLastName().getAttribute("value")+
                    csOnePage.getPostcode().getAttribute("value"));
        }
    }

    @Nested
    @DisplayName("Test for missing fields")
    class MissingFieldsClass {
        @Test
        @DisplayName("TestMissingFirstName")
        void testMissingFirstName() {
            Assertions.assertTrue(csOnePage.isFirstNameBlank());
        }
        @Test
        @DisplayName("testMissingLastName")
        void testMissingLastName() {
            Assertions.assertTrue(csOnePage.isLastNameBlank());
        }
        @Test
        @DisplayName("testMissingZipPostCode")
        void testMissingPostCode() {
            Assertions.assertTrue(csOnePage.isPostalCodeBlank());
        }
        @Test
        @DisplayName("TestMissingAll")
        void testMissingAll() {
            Assertions.assertTrue((csOnePage.areAllFieldsBlank()));
        }
    }

    @Nested
    @DisplayName("Test for valid fields")
    class ValidFieldsClass {
        @Test
        @DisplayName("TestValidFirstName")
        void testValidFirstName() {
            Assertions.assertTrue(csOnePage.isFirstNameValid());
        }
        @Test
        @DisplayName("testValidLastName")
        void testValidLastName() {
            Assertions.assertTrue(csOnePage.isLastNameValid());
        }
        @Test
        @DisplayName("testValidZipPostCode")
        void testValidPostCode() {
            Assertions.assertTrue(csOnePage.isPostalCodeValid());
        }
        @Test
        @DisplayName("TestValidAll")
        void testValidAll() {
            Assertions.assertTrue((csOnePage.areAllFieldsValid()));
        }
    }

    @Nested
    @DisplayName("Test for valid fields")
    class EmptyErrorDisplayedClass {
        @Test
        @DisplayName("TestEmptyErrorDisplayedFirstName")
        void testEmptyErrorDisplayedFirstName() {
            csOnePage.clickContinue();
            Assertions.assertTrue(csOnePage.isFirstNameEmptyErrorDisplayed());
        }
        @Test
        @DisplayName("testEmptyErrorDisplayedLastName")
        void testEmptyErrorDisplayedLastName() {
            csOnePage.fillFirstName();
            csOnePage.clickContinue();
            Assertions.assertTrue(csOnePage.isLastNameEmptyErrorDisplayed());
        }
        @Test
        @DisplayName("testEmptyErrorDisplayedZipPostCode")
        void testEmptyErrorDisplayedPostCode() {
            csOnePage.fillFirstName();
            csOnePage.fillLastName();
            csOnePage.clickContinue();
            Assertions.assertTrue(csOnePage.isPostalCodeEmptyErrorDisplayed());
        }
        @Test
        @DisplayName("TestEmptyErrorDisplayedAll")
        @Disabled("Only first error message being displayed. Developers to fix")
        void testEmptyErrorDisplayedAll() {
            Assertions.assertTrue((csOnePage.areAllEmptyFieldsErrorDisplayed()));
        }
    }

    @Nested
    @DisplayName("Test Navigation")
    class navigation {
        @Test
        @DisplayName("Test cancel checkout")
        void testCancelCheckout() {
            Assertions.assertEquals(
                    PropertiesLoader.getProperties().get("UrlCart"),
                    csOnePage.goToCartPage().getUrl()
            );
        }

        @Test
        @DisplayName("Test Checkout step two page")
        void testCheckoutStepTwo() {
            csOnePage.fillInAllFields();
            Assertions.assertEquals(
                    PropertiesLoader.getProperties().get("UrlCheckoutStepTwo"),
                    csOnePage.goToCheckoutStepTwoPage().getUrl());
        }
    }

    @AfterEach
    void teardown() {
        webDriver.quit();
    }
}
