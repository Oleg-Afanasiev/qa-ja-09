package com.academy.core;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

@Listeners(TestListener.class)
public class BaseTest {
    private static Logger LOG = LogManager.getLogger(BaseTest.class.getName());

    protected EventFiringWebDriver driver;
    private final StringBuffer verificationErrors = new StringBuffer();
    protected Properties properties;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) throws Exception {
        initProperties();

        String chromeDriver = properties.getProperty("driver.chrome");
        String screenDir = properties.getProperty("screen.dir");

        if (browser.equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "D:/programming/teaching/qa-09-maven/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", chromeDriver);
            driver = new EventFiringWebDriver(new ChromeDriver());

        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:/app/drivers/geckodriver.exe");
            driver = new EventFiringWebDriver(new FirefoxDriver());

        } else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "D:/programming/teaching/qa-09-maven/drivers/msedgedriver.exe");
            driver = new EventFiringWebDriver(new EdgeDriver());
        } else if (browser.equals("safari")) {
            driver = new EventFiringWebDriver(new SafariDriver());
        }
        else {
            System.setProperty("webdriver.chrome.driver", "D:/programming/teaching/qa-09-maven/drivers/chromedriver.exe");
            driver = new EventFiringWebDriver(new ChromeDriver());
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.register(new WebDriverEventListenerImpl(screenDir));
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

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return driver.getScreenshotAs(OutputType.BYTES);
    }

    private void initProperties() throws IOException {
        // Ищем путь к конфигам по ключу
        String path = System.getProperty("cfg");
        InputStream is;
        if (path == null) // иначе берем конфиги из рессурсов
            is = this.getClass().getClassLoader().getResourceAsStream("demo.properties");
        else
            is = new FileInputStream(path);
        properties = new Properties();
        properties.load(is);
    }
}
