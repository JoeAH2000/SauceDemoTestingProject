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
    @Then("A dropdown list of links should appear")
    public void aDropdownListOfLinksShouldAppear() {
        Assertions.assertTrue(inventoryPage.isHamburgerVisable(webDriver));
    }



    @Given("I click on the Hamburger menu")
    public void thatTheHamburgerMenuIsClicked() {
        loginPage.enterUserName();
        loginPage.enterPassWord();
        loginPage.clickLoginBtn();

        inventoryPage.clickHamburgerButton();
    }
    @When("I click on the ‘All Items’ link")
    public void iClickOnTheAllItemsLink() {
        inventoryPage.clickAllItems();
    }
    @Then("I should be navigated to the ‘All Items’ page, where I can see all items currently for sale")
    public void iShouldBeNavigatedToTheAllItemsPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", webDriver.getCurrentUrl());
    }


    @And("I click on the Hamburger menu.")
    public void andIClickOnTheHamburgerMenu() {
        inventoryPage.clickHamburgerButton();
    }
    @When("I click on the ‘About’ link")
    public void iClickOnTheAboutLink() {
        inventoryPage.clickAboutUsButton();
    }
    @Then("The ‘About’ page should open")
    public void theAboutPageShouldOpen() {
        Assertions.assertEquals("https://saucelabs.com/", webDriver.getCurrentUrl());
    }


    @Given("The user is logged in")
    public void theUserIsLoggedIn() {
        loginPage.enterUserName();
        loginPage.enterPassWord();
        loginPage.clickLoginBtn();
    }
    @When("The logout link is clicked")
    public void theLogoutLinkIsClicked() {
        inventoryPage.clickHamburgerButton();
        inventoryPage.clickLogoutButton();
    }
    @Then("The user should get logged out")
    public void theUserShouldGetLoggedOut() {
        Assertions.assertEquals("https://www.saucedemo.com/", webDriver.getCurrentUrl());
    }

    @When("I click on the name of a product")
    public void iClickOnTheNameOfAProduct(){
        inventoryPage.clickProductText();
    }
    @Then("I should be navigated to a new page that has more information for that product")
    public void iShouldNavigateToInventoryItems(){
        Assertions.assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", webDriver.getCurrentUrl());
    }

    @When("I click on the image for a product")
    public void iClickOnTheImageOfAProduct(){
        inventoryPage.clickProductImage();
    }


    @When("The facebook link is pressed")
    public void theFacebookLinkIsPressed(){
        inventoryPage.testFacebook(webDriver);
    }
    @Then("I should navigate to the Facebook page")
    public void iShouldNavigateToTheFacebookPage(){
        Assertions.assertEquals("https://www.facebook.com/saucelabs", webDriver.getCurrentUrl());
    }


    @When("The twitter link is pressed")
    public void theTwitterLinkIsPressed(){
        inventoryPage.testTwitter(webDriver);
    }
    @Then("I should navigate to the Twitter page")
    public void iShouldNavigateToTheTwitterPage(){
        Assertions.assertEquals("https://twitter.com/saucelabs", webDriver.getCurrentUrl());
    }



    @When("The linkedin link is pressed")
    public void theLinkedInLinkIsPressed(){
        inventoryPage.testLinkedin(webDriver);
    }
    @Then("I should navigate to the LinkedIn page")
    public void iShouldNavigateToTheLinkedInPage(){
        Assertions.assertEquals("https://www.linkedin.com/company/sauce-labs/", webDriver.getCurrentUrl());
    }
}
