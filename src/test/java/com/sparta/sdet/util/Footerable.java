package com.sparta.sdet.util;

import org.openqa.selenium.WebDriver;

public interface Footerable {
    String testFacebook(WebDriver webDriver);
    String testTwitter(WebDriver webDriver);
    String testLinkedin(WebDriver webDriver);
    String testTermsAndConditions(WebDriver webDriver);
    String testPrivacyPolicy(WebDriver webDriver);
}
