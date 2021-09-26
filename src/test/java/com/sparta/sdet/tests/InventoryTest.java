package com.sparta.sdet.tests;


import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.InventoryPage;
import com.sparta.sdet.pages.LoginPage;
import org.junit.jupiter.api.*;

import java.util.Collections;
import java.util.List;

public class InventoryTest extends TestBase {
    LoginPage loginPage;
    InventoryPage inventoryPage;

    public InventoryTest(){
        super();
    }

    @BeforeEach
    public void setUp(){
        initialisation();
        loginPage = new LoginPage();
        inventoryPage=new InventoryPage();
    }

//    @Test
//    @DisplayName("Checks whether you can click the Hamburger icon to open it")
//    void testHamburgerIconCanOpen(){
//        loginPage.enterUserName();
//        loginPage.enterPassWord();
//        loginPage.clickLoginBtn();
//        Assertions.
//    }

    @Test
    @DisplayName("Checks whether the About button works")
    void testAboutButton(){
//        loginPage.enterUserName();
//        loginPage.enterPassWord();
//        loginPage.clickLoginBtn();
        inventoryPage.clickHamburgerButton();
        inventoryPage.clickAboutUsButton();
        Assertions.assertEquals("https://saucelabs.com/", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Checks whether inventory items names are listed")
    void testWebElementsAreListed() {
//        loginPage.enterUserName();
//        loginPage.enterPassWord();
//        loginPage.clickLoginBtn();
        Assertions.assertEquals(6, inventoryPage.getNumberOfInventoryItems());
    }

    @Test
    public void VerifyAllItemsNavigation() {
        inventoryPage.clickHamburgerButton();
        inventoryPage.clickAllItems();
        Assertions.assertEquals(webDriver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void VerifyLogoutButtonClick() {
        inventoryPage.clickHamburgerButton();
        inventoryPage.clickLogoutButton();
        Assertions.assertEquals(webDriver.getCurrentUrl(),"https://www.saucedemo.com/");
    }

    //Bug: About Us click takes us to https://saucelabs.com/ instead of about us page    @Test
    public void VerifyAboutButtonClick() {
        inventoryPage.clickHamburgerButton();
        inventoryPage.clickAboutUsButton();
        //expected url is not known to us, but I'm expecting like below url
        Assertions.assertEquals("https://www.saucedemo.com/aboutus.html",webDriver.getCurrentUrl());
    }

    @Test //(expected = NoSuchElementException.class)
    public void VerifyResetAppStateButtonClick() throws InterruptedException {
        inventoryPage.clickAddToCardButton();
        Thread.sleep(3000);
        inventoryPage.clickHamburgerButton();
        inventoryPage.clickResetAppState();
        Thread.sleep(1000);
        Assertions.assertTrue(inventoryPage.isCartEmptyOnResetClick());
    }

    @Test //(expected = NoSuchElementException.class)
    public void VerifySortZtoA() throws InterruptedException {

        List<String> originalProdList = inventoryPage.getProductTitles();
        Collections.sort(originalProdList, Collections.reverseOrder());
        inventoryPage.clickDropDownFilter();
        Thread.sleep(1000);
        inventoryPage.clickZtoA();
        List<String> prodList = inventoryPage.getProductTitles();
        Assertions.assertEquals(prodList,originalProdList);
    }

    @Test //(expected = NoSuchElementException.class)
    public void VerifySortPriceLowToHigh() throws InterruptedException {
        List<Float> originalProdList = inventoryPage.getProductPrice();
        Collections.sort(originalProdList, Collections.reverseOrder());
        inventoryPage.clickDropDownFilter();
        Thread.sleep(1000);
        inventoryPage.clickPriceHighToLow();
        List<Float> prodList = inventoryPage.getProductPrice();
        Assertions.assertEquals(prodList,originalProdList);
    }

    @Test
    public void VerifyHamburgerMenuDisplayAllMenuItems(){
        inventoryPage.clickHamburgerButton();
        try {
            Thread.sleep(2000);
            Assertions.assertTrue(inventoryPage.isDisplayedAllitems());
            Assertions.assertTrue(inventoryPage.isDisplayedAbout());
            Assertions.assertTrue(inventoryPage.isDisplayedLogout());
            Assertions.assertTrue(inventoryPage.isDisplayedbtnResetAppState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
