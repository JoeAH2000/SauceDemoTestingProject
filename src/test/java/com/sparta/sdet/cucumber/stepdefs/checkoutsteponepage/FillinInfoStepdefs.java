package com.sparta.sdet.cucumber.stepdefs.checkoutsteponepage;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.CartPage;
import com.sparta.sdet.pages.CheckoutStepOnePage;
import com.sparta.sdet.pages.CheckoutStepTwoPage;
import com.sparta.sdet.pages.LoginPage;
import com.sparta.sdet.pages.InventoryPage;
import com.sparta.sdet.util.PropertiesLoader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class FillinInfoStepdefs extends TestBase {
    private CheckoutStepOnePage csOnePage;
    private CheckoutStepTwoPage csTwoPage;
    private CartPage cartPage;
    private InventoryPage inventoryPage;
    private LoginPage loginPage;

    @Given("I am on the customer information page")
    public void iAmOnTheCustomerInformationPage() {
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

        csOnePage = cartPage.goToCheckout();
        PageFactory.initElements(webDriver, csOnePage);
    }

    @When("I fill in the first name, last name and postcode fields")
    public void iFillInTheFirstNameLastNameAndPostcodeFields() {
        csOnePage.fillInAllFields();
    }

//    @When("I click on Continue button")
    @And("I click on Continue button")
    public void iClickOnContinueButton() {
        csTwoPage = csOnePage.goToCheckoutStepTwoPage();
    }

    @Then("I should be directed to the overview page")
    public void iShouldBeDirectedToTheCheckoutStepTwoPage() {
        String checkoutStepTwoPageUrl = "https://www.saucedemo.com/checkout-step-two.html";
        Assertions.assertEquals(checkoutStepTwoPageUrl, csTwoPage.getUrl());
    }

    @When("I click on Cancel button")
    public void iClickOnCancelButton() {
        cartPage = csOnePage.goToCartPage();
    }

    @Then("I should be directed to the cart page")
    public void iShouldBeDirectedToTheCartPage() {
        String cartPageUrl = "https://www.saucedemo.com/cart.html";
        Assertions.assertEquals(cartPageUrl, cartPage.getUrl());
    }

    @When("I fill in the last name field and the post code field")
    public void iFillInTheLastNameFieldAndThePostCodeField() {
        csOnePage.fillLastName();
        csOnePage.fillPostalCode();
    }

    @Then("I should get an error message “Error: First Name is required”")
    public void iShouldGetAnErrorMessageErrorFirstNameIsRequired() {
        Assertions.assertTrue(csOnePage.isFirstNameEmptyErrorDisplayed());
    }

    @When("I fill in the first name field and the post code field")
    public void iFillInTheFirstNameFieldAndThePostCodeField() {
        csOnePage.fillFirstName();
        csOnePage.fillPostalCode();
    }

    @Then("I should get an error message “Error: Last Name is required”")
    public void iShouldGetAnErrorMessageErrorLastNameIsRequired() {
        Assertions.assertTrue(csOnePage.isLastNameEmptyErrorDisplayed());
    }


    @When("I fill in the first name field and the last name field")
    public void iFillInTheFirstNameFieldAndTheLastNameField() {
        csOnePage.fillFirstName();
        csOnePage.fillLastName();
    }

    @Then("I should get an error message “Error: Postal Code is required”")
    public void iShouldGetAnErrorMessageErrorPostalCodeIsRequired() {
        Assertions.assertTrue(csOnePage.isPostalCodeEmptyErrorDisplayed());
    }

    @Then("I should get a list of error messages for each field")
    public void iShouldGetAListOfErrorMessagesForEachField() {
        Assertions.assertTrue(csOnePage.areAllEmptyFieldsErrorDisplayed());
    }

    @After
    public void teardown(){
        webDriver.quit();
    }
}
