package com.techpro_testng.tests.smoketest;

import com.techpro_testng.pages.CarettaHotelDefaultPage;
import com.techpro_testng.pages.CarettaHotelLoginPage;
import com.techpro_testng.pages.CarettaHotelMainPage;
import com.techpro_testng.utilities.ConfigReader;
import com.techpro_testng.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day12_PositiveLoginTest {
/* Do the following task by using pages and config.properties ...
go to the url https://www.carettahotel.com/
click login
enter credentials
then log in
verify login is successful
(Happy Path)
 */




    @Test
    public void positiveLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        // We need to create objects from the relevanr page classes
        CarettaHotelMainPage carettaHotelMainPage = new CarettaHotelMainPage();
        CarettaHotelLoginPage carettaHotelLoginPage = new CarettaHotelLoginPage();

        carettaHotelMainPage.loginButton.click();

        carettaHotelLoginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        carettaHotelLoginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        carettaHotelLoginPage.loginButton.click();

       /*   verify login is successful with any of the following
        -  url
        -  any core element : account name, add user button
        -  title
        */
        CarettaHotelDefaultPage carettaHotelDefaultPage = new CarettaHotelDefaultPage();
        boolean isAddUserButton = carettaHotelDefaultPage.addUserButton.isDisplayed();
        Assert.assertTrue(isAddUserButton);



    }

}
