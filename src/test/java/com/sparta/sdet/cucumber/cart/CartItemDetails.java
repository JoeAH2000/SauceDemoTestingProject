package com.sparta.sdet.cucumber.cart;

import com.sparta.sdet.pages.CartPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartItemDetails {

    private CartPage cartPage;

    @Before
    public void setup() {
        cartPage = new CartPage();
    }

    @Given("I am viewing my cart")
    public void iAmViewingMyCart() {

    }

    @When("I look at an item")
    public void iLookAtAnItem() {
    }

    @Then("I should see the quantity of the item")
    public void iShouldSeeTheQuantityOfTheItem() {
    }

    @Then("I should see the name of the item")
    public void iShouldSeeTheNameOfTheItem() {
    }

    @Then("I should see the item description")
    public void iShouldSeeTheItemDescription() {
    }
}
