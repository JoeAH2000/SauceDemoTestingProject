package com.sparta.sdet.pages;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.util.Footerable;
import com.sparta.sdet.util.Hamburgerable;
import com.sparta.sdet.util.Headerable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


import static com.sparta.sdet.base.TestBase.webDriver;

public class CartPage extends TestBase implements Headerable, Hamburgerable, Footerable {

    public CartPage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "checkout")
    WebElement checkoutButton;
    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;
    @FindBy(className = "cart_list")
    WebElement cartList;
    @FindAll({@FindBy(className = "cart_item")})
    List<WebElement> cartItems;
    @FindAll({@FindBy(className = "inventory_item_name")})
    List<WebElement> cartItemNames;


    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartLinkButton;
    @FindBy(className = "social_facebook")
    WebElement facebookButton;
    @FindBy(className = "social_twitter")
    WebElement twitterButton;
    @FindBy(className = "social_linkedIn")
    WebElement linkedInButton;
    @FindBy(className = "footer_copy")
    WebElement termsAndConditions;
    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenu;
    @FindBy(id = "inventory_sidebar_link")
    WebElement allItemsLink;
    @FindBy(id = "about_sidebar_link")
    WebElement aboutLink;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;
    @FindBy(id = "reset_sidebar_link")
    WebElement resetLink;

    private WebElement element;
    private HashMap<String, WebElement> elements;
    private String itemName;
    private String itemDescription;
    private double itemPrice;
    private int itemQuantity;

    public WebElement getElement() {
        return element;
    }

    public HashMap<String, WebElement> getElements() {
        return elements;
    }

    public String getAllItems() {
        return cartItems.toString();
    }

    public List<String> getAllItemNames() {
        List<String> itemNames = new ArrayList<>();
        for(WebElement name: cartItemNames) {
            itemNames.add(name.getText());
        }
        return itemNames;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    private WebElement getElement(String itemName) {

        if(itemName == null) {
            return null;
        }

        for (WebElement item : cartItems) {
            if(item.findElement(By.className("inventory_item_name")).getText().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public String getItemDescription(String itemName) {
        element = getElement(itemName);

        if(element != null) {
            return element.findElement(By.className("cart_desc_label")).getText();
        } else {
            return "";
        }
    }

    public double getItemPrice(String itemName) {
        element = getElement(itemName);

        if(element != null) {
            String value =  element.findElement(By.className("inventory_item_price")).getText();
            double price = Double.parseDouble(value.substring(1));
            return price;
        } else {
            return -1;
        }
    }

    public int getItemQuantity(String itemName) {
        element = getElement(itemName);

        if(element != null) {
            int quantity = Integer.parseInt(element.findElement(By.className("cart_quantity")).getText());
            return quantity;
        }
        return -1;
    }

    public int getNumberOfItems() {
        return cartItems.size();
    }

    public CheckoutStepOnePage goToCheckout() {
        checkoutButton.click();
        return new CheckoutStepOnePage();
    }

    public InventoryPage gotoHomepage() {
        continueShoppingButton.click();
        return new InventoryPage();
    }

    public void removeItemFromCart(String itemName) {
        element = getElement(itemName);

        if(element != null)
            element.findElement(By.className("btn btn_secondary btn_small cart_button")).click();
    }

    @Override
    public String testCartNavigation() {

        if(webDriver == null) {
            return "";
        }

        shoppingCartLinkButton.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testFacebook() {
        if(webDriver == null) {
            return "";
        }

        facebookButton.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testTwitter() {
        if(webDriver == null) {
            return "";
        }

        twitterButton.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testLinkedin() {
        if(webDriver == null) {
            return "";
        }

        linkedInButton.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testTermsAndConditions() {
        if(webDriver == null) {
            return "";
        }

        return termsAndConditions.getText();
    }

    @Override
    public String testPrivacyPolicy() {
        if(webDriver == null) {
            return "";
        }

        return termsAndConditions.getText();
    }

    @Override
    public boolean isHamburgerVisable() {
        if(webDriver == null) {
            return false;
        }

        return burgerMenu.isDisplayed();
    }

    @Override
    public String testAllItems() {
        if(webDriver == null) {
            return "";
        }

        allItemsLink.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testAbout() {
        if(webDriver == null) {
            return "";
        }

        aboutLink.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testLogout() {
        if(webDriver == null) {
            return "";
        }

        logoutLink.click();
        return webDriver.getCurrentUrl();
    }

    @Override
    public boolean isCartEmptyOnReset() {
        if(webDriver == null) {
            return false;
        }

        resetLink.click();
        return cartItems.isEmpty();
    }

    @Override
    public boolean isButtonResetOnReset() {
        if(webDriver == null) {
            return false;
        }

        continueShoppingButton.click();
        List<WebElement> buttons = webDriver.findElements(By.className("btn btn_primary btn_small btn_inventory"));

        for (WebElement button:buttons) {
            if (button.getText().toLowerCase().contains("remove"))
                return false;
        }
        return true;
    }
}
