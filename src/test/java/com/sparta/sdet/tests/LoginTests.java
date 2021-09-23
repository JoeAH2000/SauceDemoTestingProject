package com.sparta.sdet.tests;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.LoginPage;
import com.sparta.sdet.util.PropertiesLoader;
import org.junit.jupiter.api.*;

import static com.sparta.sdet.base.TestBase.webDriver;

public class LoginTests {
    private LoginPage loginPage;

    @BeforeEach
    void setup() {
        TestBase.initialisation();
        loginPage = new LoginPage();
        webDriver.get("https://www.saucedemo.com/");
    }

    @Nested
    @DisplayName("Login Functional Tests")
    class LoginFunctionalTests {
        @Test
        @DisplayName("Test Valid Credentials")
        void testValidCredentials() {
            loginPage.setUsername(PropertiesLoader.getProperties().getProperty("Username"));
            loginPage.setPassword(PropertiesLoader.getProperties().getProperty("Password"));
            loginPage.enterUsername();
            loginPage.enterPassword();
            loginPage.loginButtonClick();
            Assertions.assertEquals("https://www.saucedemo.com/inventory.html", webDriver.getCurrentUrl().toString());
        }

        @Test
        @DisplayName("Test Invalid Credentials")
        void testInvalidCredentials() {
            loginPage.setUsername("nope");
            loginPage.setPassword("wrong again");
            loginPage.enterUsername();
            loginPage.enterPassword();
            loginPage.loginButtonClick();
            Assertions.assertEquals("https://www.saucedemo.com/", webDriver.getCurrentUrl().toString());
        }

        @Test
        @DisplayName("Test Null Credentials")
        void testNullCredentials() {
            loginPage.setUsername(null);
            loginPage.setPassword(null);
            loginPage.enterUsername();
            loginPage.enterPassword();
            loginPage.loginButtonClick();
            Assertions.assertEquals("https://www.saucedemo.com/", webDriver.getCurrentUrl().toString());
        }

        @Test
        @DisplayName("Test Empty Credentials")
        void testEmptyCredentials() {
            loginPage.setUsername("");
            loginPage.setPassword("");
            loginPage.enterUsername();
            loginPage.enterPassword();
            loginPage.loginButtonClick();
            Assertions.assertEquals("https://www.saucedemo.com/", webDriver.getCurrentUrl().toString());
        }
    }

    @Nested
    @DisplayName("Getter and Setter Tests")
    class GetterAndSetterTests {
        @Test
        @DisplayName("usernameSetGetTest")
        void usernameGetterTest() {
            loginPage.setUsername("test_username");
            Assertions.assertEquals("test_username", loginPage.getUsername());
        }

        @Test
        @DisplayName("passwordSetGetTest")
        void passwordSetGetTest() {
            loginPage.setPassword("test_password");
            Assertions.assertEquals("test_password", loginPage.getPassword());
        }
    }

    @Nested
    @DisplayName("isValidTests")
    class IsValidTests {
        @Test
        @DisplayName("isValid Valid Username Test")
        void isValidValidUsernameTest() {
            loginPage.setUsername(PropertiesLoader.getProperties().getProperty("Username"));
            Assertions.assertTrue(loginPage.isUsernameValid());
        }

        @Test
        @DisplayName("isValid Invalid Username Test")
        void isValidInvalidUsernameTest() {
            loginPage.setUsername("nope");
            Assertions.assertFalse(loginPage.isUsernameValid());
        }

        @Test
        @DisplayName("isValid Valid Password Test")
        void isValidValidPasswordTest() {
            loginPage.setPassword(PropertiesLoader.getProperties().getProperty("Password"));
            Assertions.assertTrue(loginPage.isPasswordValid());
        }

        @Test
        @DisplayName("isValid Invalid Password Test")
        void isValidInvalidPasswordTest() {
            loginPage.setPassword("wrong again");
            Assertions.assertFalse(loginPage.isPasswordValid());
        }
    }

    @AfterEach
    void teardown() {
        webDriver.quit();
    }
}
