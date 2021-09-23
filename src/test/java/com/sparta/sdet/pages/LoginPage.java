package com.sparta.sdet.pages;

import com.sparta.sdet.util.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.sparta.sdet.base.TestBase.webDriver;

public class LoginPage {

    @FindBy(id="user-name") WebElement userName_txt;
    @FindBy(id="password") WebElement passWord_txt;
    @FindBy(id="login-button") WebElement login_btn;

    private String username;
    private String password;

    public LoginPage() {
        PageFactory.initElements(webDriver, this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void enterUsername() {
        userName_txt.sendKeys(this.username);
    }

    public boolean isUsernameValid() {
        return isValid("user-name", this.username);
    }

    public void enterPassword() {
        passWord_txt.sendKeys(this.password);
    }

    public boolean isPasswordValid() {
        return isValid("password", this.password);
    }

    private boolean isValid(String propertyKey, String text) {
        boolean valid = text.equals(
                PropertiesLoader.getProperties().getProperty(propertyKey));

        return valid;
    }

    public boolean loginButtonClick() {
        login_btn.click();

        //If url is still login page
        if(webDriver.getCurrentUrl().equals(PropertiesLoader.getProperties().getProperty("url"))) {
            return false;
        }
        return true;
    }
}
