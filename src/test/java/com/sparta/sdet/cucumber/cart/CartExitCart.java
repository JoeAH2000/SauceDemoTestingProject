package com.sparta.sdet.cucumber.cart;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.CartPage;
import com.sparta.sdet.pages.InventoryPage;
import com.sparta.sdet.pages.LoginPage;
import com.sparta.sdet.util.PropertiesLoader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.PageFactory;

public class CartExitCart extends TestBase {

    private CartPage cartPage;
    private LoginPage loginPage;
    private InventoryPage inventoryPage = null;

    @Given("I am viewing the cart")
    public void iAmViewingTheCart() {
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
    }

    @When("I click on the Continue Shopping Page")
    public void iClickOnTheContinueShoppingPage() {
         inventoryPage = cartPage.gotoHomepage();
    }

    @Then("I should be taken to the home page")
    public void iShouldBeTakenToTheHomePage() {
        Assertions.assertNotNull(inventoryPage);
    }

    @After
    public void teardown(){
        webDriver.quit();
    }
}
