package com.sparta.sdet.util;

import org.openqa.selenium.WebDriver;

public interface Hamburgerable {
    boolean isHamburgerVisable();
    String testAllItems();
    String testAbout();
    String testLogout();
    boolean isCartEmptyOnReset();
    boolean isButtonResetOnReset();
}
