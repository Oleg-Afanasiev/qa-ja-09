package com.academy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class CitrusTests extends BaseTest {

    @Test
    public void testTvSelect() {
        System.out.println("Citrus test");
        driver.get("https://www.citrus.ua");
        String menuXpath = "//div/ul/li[@class='menu-aim__item']/a[@href='/televizory-photo-video/']";
        String tvLinkXPath = "//*[@id='header']/div[3]/div/div[2]/div[2]/ul/li[3]/div/div/div[2]/ul/li[2]/a";
        String pricesXPath = "//div[@class='prices__price']/span";
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(menuXpath)))
                .build()
                .perform();

        driver.findElement(By.xpath(tvLinkXPath)).click();
        List<WebElement> prices = driver.findElements(By.xpath(pricesXPath));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 1 - for
        for(int i = 0; i < prices.size(); i++) {
            System.out.println(prices.get(i).getText());
        }
        // 2 - stream API
       // prices.stream().map(WebElement::getText).forEach(System.out::println);

        // Не торопимся закрывать
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
