package com.academy.automation.page;

import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {
    // Элементы меню

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public MenuPage clickByAdminItem() {
        return this;
    }
}
