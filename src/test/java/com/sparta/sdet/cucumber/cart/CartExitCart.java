package com.sparta.sdet.cucumber.cart;

import com.sparta.sdet.pages.CartPage;
import com.sparta.sdet.pages.InventoryPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.PageFactory;

import static com.sparta.sdet.base.TestBase.webDriver;

public class CartExitCart {

    private CartPage cartPage;
    private InventoryPage inventoryPage = null;

    @Before
    public void setup() {
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
}
