package com.sparta.sdet.tests;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.InventoryItemPage;
import com.sparta.sdet.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPageTests extends TestBase {
    private InventoryItemPage itemPage = new InventoryItemPage(webDriver);

    @BeforeEach
    void setup()
    {
        initialisation();
        PageFactory.initElements(webDriver, this);
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.login();
        webDriver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
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

//        @Test
//        @DisplayName("Can if we return to inventory Page")
//        void checkReturnToInventoryPage()
//        {
//            Assertions.assertEquals("https://www.saucedemo.com/inventory.html",itemPage.goToInventory().getUrl);
//        }
    }

    @Nested
    @DisplayName("Check Footer buttons functionality")
    class footerFunctionalityTests{
        @Test
        @DisplayName("Check Facebook button")
        void checkFacebookButton()
        {
            Assertions.assertEquals("https://www.facebook.com/saucelabs",itemPage.testFacebook(webDriver));
        }
        @Test
        @DisplayName("Check Twitter button")
        void checkTwitterButton()
        {
            Assertions.assertEquals("https://twitter.com/saucelabs",itemPage.testTwitter(webDriver));
        }

        @Test
        @DisplayName("Check Linkedin button")
        void checkLinkedinButton()
        {
            Assertions.assertEquals("https://www.linkedin.com/company/sauce-labs/",itemPage.testLinkedin(webDriver));
        }

        @Test
        @Disabled
        @DisplayName("Check Terms button")
        void checkTermsButton()
        {
            Assertions.assertEquals("https://www.saucedemo.com/termsandconditions.html",itemPage.testTermsAndConditions(webDriver));
        }

        @Test
        @Disabled
        @DisplayName("Check Terms button")
        void checkPrivacyButton()
        {
            Assertions.assertEquals("https://www.saucedemo.com/privacypolicy.html",itemPage.testPrivacyPolicy(webDriver));
        }
    }

    @Nested
    @DisplayName("Check Hamburger buttons functionality")
    class hamburgerFunctionalityTests{
        @Test
        @DisplayName("Check Hamburger button")
        void checkHamburgerButtonIsVisible()
        {
            Assertions.assertTrue(itemPage.isHamburgerVisable(webDriver));
        }

        @Test
        @DisplayName("Check all items button")
        void checkAllItemsButton()
        {
            Assertions.assertEquals("https://www.saucedemo.com/inventory.html",itemPage.testAllItems(webDriver));
        }

        @Test
        @DisplayName("Check about button")
        void checkAboutButton()
        {
            Assertions.assertEquals("https://saucelabs.com/",itemPage.testAbout(webDriver));
        }

        @Test
        @DisplayName("Check logout button")
        void checkLogoutButton()
        {
            Assertions.assertEquals("https://www.saucedemo.com/",itemPage.testLogout(webDriver));
        }

        @Test
        @DisplayName("Check if cart is empty")
        void checkIsCartEmpty()
        {
            Assertions.assertTrue(itemPage.isCartEmptyOnReset(webDriver));
        }

        @Test
        @DisplayName("Check if button reset functions properly")
        void checkIsButtonReset()
        {
            Assertions.assertTrue(itemPage.isButtonResetOnReset(webDriver));
        }

        @Test
        @DisplayName("Check cart navigation")
        void checkTestCartNavigation()
        {
            Assertions.assertEquals("https://www.saucedemo.com/cart.html",itemPage.testCartNavigation(webDriver));
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
