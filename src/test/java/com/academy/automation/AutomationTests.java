package com.academy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class AutomationTests {
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "D:/programming/teaching/qa-09-maven/drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:/programming/teaching/qa-09-maven/drivers/geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "D:/programming/teaching/qa-09-maven/drivers/msedgedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSelectWomenDress() {
        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
        WebElement selectBox = driver.findElement(By.id("selectProductSort"));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menu")));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
