package com.sparta.sdet.cucumber;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.InventoryItemPage;
import com.sparta.sdet.pages.InventoryPage;
import com.sparta.sdet.pages.LoginPage;
import com.sparta.sdet.util.PropertiesLoader;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MyInventoryItemDefs extends TestBase {

    private InventoryItemPage itemPage;
    private String cartPageLink;
    private boolean cartIncreased;
    private boolean cartDecreased;
    private String twitterLinkUrl;
    private String facebookLinkUrl;
    private String linkedInLinkUrl;
    private InventoryPage page;

    @Given("I am on a specific product page")
    public void iAmOnASpecificProductPage() {
        initialisation();
        PageFactory.initElements(webDriver, this);
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername(PropertiesLoader.getProperties().getProperty("Username"));
        loginPage.setPassword(PropertiesLoader.getProperties().getProperty("Password"));
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.login();
        webDriver.findElement(By.id("item_4_title_link")).click();
        itemPage = new InventoryItemPage(webDriver);
    }

    @Then("I can see the specific product's title")
    public void iCanSeeTheSpecificProductSTitle() {
        Assertions.assertNotNull(itemPage.getItemTitle());
    }

    @And("I can see the specific product's description")
    public void iCanSeeTheSpecificProductSDescription() {
        Assertions.assertNotNull(itemPage.getItemDescription());
    }

    @And("I can see the specific product's price")
    public void iCanSeeTheSpecificProductSPrice() {
        Assertions.assertNotNull(itemPage.getItemCost());
    }

    @And("I can see the specific product's image")
    public void iCanSeeTheSpecificProductSImage() {
        Assertions.assertNotNull(itemPage.getItemImage());
    }

    @When("I click on the cart icon from the specific product Page")
    public void iClickOnTheCartIconFromTheSpecificProductPage() {
        cartPageLink = itemPage.testCartNavigation(webDriver);
    }

    @Then("I leave the specific product page and end on the cart checkout page")
    public void iLeaveTheSpecificProductPageAndEndOnTheCartCheckoutPage() {
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", cartPageLink);
    }

    @When("I click the Add Product Button on the specific product page")
    public void iClickTheAddProductButtonOnTheSpecificProductPage() {
        cartIncreased = itemPage.canAddProductToCart();
    }

    @Then("I see the cart logo on the specific product page increase by one")
    public void iSeeTheCartLogoOnTheSpecificProductPageIncreaseByOne() {
        Assertions.assertTrue(cartIncreased);
    }

    @When("I click the Remove Product Button on the specific product page")
    public void iClickTheRemoveProductButtonOnTheSpecificProductPage() {
        cartDecreased = itemPage.canRemoveProductFromCart();
    }

    @Then("I see the cart logo on the specific product page decrease by one")
    public void iSeeTheCartLogoOnTheSpecificProductPageDecreaseByOne() {
        Assertions.assertTrue(cartDecreased);
    }

    @When("I click the Back To Products button on the specific product page")
    public void iClickTheBackToProductsButtonOnTheSpecificProductPage() {
        page = itemPage.goToInventory();
    }

    @Then("I leave the specific product page and I end on the inventory page")
    public void iLeaveTheSpecificProductPageAndIEndOnTheInventoryPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", page.getUrl());
    }

    @When("I click the Twitter Logo on the specific item page")
    public void iClickTheTwitterLogoOnTheSpecificItemPage() {
        twitterLinkUrl = itemPage.testTwitter(webDriver);
    }

    @Then("A new tab opens next to the specific item page with the Twitter page")
    public void aNewTabOpensNextToTheSpecificItemPageWithTheTwitterPage() {
        Assertions.assertEquals("https://twitter.com/saucelabs", twitterLinkUrl);
    }

    @When("I click the Facebook Logo on the specific item page")
    public void iClickTheFacebookLogoOnTheSpecificItemPage() {
        facebookLinkUrl = itemPage.testFacebook(webDriver);
    }

    @Then("A new tab opens next to the specific item page with the Facebook Page")
    public void aNewTabOpensNextToTheSpecificItemPageWithTheFacebookPage() {
        Assertions.assertEquals("https://www.facebook.com/saucelabs", facebookLinkUrl);
    }

    @When("I click the LinkedIn Logo on the specific item page")
    public void iClickTheLinkedInLogoOnTheSpecificItemPage() {
        linkedInLinkUrl = itemPage.testLinkedin(webDriver);
    }

    @Then("A new tab opens next to the specific item page with the LinkedIn Page")
    public void aNewTabOpensNextToTheSpecificItemPageWithTheLinkedInPage() {
        Assertions.assertTrue(linkedInLinkUrl.startsWith("https://www.linkedin.com/"));
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
