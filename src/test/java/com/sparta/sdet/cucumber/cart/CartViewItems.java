package com.sparta.sdet.cucumber.cart;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.CartPage;
import com.sparta.sdet.pages.InventoryPage;
import com.sparta.sdet.pages.LoginPage;
import com.sparta.sdet.util.PropertiesLoader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.PageFactory;

import static com.sparta.sdet.base.TestBase.initialisation;
import static com.sparta.sdet.base.TestBase.webDriver;

public class CartViewItems extends TestBase {

    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private String itemName;
    private LoginPage loginPage;


    @Given("I have items in my cart")
    public void iHaveItemsInMyCart() {
        initialisation();
        loginPage = new LoginPage();
        itemName = "Sauce Labs Backpack";
        TestBase.initialisation();
        PageFactory.initElements(webDriver, loginPage);

        loginPage.setUsername(PropertiesLoader.getProperties().getProperty("Username"));
        loginPage.setPassword(PropertiesLoader.getProperties().getProperty("Password"));
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.loginButtonClick();

        inventoryPage = new InventoryPage();
        PageFactory.initElements(webDriver, inventoryPage);
        inventoryPage.clickAddToCardButton();
    }

    @When("I navigate to the cart page from the inventory page")
    public void iNavigateToTheCartPageFromTheInventoryPage() {
        inventoryPage.clickShoppingCart();
        cartPage = new CartPage();
        PageFactory.initElements(webDriver, cartPage);
    }

    @Then("I should see all the items I have ordered in my cart")
    public void iShouldSeeAllTheItemsIHaveOrderedInMyCart() {
        Assertions.assertTrue(cartPage.getAllItems().contains("Sauce Labs Backpack"));
    }

    @Given("I have no items in my cart")
    public void iHaveNoItemsInMyCart() {
        loginPage = new LoginPage();
        itemName = "Sauce Labs Backpack";
        TestBase.initialisation();
        PageFactory.initElements(webDriver, loginPage);

        loginPage.setUsername(PropertiesLoader.getProperties().getProperty("Username"));
        loginPage.setPassword(PropertiesLoader.getProperties().getProperty("Password"));
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.loginButtonClick();

        inventoryPage = new InventoryPage();
        PageFactory.initElements(webDriver, inventoryPage);
    }

    @When("I navigate to the cart page")
    public void iNavigateToTheCartPage() {
        inventoryPage.clickShoppingCart();
        cartPage = new CartPage();
        PageFactory.initElements(webDriver, cartPage);
    }

    @Then("I should see no items in the cart")
    public void iShouldSeeNoItemsInTheCart() {
        Assertions.assertNull(cartPage.getAllItems());
    }
}
