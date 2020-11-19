package com.academy.automation.selenide;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class LoginTests {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://automationpractice.com/index.php";
        Configuration.startMaximized = true;
        Configuration.timeout = 10;
    }

    @Test(dataProvider = "loginErrorProvider")
    public void testLoginError(String username, String password, String expectedMsg) {
        open(Configuration.baseUrl);
        $(By.linkText("Sign in")).click();
        $(By.id("email")).sendKeys(username);
        $(By.id("passwd")).sendKeys(password);
        $(By.xpath("//button[@id='SubmitLogin']/span")).click();
        String actualMsg = $(By.xpath("//div[@id='center_column']/div/ol/li")).getText();

        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @AfterClass
    public void tearDown() {
        closeWindow();
    }

    @DataProvider
    public Object[][] loginErrorProvider() {
        return new Object[][] {
                {"user","123","Invalid email address."}
        };
    }
}
