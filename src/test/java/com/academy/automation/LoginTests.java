package com.academy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class LoginTests {
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        String path = System.getProperty("cfg");
        System.out.println(path);

        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        String chromeDriver = properties.getProperty("driver.chrome");
        System.out.println(chromeDriver);

        System.setProperty("webdriver.chrome.driver", "D:/programming/teaching/qa-09-maven/drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:/programming/teaching/qa-09-maven/drivers/geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "D:/programming/teaching/qa-09-maven/drivers/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLoginError() throws Exception {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("username");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("password");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
        assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/div/ol/li")).getText(), "Invalid email address.");
    }

    @Test
    public void testLoginSuccess() {
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
