package com.techpro_testng.tests;

import com.techpro_testng.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day11_FirstDriverTest {
/*
   When user goes to "https://www.amazon.com"
   then verifies the title is "Amazon.com. Spend less. Smile more."
   and verifies the title contains "Amazon"
    */
    @Test
    public void amazonTitle() {

        Driver.getDriver().get("https://www.amazon.com");
        String amazonTitle = Driver.getDriver().getTitle();
        String expAmazonTitle = "Amazon.com. Spend less. Smile more.";

        Assert.assertEquals(amazonTitle, expAmazonTitle);
        Assert.assertTrue(amazonTitle.contains("Amazon"));



    }
}
