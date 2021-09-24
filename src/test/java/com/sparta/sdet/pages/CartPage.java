package com.sparta.sdet.pages;

import com.sparta.sdet.util.Footerable;
import com.sparta.sdet.util.Hamburgerable;
import com.sparta.sdet.util.Headerable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

import static com.sparta.sdet.base.TestBase.webDriver;

public class CartPage implements Headerable, Hamburgerable, Footerable {

    private @FindBy(id = "checkout")
    WebElement checkoutButton;
    private @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;
    private @FindBy(className = "cart_list")
    WebElement cartList;
    private @FindAll({@FindBy(className = "cart_item")})
    List<WebElement> cartItems;


    private @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartLinkButton;
    private @FindBy(className = "social_facebook")
    WebElement facebookButton;
    private @FindBy(className = "social_twitter")
    WebElement twitterButton;
    private @FindBy(className = "social_linkedIn")
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

    private WebElement getElement(String itemName) {

        if(itemName == null) {
            return null;
        }

        for (WebElement item : cartItems) {
            if(item.getAttribute("name").toLowerCase().equals(itemName)) {
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
