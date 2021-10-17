package com.techpro_testng.tests;

import com.techpro_testng.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day10_HardAssertion extends TestBase {
/*
Hard assertion: It is the assertion we have learned in JUnit also.
    - The test stops whenever the test fails

Soft Assertion: It comes with TestNG
    - The test continues although some steps fail

 */

    @Test
    public void hardAssert() {
        /*
   When user goes to "https://carettahotels.com"
   then verifies the title is "Caretta Hotel - Home"
   and when clicks on - Caretta Relax Hotel Login
   then verifies the title is "Home - Caretta Beach Hotel"
    */

    driver.get("https://carettahotels.com");
   String homeTitle = driver.getTitle();
    String expectedHomeTitle = "Caratta Hotels |";
    Assert.assertEquals(expectedHomeTitle, homeTitle);

    driver.findElement(By.xpath("(//span[.='Caretta Beach Hotel Login'])[1]")).click();
    String loginTitle = driver.getTitle();
    String expLoginTitle = "Home - Caretta Beach Hotel";
    Assert.assertEquals(expLoginTitle, loginTitle);

    }




}
