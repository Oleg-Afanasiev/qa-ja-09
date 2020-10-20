package com.academy.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class BaseTest {
    private static Logger LOG = LogManager.getLogger(BaseTest.class.getName());

    protected EventFiringWebDriver driver;
    private final StringBuffer verificationErrors = new StringBuffer();

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) throws Exception {
//        String path = System.getProperty("cfg");
//        System.out.println(path);
//
//        Properties properties = new Properties();
//        properties.load(new FileInputStream(path));
//        String chromeDriver = properties.getProperty("driver.chrome");
//        System.out.println(chromeDriver);

        if (browser.equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "D:/programming/teaching/qa-09-maven/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "D:/app/drivers/chromedriver.exe");
            driver = new EventFiringWebDriver(new ChromeDriver());

        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:/programming/teaching/qa-09-maven/drivers/geckodriver.exe");
            driver = new EventFiringWebDriver(new FirefoxDriver());

        } else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "D:/programming/teaching/qa-09-maven/drivers/msedgedriver.exe");
            driver = new EventFiringWebDriver(new EdgeDriver());
        }
        else {
            System.setProperty("webdriver.chrome.driver", "D:/programming/teaching/qa-09-maven/drivers/chromedriver.exe");
            driver = new EventFiringWebDriver(new ChromeDriver());
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.register(new WebDriverEventListenerImpl("D:/tmp/screens"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @BeforeMethod
    public void testStart(Method method, Object[] params) {
        LOG.info("test {} starts with params: {}",
                method.getName(), Arrays.toString(params));
    }

    @AfterMethod
    public void testComplete(Method method) {
        LOG.info("test {} finished.", method.getName());
    }
}