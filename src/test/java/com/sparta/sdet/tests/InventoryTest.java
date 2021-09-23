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

    @Test
    @DisplayName("Checks whether inventory items names are listed")
    void testWebElementsAreListed() {
        Assertions.assertEquals(6, inventoryPage.getNumberOfInventoryItems());
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
