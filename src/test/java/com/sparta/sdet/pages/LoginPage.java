package com.sparta.sdet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.sparta.sdet.base.TestBase.webDriver;

public class LoginPage {
    @FindBy(id = "user-name")
    WebElement userName;
    public LoginPage() {
        PageFactory.initElements(webDriver, this);
    }
}
