package com.sparta.sdet.tests;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.*;
import com.sparta.sdet.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
@Disabled
public class CheckoutStepOnePageTests extends TestBase {
    private static WebDriver webDriver;
    private CheckoutStepOnePage csOnePage;
    private CheckoutStepTwoPage csTwoPage;
    private CartPage cartPage;
    private InventoryPage inventoryPage;
    private LoginPage loginPage;

    @BeforeEach
    void setup() {
        initialisation();
        loginPage = new LoginPage();
        //TODO: Uncomment - yet to implement
        /*loginPage.setUsername(PropertiesLoader.getProperties().getProperty("Username"));
        loginPage.setPassword(PropertiesLoader.getProperties().getProperty("Password"));
        loginPage.enterUsername();
        loginPage.enterPassword();
        inventoryPage = loginPage.login();
        inventoryPage.clickAddToCardButton();
        cartPage = inventoryPage.clickOnCart();
        csOnePage = cartPage.goToCheckout();*/
    }

    @Nested
    @DisplayName("Getter Tests")
    class GetterTestClass {
        @Test
        @DisplayName("Test if first name is returned.")
        void testFirstNameIsReturned() {
            csOnePage.fillFirstName();
            Assertions.assertEquals(PropertiesLoader.getProperties().getProperty("firstName"), csOnePage.getFirstName().getText());
        }

        @Test
        @DisplayName("Test if last name is returned.")
        void testIfLastNameIsReturned() {
            csOnePage.fillLastName();
            Assertions.assertEquals(PropertiesLoader.getProperties().getProperty("lastName"), csOnePage.getLastName().getText());
        }

        @Test
        @DisplayName("Test if postcode is returned")
        void testIfPostcodeIsReturned() {
            csOnePage.fillPostalCode();
            Assertions.assertEquals(PropertiesLoader.getProperties().getProperty("postcode"), csOnePage.getPostcode().getText());
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
        @DisplayName("Test if First name is entered")
        void testIfFirstNameIsEntered() {
            csOnePage.fillFirstName();
            Assertions.assertEquals(PropertiesLoader.getProperties().getProperty("firstName"), csOnePage.getFirstName());
        }

        @Test
        @DisplayName("Test if Last name is entered")
        void testIfLastNameIsEntered() {
            csOnePage.fillLastName();
            Assertions.assertEquals(PropertiesLoader.getProperties().getProperty("lastName"), csOnePage.getFirstName());
        }

        @Test
        @DisplayName("Test if Post code is entered")
        void testIfPostCodeIsEntered() {
            csOnePage.fillPostalCode();
            Assertions.assertEquals(PropertiesLoader.getProperties().getProperty("postcode"), csOnePage.getFirstName());
        }

        @Test
        @DisplayName("Test if all fields are entered")
        void testIfAllFieldsAreEntered() {
            csOnePage.fillInAllFields();
            Assertions.assertEquals(
                    PropertiesLoader.getProperties().getProperty("firstName")+
                    PropertiesLoader.getProperties().getProperty("firstName")+
                    PropertiesLoader.getProperties().getProperty("firstName"),
                    csOnePage.getFirstName().getText()+
                    csOnePage.getLastName().getText()+
                    csOnePage.getPostcode().getText());
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
            Assertions.assertTrue(csOnePage.isFirstNameEmptyErrorDisplayed());
        }
        @Test
        @DisplayName("testEmptyErrorDisplayedLastName")
        void testEmptyErrorDisplayedLastName() {
            Assertions.assertTrue(csOnePage.isLastNameEmptyErrorDisplayed());
        }
        @Test
        @DisplayName("testEmptyErrorDisplayedZipPostCode")
        void testEmptyErrorDisplayedPostCode() {
            Assertions.assertTrue(csOnePage.isPostalCodeEmptyErrorDisplayed());
        }
        @Test
        @DisplayName("TestEmptyErrorDisplayedAll")
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
            //TODO: Uncomment - yet to implement.
            /*Assertions.assertEquals(
             PropertiesLoader.getProperties().get("UrlCart") ,
             csOnePage.goToCartPage().getUrl());*/
        }

        @Test
        @DisplayName("Test Checkout step two page")
        void testCheckoutStepTwo() {
            //TODO: Uncomment - yet to implement.
            /*Assertions.assertEquals(
             PropertiesLoader.getProperties().get("UrlCheckoutStepTwo") ,
             csOnePage.goToCheckoutStepTwoPage().getUrl());*/
        }
    }

    @AfterEach
    void teardown() {
        webDriver.quit();
    }
}
