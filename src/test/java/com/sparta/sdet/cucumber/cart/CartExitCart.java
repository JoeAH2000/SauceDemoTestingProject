package com.sparta.sdet.cucumber.cart;

import com.sparta.sdet.pages.CartPage;
import com.sparta.sdet.pages.InventoryPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CartExitCart {

    CartPage cartPage;
    InventoryPage inventoryPage = null;

    @Before
    public void setup() {
        cartPage = new CartPage();
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
