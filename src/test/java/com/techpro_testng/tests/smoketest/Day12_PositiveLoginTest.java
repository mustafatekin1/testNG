package com.techpro_testng.tests.smoketest;

import com.techpro_testng.pages.DefaultPage;
import com.techpro_testng.pages.LoginPage;
import com.techpro_testng.pages.MainPage;
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
        MainPage carettaHotelMainPage = new MainPage();
        LoginPage carettaHotelLoginPage = new LoginPage();

        carettaHotelMainPage.loginButton.click();

        carettaHotelLoginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        carettaHotelLoginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        carettaHotelLoginPage.loginButton.click();

       /*   verify login is successful with any of the following
        -  url
        -  any core element : account name, add user button
        -  title
        */
        DefaultPage carettaHotelDefaultPage = new DefaultPage();
        boolean isAddUserButton = carettaHotelDefaultPage.addUserButton.isDisplayed();
        Assert.assertTrue(isAddUserButton);



    }

}
