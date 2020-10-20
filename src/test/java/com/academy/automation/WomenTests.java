package com.academy.automation;

import com.academy.automation.page.WomenPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WomenTests extends BaseTest {
    @Test
   public void testWomenPage (){
        WomenPage womenPage = new WomenPage(driver);
        womenPage.goToWomen();
        womenPage.getMenuPage().clickByAdminItem();
        Assert.assertEquals(womenPage.getWomenHeader().trim(),"WOMEN");
    }
}
