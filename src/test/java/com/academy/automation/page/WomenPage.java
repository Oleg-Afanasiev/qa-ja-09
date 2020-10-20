package com.academy.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenPage extends BasePage {
    private MenuPage menuPage;

    @FindBy(xpath= "//*[@id='center_column']/h1/span[1]")
    private WebElement womenHeader;

    public WomenPage(WebDriver driver) {
        super(driver);
        menuPage = new MenuPage(driver);

    }
    public WomenPage goToWomen() {
        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
        return this;
    }
    public String getWomenHeader() {
        return womenHeader.getText();
    }

    public MenuPage getMenuPage() {
        return menuPage;
    }
}
