package com.academy.automation;

import com.academy.automation.page.WomenPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class WomenTests extends BaseTest {
    @Test
   public void testWomenPage (){
        WomenPage womenPage = new WomenPage(driver);
        womenPage.goToWomen();
        Assert.assertEquals(womenPage.getWomenHeader().trim(),"WOMEN");
    }
}
