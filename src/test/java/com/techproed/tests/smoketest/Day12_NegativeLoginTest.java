package com.techproed.tests.smoketest;

import com.techproed.pages.LoginPage;
import com.techproed.pages.MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day12_NegativeLoginTest {
    /* Do the following task by using pages and config.properties ...
go to the url https://www.carettahotel.com/
click login
enter incorrect credentials
then log in
verify login is not successful
(Negative Scenarios)
we have 3 negative scenarios

 */

    @Test
    public void invalidPassword() throws InterruptedException {
       Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        MainPage carettaHotelMainPage = new MainPage();
        carettaHotelMainPage.loginButton.click();

        LoginPage carettaHotelLoginPage = new LoginPage();
        carettaHotelLoginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        //carettaHotelLoginPage.password.sendKeys("Test");
        carettaHotelLoginPage.password.sendKeys(ConfigReader.getProperty("wrong_manager_password"));

        carettaHotelLoginPage.loginButton.click();

        // verify you are not logged in
        // verify error message includes "Wrong password"

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Wrong password"));
        // or the following is better
        Assert.assertTrue(carettaHotelLoginPage.errorMessage.getText().contains("Wrong password"));

        Thread.sleep(3000);
        Driver.getDriver().close();
    }

    @Test
    public void invalidId (){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        MainPage carettaHotelMainPage = new MainPage();
        LoginPage carettaHotelLoginPage = new LoginPage();

        carettaHotelMainPage.loginButton.click();
        //carettaHotelLoginPage.userName.sendKeys("wrong");
        carettaHotelLoginPage.userName.sendKeys(ConfigReader.getProperty("wrong_manager_username"));
        carettaHotelLoginPage.password.sendKeys(ConfigReader.getProperty("wrong_manager_password"));

        carettaHotelLoginPage.loginButton.click();

//Assert.assertTrue(carettaHotelLoginPage.errorMessage.getText().contains("Try again please")); this does not work
        // seperately assign a container for the error message:
        String errorMessage = carettaHotelLoginPage.errorMessage.getText();
        Assert.assertTrue(errorMessage.contains("Try again"));

        Driver.closeDriver();
    }

    @Test
    public void invalidPasswordAndId (){

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        MainPage carettaHotelMainPage= new MainPage();
        LoginPage carettaHotelLoginPage = new LoginPage();

        carettaHotelMainPage.loginButton.click();

        carettaHotelLoginPage.userName.sendKeys("wrong id");
        carettaHotelLoginPage.password.sendKeys("wrong password");
        carettaHotelLoginPage.loginButton.click();

        String errorMessage = carettaHotelLoginPage.errorMessage.getText();
        System.out.println(errorMessage);
        Assert.assertTrue(errorMessage.contains("Try again"));

   Driver.closeDriver(); }

}
