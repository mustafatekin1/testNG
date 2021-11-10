package com.techproed.tests;

import com.techproed.pages.TestAddressLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class Day12_TestAddressBookWithPOM {
/*
go to http://a.testaddressbook.com/sign_in
 */

    @Test
    public void testAddressSignin() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("testaddress_url"));

// Create the page object from the class we created under pages package for this test
TestAddressLoginPage testAddressLoginPage = new TestAddressLoginPage();
testAddressLoginPage.email.sendKeys(ConfigReader.getProperty("testaddress_email"));
testAddressLoginPage.password.sendKeys(ConfigReader.getProperty("testaddress_password"));// added to config properties
testAddressLoginPage.signInButton.click();

    Thread.sleep(3000);
    Driver.getDriver().close();

    }


}
