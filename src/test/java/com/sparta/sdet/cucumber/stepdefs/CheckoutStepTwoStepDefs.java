package com.sparta.sdet.cucumber.stepdefs;

import com.sparta.sdet.pages.CheckoutStepTwoPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.sparta.sdet.base.TestBase.webDriver;

public class CheckoutStepTwoStepDefs {
    private CheckoutStepTwoPage checkoutStepTwoPage;

    @Before
    void setup() {
        checkoutStepTwoPage = new CheckoutStepTwoPage();
    }

    @Given("I am on the Checkout-Step-Two page")
    public void iAmOnTheCheckoutStepTwoPage() {
        //CODE TO GET TO THE CHECKOUT STEP 2 PAGE
    }

    @When("I click the FINISH button")
    public void iClickTheFINISHButton() {
        checkoutStepTwoPage.finaliseCheckout();
    }

    @Then("I should be on the Checkout-Complete page")
    public void iShouldBeOnTheCheckoutCompletePage() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-complete.html", webDriver.getCurrentUrl());
    }

    @When("I click the CANCEL button")
    public void iClickTheCANCELButton() {
        checkoutStepTwoPage.cancelCheckout();
    }

    @Then("I should be on the Inventory page")
    public void iShouldBeOnTheInventoryPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", webDriver.getCurrentUrl());
    }
}
