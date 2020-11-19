package com.academy.automation.selenide.page;

import com.academy.automation.selenide.page.LoginPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {
    @FindBy(linkText = "Sign in")
    private SelenideElement signInLink;

    public HomePage goToHome() {
        open(Configuration.baseUrl);
        return page(HomePage.class);
    }

    public LoginPage clickSignIn() {
        signInLink.click();
        return page(LoginPage.class);
    }
}
