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
        return cartItems.toString();
    }

    private WebElement getElement(String itemName) {
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
}
