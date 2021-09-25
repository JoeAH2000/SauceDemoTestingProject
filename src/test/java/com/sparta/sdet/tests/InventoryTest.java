package com.sparta.sdet.tests;


import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.InventoryPage;
import com.sparta.sdet.pages.LoginPage;
import org.junit.jupiter.api.*;

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

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
