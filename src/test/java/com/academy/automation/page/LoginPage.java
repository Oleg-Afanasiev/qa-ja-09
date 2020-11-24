package com.academy.automation.page;

import com.academy.core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id="email1")
    private WebElement emailField;

    @FindBy(id="passwd")
    private WebElement passwordField;

    @FindBy(id="SubmitLogin")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='center_column']/div/ol/li")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Вводим email {0}")
    public LoginPage fillEmail(String email) {
//        emailField.clear();
//        emailField.sendKeys(email);
        fillTextField(emailField, email);
        return this;
    }

    @Step("Вводим пароль {0}")
    public LoginPage fillPassword(String password) {
//        passwordField.clear();
//        passwordField.sendKeys(password);
        fillTextField(passwordField, password);
        return this;
    }

    @Step("Нажимаем submit")
    public LoginPage submit() {
        submitButton.click();
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
