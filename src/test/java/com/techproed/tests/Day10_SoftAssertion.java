package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day10_SoftAssertion extends TestBase {
    /*
Hard assertion: It is the assertion we have learned in JUnit also.
    - The test stops whenever the test fails
    - Hard assertion is More common

Soft Assertion: It comes with TestNG
    - The test continues although some steps fail
    Steps:
    - We create a SoftAssert object
    - Assert
    - then type: softAssertObject.assertAll();
 */

    @Test
    public void SoftAssert() {
        /*
   When user goes to "https://carettahotel.com" // the website is different than the Day10_HardAssertion!!!
   then verifies the title is "Caretta Hotel - Home"
   and when clicks on login button
   then verifies the title is "Caretta Hotel - Login"
    */

        driver.get("https://carettahotel.com");
        String homeTitle = driver.getTitle();
        String expHomeTitle = "Caretta Hotel - Home";


        SoftAssert soft1 = new SoftAssert();
        soft1.assertEquals(homeTitle, expHomeTitle);
        //note that in TestNG (first actual, second expected) unlike JUnit (it was (exp, actual) in JUnit)

        driver.findElement(By.xpath("//a[.='Log in']")).click();
        String loginTitle = driver.getTitle();
        String expLoginTitle = "Caretta Hotel - Log in";

        soft1.assertEquals(loginTitle, expLoginTitle);

        // The most important step is the following
        soft1.assertAll(); // This is a must. If we do not type this, test is not done but gives Green!!!

    }
}
