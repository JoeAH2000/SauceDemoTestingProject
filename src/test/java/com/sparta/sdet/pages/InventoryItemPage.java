package com.sparta.sdet.pages;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.util.Footerable;
import com.sparta.sdet.util.Hamburgerable;
import com.sparta.sdet.util.Headerable;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage extends TestBase implements Headerable, Hamburgerable, Footerable  {

    public InventoryItemPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(className="inventory_details_name")
    WebElement productTitle;
    public String getItemTitle() {
        return productTitle.getText();
    }

    @FindBy(className="inventory_details_desc")
    WebElement productDescription;
    public String getItemDescription() {
        return productDescription.getText();
    }

    @FindBy(className = "inventory_details_price")
    WebElement productPrice;
    public String getItemCost() {
        return productPrice.getText();
    }

    @FindBy(className = "inventory_details_img")
    WebElement productImage;
    public String getItemImage() {
        return productImage.getAttribute("src");
    }

    @FindBy(className = "btn_primary") WebElement addProductButton;
    public boolean addProductButtonExists() {
        return addProductButton.isEnabled();
    }

    public boolean removeProductButtonExists() {
        WebElement removeProductButton = webDriver.findElement(By.cssSelector("[id^='remove']"));
        return removeProductButton.isEnabled();
    }

    public boolean canAddProductToCart() {
        String cartNumberString;
        try {
            cartNumberString = webDriver.findElement(By.className("shopping_cart_badge")).getText();
            int preClickNumber = Integer.parseInt(cartNumberString);
            addProductButton.click();
            cartNumberString = webDriver.findElement(By.className("shopping_cart_badge")).getText();
            int postClickNumber = Integer.parseInt(cartNumberString);
            return postClickNumber == preClickNumber + 1;
        } catch(ElementNotVisibleException e) {
            addProductButton.click();
            cartNumberString = webDriver.findElement(By.className("shopping_cart_badge")).getText();
            return (Integer.parseInt(cartNumberString) == 1);
        }
    }

    public boolean canRemoveProductFromCart() {
        addProductButton.click();
        WebElement removeProductButton = webDriver.findElement(By.cssSelector("[id^='remove']"));
        removeProductButton.click();
        return webDriver.findElement(By.className("shopping_cart_badge")).isEnabled();
    }

    @FindBy(id = "back_to_products") WebElement backToProductButton;
    public InventoryPage goToInventory() {
        backToProductButton.click();
        return new InventoryPage();
    }

    @FindBy(linkText = "Facebook") WebElement facebookIcon;
    @Override
    public String testFacebook(WebDriver webDriver) {
        facebookIcon.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testTwitter(WebDriver webDriver) {
        webDriver.findElement(By.linkText("Twitter"));
        return webDriver.getCurrentUrl();
    }

    @FindBy(linkText = "Linkedin") WebElement linkedInIcon;
    @Override
    public String testLinkedin(WebDriver webDriver) {
        linkedInIcon.click();
        return webDriver.getCurrentUrl();
    }

    @FindBy(className = "termsOfService") WebElement termsOfServiceLink; // CHECK WITH GROUP
    @Override
    public String testTermsAndConditions(WebDriver webDriver) {
        termsOfServiceLink.click();
        return webDriver.getCurrentUrl();
    }

    @FindBy(className = "privacyPolicy") WebElement privacyPolicyLink; // CHECK WITH GROUP
    @Override
    public String testPrivacyPolicy(WebDriver webDriver) {
        privacyPolicyLink.click();
        return webDriver.getCurrentUrl();
    }

    @FindBy(id = "react-burger-menu-btn") WebElement burgerButton;
    @Override
    public boolean isHamburgerVisable(WebDriver webDriver) {
        return burgerButton.isEnabled();
    }

    @FindBy(id = "inventory_sidebar_link") WebElement allItemsTab;
    @Override
    public String testAllItems(WebDriver webDriver) {
        burgerButton.click();
        allItemsTab.click();
        return webDriver.getCurrentUrl();
    }

    @FindBy(id = "about_sidebar_link") WebElement aboutTab;
    @Override
    public String testAbout(WebDriver webDriver) {
        burgerButton.click();
        aboutTab.click();
        return webDriver.getCurrentUrl();
    }

    @FindBy(id = "logout_sidebar_link") WebElement logoutTab;
    @Override
    public String testLogout(WebDriver webDriver) {
        burgerButton.click();
        logoutTab.click();
        return webDriver.getCurrentUrl();
    }

    @FindBy(id = "reset_sidebar_link") WebElement resetTab;
    @Override
    public boolean isCartEmptyOnReset(WebDriver webDriver) {
        burgerButton.click();
        resetTab.click();
        return !webDriver.findElement(By.className("shopping_cart_badge")).isEnabled();
    }

    @Override
    public boolean isButtonResetOnReset(WebDriver webDriver) {
        addProductButton.click();
        burgerButton.click();
        resetTab.click();
        return addProductButton.isEnabled();
    }

    @FindBy(id = "shopping_cart_container") WebElement cartLogo;
    @Override
    public String testCartNavigation(WebDriver webDriver) {
        cartLogo.click();
        return webDriver.getCurrentUrl();
    }
}
