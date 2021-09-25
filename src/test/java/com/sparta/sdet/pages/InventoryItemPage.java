package com.sparta.sdet.pages;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.util.Footerable;
import com.sparta.sdet.util.Hamburgerable;
import com.sparta.sdet.util.Headerable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class InventoryItemPage extends TestBase implements Headerable, Hamburgerable, Footerable  {

    public InventoryItemPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public String getItemTitle() {
        return webDriver.findElement(By.className("inventory_details_name")).getText();
    }

    public String getItemDescription() {
        return webDriver.findElement(By.className("inventory_details_desc")).getText();
    }

    public String getItemCost() {
        return webDriver.findElement(By.className("inventory_details_price")).getText();
    }

    public String getItemImage() {
        WebElement productImage = webDriver.findElement(By.className("inventory_details_img"));
        return productImage.getAttribute("src");
    }

    public boolean addProductButtonExists() {
        return webDriver.findElements(By.className("btn_primary")).size() == 1;
    }

    public boolean removeProductButtonExists() {
        return webDriver.findElements(By.cssSelector("[id^='remove']")).size() == 1;
    }

    public boolean canAddProductToCart() {
        String cartNumberString;
        if(webDriver.findElements(By.className("shopping_cart_badge")).size() > 0) {
            cartNumberString = webDriver.findElement(By.className("shopping_cart_badge")).getText();
            int preClickNumber = Integer.parseInt(cartNumberString);
            webDriver.findElement(By.className("btn_primary")).click();
            cartNumberString = webDriver.findElement(By.className("shopping_cart_badge")).getText();
            int postClickNumber = Integer.parseInt(cartNumberString);
            return postClickNumber == preClickNumber + 1;
        } else {
            webDriver.findElement(By.className("btn_primary")).click();
            cartNumberString = webDriver.findElement(By.className("shopping_cart_badge")).getText();
            return (Integer.parseInt(cartNumberString) == 1);
        }
    }

    public boolean canRemoveProductFromCart() {
        webDriver.findElement(By.className("btn_primary")).click();
        webDriver.findElement(By.cssSelector("[id^='remove']")).click();
        return webDriver.findElements(By.className("shopping_cart_badge")).size() == 0;
    }

    public InventoryPage goToInventory() {
        webDriver.findElement(By.id("back-to-products")).click();
        return new InventoryPage();
    }

    @Override
    public String testFacebook(WebDriver webDriver) {
        By facebookLink = new By.ByLinkText("Facebook");
        webDriver.findElement(facebookLink).click();
        ArrayList<String> windowTabs = new ArrayList<> (webDriver.getWindowHandles());
        return webDriver.switchTo().window(windowTabs.get(1)).getCurrentUrl();
    }

    @Override
    public String testTwitter(WebDriver webDriver) {
        By twitterLink = new By.ByLinkText("Twitter");
        webDriver.findElement(twitterLink).click();
        ArrayList<String> windowTabs = new ArrayList<> (webDriver.getWindowHandles());
        return webDriver.switchTo().window(windowTabs.get(1)).getCurrentUrl();
    }

    @Override
    public String testLinkedin(WebDriver webDriver) {
        By linkedInLink = new By.ByLinkText("LinkedIn");
        webDriver.findElement(linkedInLink).click();
        ArrayList<String> windowTabs = new ArrayList<> (webDriver.getWindowHandles());
        return webDriver.switchTo().window(windowTabs.get(1)).getCurrentUrl();
    }

    @Override
    public String testTermsAndConditions(WebDriver webDriver) {
        return "Link not yet implemented by the Development Team";
    }

    @Override
    public String testPrivacyPolicy(WebDriver webDriver) {
        return "Link not yet implemented by the Development Team";
    }

    @Override
    public boolean isHamburgerVisable(WebDriver webDriver) {
        return webDriver.findElements(By.id("react-burger-menu-btn")).size() == 1;
    }

    @Override
    public String testAllItems(WebDriver webDriver) {
        webDriver.findElement(By.id("react-burger-menu-btn")).click();
        webDriver.findElement(By.id("inventory_sidebar_link")).click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testAbout(WebDriver webDriver) {
        webDriver.findElement(By.id("react-burger-menu-btn")).click();
        webDriver.findElement(By.id("about_sidebar_link")).click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testLogout(WebDriver webDriver) {
        webDriver.findElement(By.id("react-burger-menu-btn")).click();
        webDriver.findElement(By.id("logout_sidebar_link")).click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public boolean isCartEmptyOnReset(WebDriver webDriver) {
        webDriver.findElement(By.className("btn_primary")).click();
        webDriver.findElement(By.id("react-burger-menu-btn")).click();
        webDriver.findElement(By.id("reset_sidebar_link")).click();
        return webDriver.findElements(By.className("shopping_cart_badge")).size() == 0;
    }

    @Override
    public boolean isButtonResetOnReset(WebDriver webDriver) {
        webDriver.findElement(By.className("btn_primary")).click();
        webDriver.findElement(By.id("react-burger-menu-btn")).click();
        webDriver.findElement(By.id("reset_sidebar_link")).click();
        return webDriver.findElements(By.className("btn_primary")).size() == 1;
    }

    @Override
    public String testCartNavigation(WebDriver webDriver) {
        webDriver.findElement(By.id("shopping_cart_container")).click();
        return webDriver.getCurrentUrl();
    }
}
