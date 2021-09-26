package com.sparta.sdet.cucumber.cart;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.CartPage;
import com.sparta.sdet.pages.CheckoutStepOnePage;
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

public class CartCheckout extends TestBase {

    private CartPage cartPage;
    private CheckoutStepOnePage checkoutStepOnePage = null;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Given("I am on the cart page")
    public void iAmOnTheCartPage() {
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

    @When("I click the checkout button")
    public void iClickTheCheckoutButton() {
        checkoutStepOnePage = cartPage.goToCheckout();
    }

    @Then("I should be taken to the checkout step one page")
    public void iShouldBeTakenToTheCheckoutStepOnePage() {
        Assertions.assertNotNull(checkoutStepOnePage);
    }

    @After
    public void teardown(){
        webDriver.quit();
    }
}

