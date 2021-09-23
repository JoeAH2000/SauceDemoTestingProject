package com.sparta.sdet.cucumber.stepdefs.checkoutsteponepage;

import com.sparta.sdet.pages.CartPage;
import com.sparta.sdet.pages.CheckoutStepOnePage;
import com.sparta.sdet.pages.CheckoutStepTwoPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FillinInfoStepdefs {
    private static WebDriver webDriver;
    private CheckoutStepOnePage csOnePage;
    private CheckoutStepTwoPage csTwoPage;
    private CartPage cartPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Given("I am on the customer information page")
    public void iAmOnTheCustomerInformationPage() {
        csOnePage = new CheckoutStepOnePage(webDriver);
    }

    @When("I fill in the first name, last name and postcode fields")
    public void iFillInTheFirstNameLastNameAndPostcodeFields() {
        csOnePage.fillInAllFields();
    }

    @When("I click on Continue button")
    @And("I click on Continue button")
    public void iClickOnContinueButton() {
        csOnePage.clickContinue();
    }

    @Then("I should be directed to the overview page")
    public void iShouldBeDirectedToTheCheckoutStepTwoPage() {
        String checkoutStepTwoPageUrl = "https://www.saucedemo.com/checkout-step-two.html";
        /*csTwoPage = new CheckoutStepTwoPage(webDriver);
        Assertions.assertEquals(checkoutStepTwoPageUrl, csTwoPage.getUrl());*/
    }

    @When("I click on Cancel button")
    public void iClickOnCancelButton() {
        csOnePage.clickCancel();
    }

    @Then("I should be directed to the cart page")
    public void iShouldBeDirectedToTheCartPage() {
        String cartPageUrl = "https://www.saucedemo.com/cart.html";
        /*cartPage = new CartPage(webDriver);
        Assertions.assertEquals(cartPageUrl, cartPage.getUrl());*/
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
