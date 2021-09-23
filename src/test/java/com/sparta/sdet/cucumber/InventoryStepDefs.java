package com.sparta.sdet.cucumber;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.InventoryPage;
import com.sparta.sdet.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;

public class InventoryStepDefs extends TestBase {
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Before
    public void setup(){
        initialisation();
        loginPage = new LoginPage();
        inventoryPage=new InventoryPage();
    }

    @Given("I am on the All items page")
    public void iAmOnTheAllItemsPage() {
        loginPage.enterUserName();
        loginPage.enterPassWord();
        loginPage.clickLoginBtn();
    }

    @When("I click on the Hamburger menu")
    public void iClickOnTheHamburgerMenu() {
        inventoryPage.clickHamburgerButton();
    }

//    @Then("A dropdown list of links should appear")
//    public void aDropdownListOfLinksShouldAppear() {
//        Assertions.assertTrue();
//    }

    @Given("That the ‘All Items’ link appears after clicking on the Hamburger menu.")
    public void thatTheAllItemsLinkAppearsAfterClickingOnTheHamburgerMenu() {
    }

    @When("I click on the ‘All Items’ link.")
    public void iClickOnTheAllItemsLink() {
    }

    @Then("I should be navigated to the ‘All Items’ page, where I can see all items currently for sale.")
    public void iShouldBeNavigatedToTheAllItemsPageWhereICanSeeAllItemsCurrentlyForSale() {
    }

    @And("I click on the Hamburger menu.")
    public void iClickOnTheHamburgerMenu() {
    }

    @When("I click on the ‘About’ link.")
    public void iClickOnTheAboutLink() {
    }

    @Then("The ‘About’ page should open.")
    public void theAboutPageShouldOpen() {
    }
}
