package com.sparta.sdet.util;

import org.openqa.selenium.WebDriver;

public interface Hamburgerable {
    boolean isHamburgerVisable(WebDriver webDriver);
    String testAllItems(WebDriver webDriver);
    String testAbout(WebDriver webDriver);
    String testLogout(WebDriver webDriver);
    boolean isCartEmptyOnReset(WebDriver webDriver);
    boolean isButtonResetOnReset(WebDriver webDriver);
}
