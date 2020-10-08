package com.academy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AutomationTests extends BaseTest {

    @Test
    public void testSelectWomenDress() {
        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
        WebElement selectBox = driver.findElement(By.id("selectProductSort"));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menu")));
    }
}
