package com.sparta.sdet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.sparta.sdet.base.TestBase.webDriver;

public class CheckoutStepTwoPage {
    //Cancel and Finish Buttons
    @FindBy(id = "finish")
    WebElement finishButton;
    @FindBy(id = "cancel")
    WebElement cancelButton;

    //Item and Cart Info
    @FindBy(className = "cart_item")
    List<WebElement> cartItems;

    //Payment and Shipping Information
    @FindBy(className = "summary_value_label")
    List<WebElement> orderInfo;

    //Price Web Elements
    @FindBy(className = "summary_subtotal_label")
    WebElement subTotalLabel;
    @FindBy(className = "summary_tax_label")
    WebElement taxLabel;
    @FindBy(className = "summary_total_label")
    WebElement totalLabel;

    //Constructor
    public CheckoutStepTwoPage() {
        PageFactory.initElements(webDriver, this);
    }

    //Getters
    public List<WebElement> getAllItems() {
       return cartItems;
    }

    public WebElement getItem(String itemName) {
        for (WebElement item:cartItems) {
            String currentItemName = item.findElement(new By.ByClassName("inventory_item_name")).getText();
            if (currentItemName.equals(itemName)) {
                return item;
            }
        }
        return null;
        //BRING THIS UP!!!!
    }

    public String getItemDescription(String itemName) {
        WebElement item = getItem(itemName);
        return item.findElement(new By.ByClassName("inventory_item_desc")).getText();
    }

    public double getItemPrice(String itemName) {
        WebElement item = getItem(itemName);
        return Double.parseDouble(item.findElement(new By.ByClassName("inventory_item_price")).getText());
    }

    public int getItemQuantity(String itemName) {
        WebElement item = getItem(itemName);
        return Integer.parseInt(item.findElement(new By.ByClassName("cart_quantity")).getText());
    }

    public int getNumberOfItems() {
        return cartItems.size();
    }

    public String getShippingInformation() {
        return orderInfo.get(0).getText();
    }

    public String getPaymentInformation() {
        return orderInfo.get(1).getText();
    }

    public double getItemTotal() {
        return Double.parseDouble(subTotalLabel.getText());
    }

    public double getTax() {
        return Double.parseDouble(taxLabel.getText());
    }

    public double getTotal() {
        return Double.parseDouble(totalLabel.getText());
    }

    public boolean isToTwoDecimalPlaces() {
        ArrayList<Double> prices = new ArrayList<>();
        prices.add(getItemTotal());
        prices.add(getTax());
        prices.add(getTotal());

        for (double price: prices) {
            if ((BigDecimal.valueOf(price).scale() != 2)) {
                return false;
            }
        }
        return true;
    }

    public boolean isItemPresent(String itemName) {
        return getItem(itemName) != null;
    }

    public boolean isItemQualityAsExpected(String itemName, int expectedQuantity) {
        return (getItemQuantity(itemName) == expectedQuantity);
    }


    //Navigation

    public CheckoutCompletePage finaliseCheckout() {
        finishButton.click();
        return new CheckoutCompletePage();
    }

    public InventoryPage cancelCheckout() {
        cancelButton.click();
        return new InventoryPage();
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }
}
