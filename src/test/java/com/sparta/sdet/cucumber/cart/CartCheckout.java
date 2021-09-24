package com.sparta.sdet.cucumber.cart;

import com.sparta.sdet.pages.CartPage;
import com.sparta.sdet.pages.CheckoutStepOnePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CartCheckout {

    private CartPage cartPage;
    private CheckoutStepOnePage checkoutStepOnePage = null;

    @Before
    public void setup() {
        cartPage = new CartPage();
    }

    @When("I click the checkout button")
    public void iClickTheCheckoutButton() {

        checkoutStepOnePage = cartPage.goToCheckout();

    }

    @Then("I should be taken to the checkout step one page")
    public void iShouldBeTakenToTheCheckoutStepOnePage() {
        Assertions.assertNotNull(checkoutStepOnePage);
    }
}
