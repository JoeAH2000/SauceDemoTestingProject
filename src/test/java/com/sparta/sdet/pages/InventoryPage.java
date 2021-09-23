package com.sparta.sdet.pages;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.util.Footerable;
import com.sparta.sdet.util.Hamburgerable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    //Filter
    @FindBy(className = "product_sort_container")
    WebElement btnDropdownFilter;

    //Cards

//    @FindBy(className = "inventory_list")
//    List<WebElement> inventoryList;


    //@FindBy(how = How.CLASS_NAME , using="inventory_item_name")
    @FindBy(how = How.CLASS_NAME , using="inventory_item_name") public List<WebElement> inventoryList;

    public InventoryPage() {
        PageFactory.initElements(webDriver, this);
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

    public int getNumberOfInventoryItems(){
        return inventoryList.size();
    }

    public void getProductTitles(){
        for(WebElement inventoryItem:inventoryList){
            //get inventory item names
        }
    }




    @Override
    public String testFacebook(WebDriver webDriver) {
        return null;
    }

    @Override
    public String testTwitter(WebDriver webDriver) {
        return null;
    }

    @Override
    public String testLinkedin(WebDriver webDriver) {
        return null;
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
        return false;
    }

    @Override
    public String testAllItems(WebDriver webDriver) {
        return null;
    }

    @Override
    public String testAbout(WebDriver webDriver) {
        return null;
    }

    @Override
    public String testLogout(WebDriver webDriver) {
        return null;
    }

    @Override
    public boolean isCartEmptyOnReset(WebDriver webDriver) {
        return false;
    }

    @Override
    public boolean isButtonResetOnReset(WebDriver webDriver) {
        return false;
    }
}
