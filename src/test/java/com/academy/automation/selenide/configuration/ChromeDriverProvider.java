package com.academy.automation.selenide.configuration;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver( DesiredCapabilities desiredCapabilities) {
        System.setProperty("webdriver.chrome.driver", "D:/app/drivers/chromedriver.exe");
        System.out.println("**************");
//        System.setProperty("webdriver.gecko.driver", "d:/distribs/selenium/geckodriver.exe");


        return new ChromeDriver();
    }
}
