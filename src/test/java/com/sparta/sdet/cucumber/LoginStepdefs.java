package com.sparta.sdet.cucumber;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.InventoryPage;
import com.sparta.sdet.pages.LoginPage;
import com.sparta.sdet.util.PropertiesLoader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginStepdefs {

    private LoginPage loginPage;

    @Before
    public void setup() {
        TestBase.initialisation();
        loginPage = new LoginPage();
    }

    @Given("I have a valid username")
    public void iHaveAValidUsername() {
        loginPage.setUsername(
                PropertiesLoader.getProperties().getProperty("Username")
        );
    }

    @And("I have a valid password")
    public void iHaveAValidPassword() {
        loginPage.setPassword(
                PropertiesLoader.getProperties().getProperty("Password")
        );
    }

    @When("I enter my username")
    public void iEnterMyUsername() {
        loginPage.enterUsername();
    }

    @And("I enter my password")
    public void iEnterMyPassword() {
        loginPage.enterPassword();
    }

    @Then("I go to the inventory page from the login page")
    public void iGoToTheInventoryPageFromTheLoginPage() {
        InventoryPage inventoryPage = null;
        inventoryPage = loginPage.login();

        Assertions.assertNotNull(inventoryPage);
    }

    @And("I do not have a valid password")
    public void iDoNotHaveAValidPassword() {
        loginPage.setPassword("invalidPassword");
    }

    @Then("I stay on the login page")
    public void iStayOnTheLoginPage() {
        InventoryPage inventoryPage = null;
        inventoryPage = loginPage.login();
        Assertions.assertNull(inventoryPage);
    }

    @Given("I do not have a valid username")
    public void iDoNotHaveAValidUsername() {
        loginPage.setUsername("InvalidUsername");
    }

    @After
    public void tearDown() {

    }
}
