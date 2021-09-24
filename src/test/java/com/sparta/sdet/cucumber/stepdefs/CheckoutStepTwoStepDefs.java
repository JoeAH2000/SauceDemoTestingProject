package com.sparta.sdet.cucumber.stepdefs;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.*;
import com.sparta.sdet.util.PropertiesLoader;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.PageFactory;

import static com.sparta.sdet.base.TestBase.webDriver;

public class CheckoutStepTwoStepDefs {
    private CheckoutStepTwoPage checkoutStepTwoPage;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutStepOnePage checkoutStepOnePage;

    private double subTotal;
    private double tax;
    private double total;

    private String itemName;
    private double itemPrice;
    private String itemDesc;
    private int itemQuantity;

    private String paymentInfo;
    private String shippingInfo;
    @Before
    public void setup() {
        checkoutStepTwoPage = new CheckoutStepTwoPage();
        TestBase.initialisation();
    }

    @Given("I am on the Checkout-Step-Two page")
    public void iAmOnTheCheckoutStepTwoPage() {
        loginPage = new LoginPage();

        loginPage.setUsername(PropertiesLoader.getProperties().getProperty("Username"));
        loginPage.setPassword(PropertiesLoader.getProperties().getProperty("Password"));
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.loginButtonClick();

        inventoryPage = new InventoryPage();
        inventoryPage.clickAddToCardButton();
        inventoryPage.clickShoppingCart();

        cartPage = new CartPage();

        PageFactory.initElements(webDriver, cartPage);
        checkoutStepOnePage = cartPage.goToCheckout();
        PageFactory.initElements(webDriver, checkoutStepOnePage);
        checkoutStepOnePage.fillInAllFields();
        checkoutStepOnePage.goToCheckoutStepTwoPage();
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

    @When("I check the sub total value")
    public void iCheckTheSubTotalValue() {
        subTotal = checkoutStepTwoPage.getItemTotal();
    }

    @Then("The subtotal should be as expected")
    public void theSubtotalShouldBeAsExpected() {
        Assertions.assertEquals(29.99, subTotal);
    }

    @When("I check the tax value")
    public void iCheckTheTaxValue() {
        tax = checkoutStepTwoPage.getTax();
    }

    @Then("The tax should be as expected")
    public void theTaxShouldBeAsExpected() {
        Assertions.assertEquals(2.40, tax);
    }

    @When("I check the total value")
    public void iCheckTheTotalValue() {
        total = checkoutStepTwoPage.getTotal();
    }

    @Then("The total should be as expected")
    public void theTotalShouldBeAsExpected() {
        Assertions.assertEquals(32.39, total);
    }

    @When("I check the payment information")
    public void iCheckThePaymentInformation() {
        paymentInfo = checkoutStepTwoPage.getPaymentInformation();
    }

    @Then("The payment information should be as expected")
    public void thePaymentInformationShouldBeAsExpected() {
        Assertions.assertEquals("SauceCard #31337", paymentInfo);
    }

    @When("I check the shipping information")
    public void iCheckTheShippingInformation() {
        shippingInfo = checkoutStepTwoPage.getShippingInformation();
    }

    @Then("The shipping information should be as expected")
    public void theShippingInformationShouldBeAsExpected() {
        Assertions.assertEquals("FREE PONY EXPRESS DELIVERY!", shippingInfo);
    }

    @When("I check the item price")
    public void iCheckTheItemPrice() {
        itemPrice = checkoutStepTwoPage.getItemPrice(itemName);
    }

    @Then("The price should be as expected")
    public void thePriceShouldBeAsExpected() {
        Assertions.assertEquals(29.99, itemPrice);
    }

    @When("I check the item description")
    public void iCheckTheItemDescription() {
        itemDesc = checkoutStepTwoPage.getItemDescription(itemName);
    }

    @Then("The description should be as expected")
    public void theDescriptionShouldBeAsExpected() {
        Assertions.assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", itemDesc);
    }

    @When("I check the item quantity")
    public void iCheckTheItemQuantity() {
        itemQuantity = checkoutStepTwoPage.getItemQuantity(itemName);
    }

    @Then("The quantity should be as expected")
    public void theQuantityShouldBeAsExpected() {
        Assertions.assertEquals(1, itemQuantity);
    }
}
