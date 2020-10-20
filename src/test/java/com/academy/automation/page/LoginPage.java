package com.academy.automation.page;

import com.academy.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id="email")
    private WebElement emailField;

    @FindBy(id="passwd1")
    private WebElement passwordField;

    @FindBy(id="SubmitLogin")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='center_column']/div/ol/li")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillEmail(String email) {
//        emailField.clear();
//        emailField.sendKeys(email);
        fillTextField(emailField, email);
        return this;
    }

    public LoginPage fillPassword(String password) {
//        passwordField.clear();
//        passwordField.sendKeys(password);
        fillTextField(passwordField, password);
        return this;
    }

    public LoginPage submit() {
        submitButton.click();
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
