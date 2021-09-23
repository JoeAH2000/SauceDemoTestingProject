package com.sparta.sdet.pages;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.util.Footerable;
import com.sparta.sdet.util.Hamburgerable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends TestBase implements Hamburgerable, Footerable {
    private WebDriver webDriver;

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

    public InventoryPage() {
        PageFactory.initElements(webDriver, this);
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
