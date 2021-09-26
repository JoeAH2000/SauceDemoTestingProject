package com.sparta.sdet.cucumber.cart;

import com.sparta.sdet.base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartRemoveItem extends TestBase {
    @When("I click the remove button for an item")
    public void iClickTheRemoveButtonForAnItem() {
    }

    @Then("That item should be removed from the cart")
    public void thatItemShouldBeRemovedFromTheCart() {
    }

    @After
    public void teardown(){
        webDriver.quit();
    }
}
