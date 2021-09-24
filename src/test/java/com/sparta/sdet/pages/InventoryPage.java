package com.sparta.sdet.pages;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.util.Footerable;
import com.sparta.sdet.util.Hamburgerable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends TestBase implements Hamburgerable, Footerable {

    //Hamburger Menu elements
    @FindBy(id="react-burger-menu-btn")
    WebElement btnHamburgerMenu;

    @FindBy(id = "about_sidebar_link")
    WebElement btnAboutUs;

    @FindBy(id ="logout_sidebar_link")
    WebElement btnLogOut;

    @FindBy(id="inventory_sidebar_link")
    WebElement btnAllItems;

    @FindBy(id="reset_sidebar_link")
    WebElement btnResetAppState;

    @FindBy(id="react-burger-cross-btn")
    WebElement btnExitHamburgerMenu;

    @FindBy(className = "btn_primary")
    WebElement btnAddToCart;

    //Inventory Items Text & Image
    @FindBy(id = "item_4_title_link")
    WebElement btnProductTxt;
    @FindBy(id = "item_4_img_link")
    WebElement btnProductImage;
    @FindBy(className = "pricebar")
    WebElement priceBar;

    //Inventory Items Name & Price (for filter)
    @FindBy(how = How.CLASS_NAME , using="inventory_item_name")
    public List<WebElement> inventoryList;
    @FindBy(how = How.CLASS_NAME , using="inventory_item_price")
    public List<WebElement> inventoryPriceList;

    //Shopping Basket
    @FindBy(className = "shopping_cart_link")
    WebElement btnShopCart;

    //Social Media Links
    @FindBy(className = "social_facebook")
    WebElement btnFacebook;
    @FindBy(className = "social_twitter")
    WebElement btnTwitter;
    @FindBy(className = "social_linkedin")
    WebElement btnLinkedIn;

    //Filter
    @FindBy(className = "product_sort_container")
    WebElement btnDropdownFilter;


    public InventoryPage() {
        PageFactory.initElements(webDriver, this);
    }

    public String getUrl(){
        return webDriver.getCurrentUrl();
    }

    public void clickHamburgerButton(){
        btnHamburgerMenu.click();
    }

    public void clickAboutUsButton(){
        btnAboutUs.click();
    }

    public void clickLogoutButton(){
        btnLogOut.click();
    }

    public void clickAllItems(){
        btnAllItems.click();
    }

    public void clickResetAppState(){
        btnResetAppState.click();
    }

    public void clickExitHamburgerMenu(){
        btnExitHamburgerMenu.click();
    }

    public void clickAddToCardButton(){
        btnAddToCart.click();
    }

    public void clickShoppingCart(){
        btnShopCart.click();
    }

    public boolean isShoppingCartPopulated(){
        try{
            return webDriver.findElement(By.className("shopping_cart_badge")).isDisplayed();
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public int getNumberOfProductsInCart(){
        try{
            String numberText = webDriver.findElement(By.className("shopping_cart_badge")).getText();
            int number = Integer.parseInt(numberText);
            return number;
        }
        catch(NoSuchElementException e){
            return 0;
        }
    }

    public boolean isRemovedButtonReset(){
        String priceBarText = priceBar.getText();
        return !priceBarText.contains("REMOVE");
    }

    public void clickDropDownFilter(){
        btnDropdownFilter.click();
    }

    public void clickAtoZ(){
        Select select = new Select(btnDropdownFilter);
        select.selectByVisibleText("Name (A to Z)");
    }

    public void clickZtoA(){
        Select select = new Select(btnDropdownFilter);
        select.selectByVisibleText("Name (Z to A)");
    }

    public void clickPriceLowToHigh(){
        Select select = new Select(btnDropdownFilter);
        select.selectByVisibleText("Price (low to high)");
    }

    public void clickPriceHighToLow(){
        Select select = new Select(btnDropdownFilter);
        select.selectByVisibleText("Price (high to low)");
    }

    public void clickProductText(){
        btnProductTxt.click();
    }

    public void clickProductImage(){
        btnProductImage.click();
    }

    public int getNumberOfInventoryItems(){
        return inventoryList.size();
    }

    public List<String> getProductTitles(){
        List<String> invLst = new ArrayList<>();
        for(WebElement inventoryItem:inventoryList){
            //get inventory item names
            invLst.add(inventoryItem.getText());
        }
        return invLst;
    }

    public List<Float> getProductPrice(){
        List<Float> invLst = new ArrayList<>();
        for(WebElement inventoryItem:inventoryPriceList){
            //get inventory item names
            String invPrice =  inventoryItem.getText();
            invPrice = invPrice.replace("$","");
            //inventoryItem.getText().replace("$","");
            invLst.add(Float.parseFloat( invPrice));
        }
        return invLst;
    }

    public String goToInventoryItemsWithText(){
        btnProductTxt.click();
        return webDriver.getCurrentUrl();
    }

    public String goToInventoryItemsWithImage(){
        btnProductImage.click();
        return webDriver.getCurrentUrl();
    }





    @Override
    public String testFacebook(WebDriver webDriver) {
        btnFacebook.click();
        ArrayList<String> windowTabs = new ArrayList<> (webDriver.getWindowHandles());
        return webDriver.switchTo().window(windowTabs.get(1)).getCurrentUrl();
    }

    @Override
    public String testTwitter(WebDriver webDriver) {
        btnTwitter.click();
        ArrayList<String> windowTabs = new ArrayList<> (webDriver.getWindowHandles());
        return webDriver.switchTo().window(windowTabs.get(1)).getCurrentUrl();
    }

    @Override
    public String testLinkedin(WebDriver webDriver) {
        btnLinkedIn.click();
        ArrayList<String> windowTabs = new ArrayList<> (webDriver.getWindowHandles());
        return webDriver.switchTo().window(windowTabs.get(1)).getCurrentUrl();
    }

    @Override
    public String testTermsAndConditions(WebDriver webDriver) {
        return null;
    }

    @Override
    public String testPrivacyPolicy(WebDriver webDriver) {
        return null;
    }

    @Override
    public boolean isHamburgerVisable(WebDriver webDriver) {
        return btnHamburgerMenu.isEnabled();
    }

    @Override
    public String testAllItems(WebDriver webDriver) {
        clickHamburgerButton();
        clickAllItems();
        return webDriver.getCurrentUrl();
    }

    @Override
    public String testAbout(WebDriver webDriver) {
        clickHamburgerButton();
        clickAboutUsButton();
        return webDriver.getCurrentUrl();

    }

    @Override
    public String testLogout(WebDriver webDriver) {
        clickHamburgerButton();
        clickLogoutButton();
        return webDriver.getCurrentUrl();
    }

    @Override
    public boolean isCartEmptyOnReset(WebDriver webDriver) {
        clickResetAppState();
        return !webDriver.findElement(By.className("shopping_cart_badge")).isEnabled();
    }

    @Override
    public boolean isButtonResetOnReset(WebDriver webDriver) {
        btnAddToCart.click();
        clickHamburgerButton();
        clickResetAppState();
        return btnAddToCart.isEnabled();
    }
}
