package com.academy.automation.selenide;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class LoginTests {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://automationpractice.com/index.php";
        Configuration.startMaximized = true;
        Configuration.timeout = 10;
    }

    @Test
    public void testLoginError() {
        open(Configuration.baseUrl);
        closeWindow();
    }

    @AfterClass
    public void tearDown() {

    }
}
