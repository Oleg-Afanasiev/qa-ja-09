package com.academy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.nodes.ScalarNode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    @Test
    @Ignore
    public void testLoginErrorCase2() {

    }

    @Test
    @Ignore
    public void testLoginSuccess() {
    }

    @DataProvider(name = "loginErrorData")
    public Object[][] loginErrorDataProvider() throws FileNotFoundException {
        String path = "D:/programming/teaching/qa-09-maven/test-data/login-tests.csv";
        Scanner scanner = new Scanner(new FileInputStream(path), StandardCharsets.UTF_8);
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
