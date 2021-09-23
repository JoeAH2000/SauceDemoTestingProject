package com.sparta.sdet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

public class CartPage {

    private @FindBy(id = "checkout")
    WebElement checkoutButton;
    private @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;
    private @FindBy(className = "cart_list")
    WebElement cartList;
    private @FindAll({@FindBy(className = "cart_item")})
    List<WebElement> cartItems;

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
        //cartList.findElements(By.ByClassName)
    }

    public String getItem(String itemName) {

    }

    public String getItemDescription(String itemName) {

    }

    public double getItemPrice(String itemName) {

    }

    public int getItemQuantity(String itemName) {

    }

    public int getNumberOfItems() {

    }

    public CheckoutStepOnePage goToCheckout() {
        checkoutButton.click();
        return new CheckoutStepOnePage();
    }

    public InventoryPage gotoHomepage() {
        continueShoppingButton.click();
        return  new InventoryPage();
    }

    public void removeItemFromCart() {

    }
}
