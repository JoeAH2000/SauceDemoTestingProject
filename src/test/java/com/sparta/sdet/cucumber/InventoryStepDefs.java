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
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class InventoryStepDefs extends TestBase {
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Before
    public void setup(){
        initialisation();
        loginPage = new LoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername(PropertiesLoader.getProperties().getProperty("Username"));
        loginPage.enterUsername();
        loginPage.setPassword(PropertiesLoader.getProperties().getProperty("Password"));

        loginPage.enterPassword();
        loginPage.login();
        inventoryPage=new InventoryPage();
    }


    @Given("I am on the All items page")
    public void iAmOnTheAllItemsPage() {

    }
    @When("I click on the Hamburger menu")
    public void iClickOnTheHamburgerMenu() {
        inventoryPage.clickHamburgerButton();
    }
    @Then("A dropdown list of links should appear")
    public void aDropdownListOfLinksShouldAppear() {
        Assertions.assertTrue(inventoryPage.isHamburgerVisable());
    }



//    @Given("I click on the Hamburger menu")
//    public void thatTheHamburgerMenuIsClicked() {
//        loginPage.enterUserName();
//        loginPage.enterPassWord();
//        loginPage.clickLoginBtn();
//
//        inventoryPage.clickHamburgerButton();
//    }
    @When("I click on the ‘All Items’ link")
    public void iClickOnTheAllItemsLink() {
        inventoryPage.clickHamburgerButton();
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


//    @Given("The user is logged in")
//    public void theUserIsLoggedIn() {
//        loginPage.enterUserName();
//        loginPage.enterPassWord();
//        loginPage.clickLoginBtn();
//    }
    @When("The logout link is clicked")
    public void theLogoutLinkIsClicked() {
        inventoryPage.clickHamburgerButton();
        inventoryPage.clickLogoutButton();
    }
    @Then("The user should get logged out")
    public void theUserShouldGetLoggedOut() {
        Assertions.assertEquals("https://www.saucedemo.com/", webDriver.getCurrentUrl());
    }

    @Given("That I have items in the checkout basket")
    public void iHaveItemsInCheckoutBasket(){
//        loginPage.enterUserName();
//        loginPage.enterPassWord();
//        loginPage.clickLoginBtn();
        inventoryPage.clickAddToCardButton();
    }
    @When("I click on the ‘Reset App State’ link")
    public void iClickResetAppState(){
        inventoryPage.clickHamburgerButton();
        inventoryPage.clickResetAppState();
    }
    @Then("Those items should be removed from the basket")
    public void itemsShouldBeRemovedFromBasket(){
        Assertions.assertFalse(inventoryPage.isShoppingCartPopulated());
    }
    @Then("The state of the button should be reset")
    public void theButtonShouldBeReset(){
        Assertions.assertTrue(inventoryPage.isRemovedButtonReset());
    }

    @When("I click on the checkout cart link")
    public void iClickOnTheCheckoutCart(){
        inventoryPage.clickShoppingCart();
    }
    @Then("I should navigate to the checkout page")
    public void iShouldNavigateToTheCheckoutPage(){
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", webDriver.getCurrentUrl());
    }


    @When("I have added an item to the cart")
    public void iHaveAddedAnItemToTheCart(){
        inventoryPage.clickAddToCardButton();
    }
    @Then("The number of items in the cart should match the number of items added")
    public void theCartShouldMatchNumberOfItemsAdded(){
        Assertions.assertEquals(1, inventoryPage.getNumberOfProductsInCart());
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
        inventoryPage.testFacebook();
    }
    @Then("I should navigate to the Facebook page")
    public void iShouldNavigateToTheFacebookPage(){
        Assertions.assertEquals("https://www.facebook.com/saucelabs", webDriver.getCurrentUrl());
    }


    @When("The twitter link is pressed")
    public void theTwitterLinkIsPressed(){
        inventoryPage.testTwitter();
    }
    @Then("I should navigate to the Twitter page")
    public void iShouldNavigateToTheTwitterPage(){
        Assertions.assertEquals("https://twitter.com/saucelabs", webDriver.getCurrentUrl());
    }



    @When("The linkedin link is pressed")
    public void theLinkedInLinkIsPressed(){
        inventoryPage.testLinkedin();
    }
    @Then("I should navigate to the LinkedIn page")
    public void iShouldNavigateToTheLinkedInPage(){
        Assertions.assertEquals("https://www.linkedin.com/company/sauce-labs/", webDriver.getCurrentUrl());
    }

    @After
    void teardown(){
        webDriver.quit();
    }


}
