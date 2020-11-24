package com.academy.automation;

import com.academy.automation.page.HomePage;
import com.academy.automation.page.LoginPage;
import com.academy.core.BaseTest;
import com.academy.core.TestListener;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Listeners(TestListener.class)
public class LoginTests extends BaseTest {

    @Test(dataProvider = "loginErrorData")
    public void testLoginError(String username, String passw, String expectedMsg) throws Exception {
        driver.get("http://automationpractice.com/index.php");
        WebElement signInLink = driver.findElement(By.linkText("Sign in"));
        signInLink.click();

        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(passw);
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
        String actualMsg = driver.findElement(By.xpath("//div[@id='center_column']/div/ol/li")).getText();

        Assert.assertEquals(actualMsg, expectedMsg);
//        Assert.assertTrue(actualMsg.contains(expectedMsg));
    }

    @Description("Тест логин формы")
    @Issues({@Issue("1456"), @Issue("1234")})
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Test(dataProvider = "loginErrorData")
    public void testLoginErrorUsingPage(String username, String passw, String expectedMsg) {
        HomePage homePage = new HomePage(driver);
        homePage.goToHome();
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.fillEmail(username);
        loginPage.fillPassword(passw);
        loginPage.submit();
        String actualMsg = loginPage.getErrorMessage();
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test(dataProvider = "loginErrorData")
    public void testLoginErrorUsingPage2(String username, String passw, String expectedMsg) {
        String actualMsg = new HomePage(driver)
                .goToHome()
                .clickSignIn()
                .fillEmail(username)
                .fillPassword(passw)
                .submit()
                .getErrorMessage();

        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test
    @Ignore
    public void testLoginErrorCase2() {

    }

    @Test
    @Ignore
    public void testLoginSuccess() {
    }

    // TODO
    @DataProvider(name = "loginErrorData")
    public Object[][] loginErrorDataProvider() throws IOException {
        String path = "D:/teaching/ja-qa/09/project/test-data/login-tests.csv";
        Scanner scanner = new Scanner(new FileInputStream(path), StandardCharsets.UTF_8);
//        Workbook workbook = new SXSSFWorkbook()
//        workbook
//         BufferedReader fr  = new FileReader(path, StandardCharsets.UTF_8);
        List<String> lines = new ArrayList<>();
        // чтение файла с данными построчно
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            System.out.println(nextLine);
            lines.add(nextLine);
        }
        scanner.close();
        Object[][] data = new Object[lines.size()][3];

        for (int i = 0; i < lines.size(); i++) {
            String[] lineParts = lines.get(i).split(",");

            // можно сделать через чикл ДЗ
            data[i][0] = lineParts[0];
            data[i][1] = lineParts[1];
            data[i][2] = lineParts[2];
        }

        return data;

//        return new Object[][] {
//                {"user", "123", "Invalid email address."},
//                {"", "123", "An email address required."},
//        };
    }

}
