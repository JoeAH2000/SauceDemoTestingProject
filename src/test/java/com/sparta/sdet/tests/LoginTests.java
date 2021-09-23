package com.sparta.sdet.tests;

import com.sparta.sdet.base.TestBase;
import com.sparta.sdet.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;

public class LoginTests {
    private LoginPage loginPage;

    @BeforeEach
    void setup() {
        TestBase.initialisation();
        loginPage = new LoginPage();
    }

    public LoginTests() {
        super();
    }


}
