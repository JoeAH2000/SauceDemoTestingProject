package com.sparta.sdet.cucumber.cart;

import com.sparta.sdet.pages.CartPage;
import com.sparta.sdet.pages.CheckoutStepOnePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.PageFactory;

import static com.sparta.sdet.base.TestBase.webDriver;

public class CartCheckout {

    private CartPage cartPage;
    private CheckoutStepOnePage checkoutStepOnePage = null;

    @Before
    public void setup() {
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
}
