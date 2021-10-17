package com.techpro_testng.tests.smoketest;

import com.github.javafaker.Faker;
import com.techpro_testng.pages.*;
import com.techpro_testng.utilities.ConfigReader;
import com.techpro_testng.utilities.Driver;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Day12_CarettaHotelRoomAddTest {
    /*
    go to the url https://www.carettahotel.com/
    login
    Hotel Management>>Hotel List
    Add Hotel Room
    Fill in all the data
    Add the hotel room successfully.
    Verify the success message

     */

    //declare the objects in the class level

    CarettaHotelMainPage carettaHotelMainPage;
    CarettaHotelLoginPage carettaHotelLoginPage;
    CarettaHotelDefaultPage carettaHotelDefaultPage;
    CarettaHotelRoomsPage carettaHotelRoomsPage;
    CarettaRoomCreatePage carettaRoomCreatePage;

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        carettaHotelMainPage = new CarettaHotelMainPage();
        carettaHotelLoginPage = new CarettaHotelLoginPage();
        carettaHotelDefaultPage = new CarettaHotelDefaultPage();

        carettaHotelMainPage.loginButton.click();
        carettaHotelLoginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        carettaHotelLoginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        carettaHotelLoginPage.loginButton.click();

        boolean isAddUserDisplayed = carettaHotelDefaultPage.addUserButton.isDisplayed();
        Assert.assertTrue(isAddUserDisplayed);
    }

    @Test
    public void addHotelRoom() throws InterruptedException {
        carettaHotelDefaultPage.hotelManagement.click();
        carettaHotelDefaultPage.hotelRoomsTab.click();

        carettaHotelRoomsPage = new CarettaHotelRoomsPage();
        carettaHotelRoomsPage.addHotelRoomButton.click();

    // we are on the create room page
     carettaRoomCreatePage = new CarettaRoomCreatePage();
     // fist one is dropdown=> we handle that with Select object:
        Select select = new Select(carettaRoomCreatePage.dropDownHotels);
        select.selectByVisibleText("Star Hotel");

        carettaRoomCreatePage.code.sendKeys("4001");
        carettaRoomCreatePage.name.sendKeys("name is a name");

        //we can add data via JavaFaker object also
        Faker faker = new Faker();
        carettaRoomCreatePage.location.sendKeys(faker.address().city());
        carettaRoomCreatePage.textarea.sendKeys(faker.shakespeare().hamletQuote());

        //carettaRoomCreatePage.price.sendKeys(faker.number().digits(3));
        Thread.sleep(3000);
        // drag and drop option for the price -- 500
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(carettaRoomCreatePage.price500, carettaRoomCreatePage.price).perform();
        Thread.sleep(3000);





    }

    @AfterMethod
    public void teardown(){
    Driver.closeDriver();
    }


}
