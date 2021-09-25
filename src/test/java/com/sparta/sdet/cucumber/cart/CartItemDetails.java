package com.sparta.sdet.cucumber.cart;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.CartPage;
import com.sparta.sdet.pages.InventoryPage;
import com.sparta.sdet.pages.LoginPage;
import com.sparta.sdet.util.PropertiesLoader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class CartItemDetails extends TestBase {

    private CartPage cartPage;
    private InventoryPage inventoryPage;
    private LoginPage loginPage;


    @Before
    public void setup() {
//        cartPage = new CartPage();
    }

    @Given("I am viewing my cart")
    public void iAmViewingMyCart() {
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

    @When("I look at an item")
    public void iLookAtAnItem() {
        // Human looks at item
    }

    @Then("I should see the quantity of the item")
    public void iShouldSeeTheQuantityOfTheItem() {
        Assertions.assertEquals(1, cartPage.getItemQuantity(By.className("inventory_item_name").toString()));
    }

    @Then("I should see the name of the item")
    public void iShouldSeeTheNameOfTheItem() {
    }

    @Then("I should see the item description")
    public void iShouldSeeTheItemDescription() {
    }
}
