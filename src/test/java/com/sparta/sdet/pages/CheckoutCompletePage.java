package com.sparta.sdet.pages;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.util.Footerable;
import com.sparta.sdet.util.Hamburgerable;
import com.sparta.sdet.util.Headerable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutCompletePage extends TestBase implements Headerable, Footerable, Hamburgerable {

    private @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartLinkButton;
    private @FindBy(className = "social_facebook")
    WebElement facebookButton;
    private @FindBy(className = "social_twitter")
    WebElement twitterButton;
    private @FindBy(className = "social_linkedin")
    WebElement linkedInButton;
    private @FindBy(className = "footer_copy")
    WebElement termsAndConditions;
    private @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenu;
    private @FindBy(id = "inventory_sidebar_link")
    WebElement allItemsLink;
    private @FindBy(id = "about_sidebar_link")
    WebElement aboutLink;
    private @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;
    private @FindBy(id = "reset_sidebar_link")
    WebElement restLink;
    private @FindBy(id = "back-to-products")
    WebElement backHomeButton;

    @Override
    public String testCartNavigation() {
        shoppingCartLinkButton.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testFacebook() {
        facebookButton.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testTwitter() {
        twitterButton.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testLinkedin() {
        linkedInButton.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testTermsAndConditions() {
        return termsAndConditions.getText();
    }

    @Override
    public String testPrivacyPolicy() {
        return termsAndConditions.getText();
    }

    @Override
    public boolean isHamburgerVisable() {
        return burgerMenu.isDisplayed();
    }

    @Override
    public String testAllItems() {
        allItemsLink.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testAbout() {
        aboutLink.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testLogout() {
        logoutLink.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public boolean isCartEmptyOnReset() {
        restLink.click();

        shoppingCartLinkButton.click();
        List<WebElement> cartItems = webDriver.findElement(By.id("cart_contents_container"))
                .findElement(By.className("cart_list"))
                .findElements(By.className("cart_item"));

        return cartItems.isEmpty();
    }

    @Override
    public boolean isButtonResetOnReset() {
        backHomeButton.click();
        List<WebElement> buttons = webDriver.findElements(By.className("btn btn_primary btn_small btn_inventory"));

        for (WebElement button:buttons) {
            if (button.getText().toLowerCase().contains("remove"))
                return false;
        }
        return true;
    }

    public InventoryPage returnToHomepage() {
        backHomeButton.click();
        return new InventoryPage();
    }
}
