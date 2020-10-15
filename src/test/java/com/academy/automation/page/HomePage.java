package com.academy.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHome() {
        driver.get("http://automationpractice.com/index.php");
        return this;
    }

    public LoginPage clickSignIn() {
        signInLink.click();
        return new LoginPage(driver);
    }
}
