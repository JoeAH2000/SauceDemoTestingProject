package com.sparta.sdet.tests;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.InventoryItemPage;
import com.sparta.sdet.pages.LoginPage;
import com.sparta.sdet.util.PropertiesLoader;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPageTests extends TestBase {
    private InventoryItemPage itemPage = new InventoryItemPage(webDriver);

    @BeforeEach
    void setup()
    {
        initialisation();
        PageFactory.initElements(webDriver, this);
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername(PropertiesLoader.getProperties().getProperty("Username"));
        loginPage.setPassword(PropertiesLoader.getProperties().getProperty("Password"));
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.login();
        webDriver.findElement(By.id("item_4_title_link")).click();
    }

    @Nested
    @DisplayName("Checking product details exist")
    class productDetailsExist {
        @Test
        @DisplayName("Check item title exists")
        void checkItemTitleExists() {
            Assertions.assertNotNull(itemPage.getItemTitle());
        }

        @Test
        @DisplayName("Check item Description exists")
        void checkItemDescExists() {
            Assertions.assertNotNull(itemPage.getItemDescription());
        }

        @Test
        @DisplayName("Check item price exists")
        void checkItemPriceExists() {
            Assertions.assertNotNull(itemPage.getItemCost());
        }

        @Test
        @DisplayName("Check item image exists")
        void checkItemImageExists() {
            Assertions.assertNotNull(itemPage.getItemImage());
        }
    }

    @Nested
    @DisplayName("Checking if the product buttons have correct functionality")
    class productButtonFunctionality {
        @Test
        @DisplayName("Checking if product can be added to cart")
        void checkForAddButton(){
            Assertions.assertTrue(itemPage.addProductButtonExists());
        }

        @Test
        @DisplayName("Checking the remove button is not there")
        void checkForRemoveButton(){
            Assertions.assertFalse(itemPage.removeProductButtonExists());
        }

        @Test
        @DisplayName("Can add product to the cart")
        void checkAddToCart()
        {
           Assertions.assertTrue(itemPage.canAddProductToCart());
        }

        @Test
        @DisplayName("Can remove product to the cart")
        void checkRemoveFromCart()
        {
            Assertions.assertTrue(itemPage.canRemoveProductFromCart());
        }

        @Test
        @DisplayName("Can we return to inventory Page")
        void checkReturnToInventoryPage()
        {
            Assertions.assertEquals("https://www.saucedemo.com/inventory.html",itemPage.goToInventory().getUrl());
        }
    }

    @Nested
    @DisplayName("Check Footer buttons functionality")
    class footerFunctionalityTests{

        @Test
        @DisplayName("Check Facebook button")
        void checkFacebookButton()
        {
            Assertions.assertEquals("https://www.facebook.com/saucelabs",itemPage.testFacebook());
        }
        @Test
        @DisplayName("Check Twitter button")
        void checkTwitterButton()
        {
            Assertions.assertEquals("https://twitter.com/saucelabs",itemPage.testTwitter());
        }

        @Test
        @DisplayName("Check Linkedin button")
        void checkLinkedinButton()
        {
            Assert.assertTrue(itemPage.testLinkedin().startsWith("https://www.linkedin.com/"));
        }

        @Test
        @Disabled("Terms and Conditions link not yet implemented. Development Team to fix.")
        @DisplayName("Check Terms button")
        void checkTermsButton()
        {
            Assertions.assertEquals("https://www.saucedemo.com/termsandconditions.html",itemPage.testTermsAndConditions());
        }

        @Test
        @Disabled("Privacy Policy link not yet implemented. Development Team to fix.")
        @DisplayName("Check Terms button")
        void checkPrivacyButton()
        {
            Assertions.assertEquals("https://www.saucedemo.com/privacypolicy.html",itemPage.testPrivacyPolicy());
        }
    }

    @Nested
    @DisplayName("Check Hamburger buttons functionality")
    class hamburgerFunctionalityTests{
        @Test
        @DisplayName("Check Hamburger button")
        void checkHamburgerButtonIsVisible()
        {
            Assertions.assertTrue(itemPage.isHamburgerVisable());
        }

        @Test
        @DisplayName("Check all items button")
        void checkAllItemsButton()
        {
            Assertions.assertEquals("https://www.saucedemo.com/inventory.html",itemPage.testAllItems());
        }

        @Test
        @DisplayName("Check about button")
        void checkAboutButton()
        {
            Assertions.assertEquals("https://saucelabs.com/",itemPage.testAbout());
        }

        @Test
        @DisplayName("Check logout button")
        void checkLogoutButton()
        {
            Assertions.assertEquals("https://www.saucedemo.com/",itemPage.testLogout());
        }

        @Test
        @DisplayName("Check if cart is empty")
        void checkIsCartEmpty()
        {
            Assertions.assertTrue(itemPage.isCartEmptyOnReset());
        }

        @Test
        @Disabled("Button does not revert to 'Add Product'. Development Team to fix.")
        @DisplayName("Check if button reset functions properly")
        void checkIsButtonReset()
        {
            Assertions.assertTrue(itemPage.isButtonResetOnReset());
        }

        @Test
        @DisplayName("Check cart navigation")
        void checkTestCartNavigation()
        {
            Assertions.assertEquals("https://www.saucedemo.com/cart.html",itemPage.testCartNavigation());
        }
    }

    @AfterEach
    @DisplayName("teardown each")
    void teardownEach(){
        webDriver.close();
    }

    @AfterAll
    @DisplayName("teardown all")
    static void teardownAll(){
        webDriver.quit();
    }


}
