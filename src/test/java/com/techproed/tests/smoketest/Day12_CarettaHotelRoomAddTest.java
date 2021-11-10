package com.techproed.tests.smoketest;

import com.github.javafaker.Faker;
import com.techproed.pages.*;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    MainPage carettaHotelMainPage;
    LoginPage carettaHotelLoginPage;
    DefaultPage carettaHotelDefaultPage;
    HotelRoomsPage carettaHotelRoomsPage;
    RoomCreatePage carettaRoomCreatePage;

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        carettaHotelMainPage = new MainPage();
        carettaHotelLoginPage = new LoginPage();
        carettaHotelDefaultPage = new DefaultPage();

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

        carettaHotelRoomsPage = new HotelRoomsPage();
        carettaHotelRoomsPage.addHotelRoomButton.click();

    // we are on the create room page
     carettaRoomCreatePage = new RoomCreatePage();
     // fist one is dropdown=> we handle that with Select object:
        Select select = new Select(carettaRoomCreatePage.dropDownHotels);
        select.selectByVisibleText("Star Hotel");

        carettaRoomCreatePage.code.sendKeys("4001");
        carettaRoomCreatePage.name.sendKeys("name is a name");

        //we can add data via JavaFaker object also
        Faker faker = new Faker();
        carettaRoomCreatePage.location.sendKeys(faker.address().city());
        carettaRoomCreatePage.textarea.sendKeys(faker.shakespeare().hamletQuote());

        carettaRoomCreatePage.price.sendKeys(faker.number().digits(3));
        Thread.sleep(3000);
        // drag and drop option for the price -- 500
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(carettaRoomCreatePage.price500, carettaRoomCreatePage.price).perform();
        Thread.sleep(3000);

        //Room Type
        Select roomTypeDropdown = new Select(carettaRoomCreatePage.roomTypeDropdown);
        roomTypeDropdown.selectByVisibleText("Studio");

        //Adult
        carettaRoomCreatePage.maxAdultCount.sendKeys(faker.number().digit());

        //Child
        carettaRoomCreatePage.maxChildrenCount.sendKeys(faker.number().digits(1));

        //approved
        carettaRoomCreatePage.isApprovedCheckbox.click();

        //save
        carettaRoomCreatePage.saveButton.click();


        //ASSERTION FAILS CAUSE WINDOW POP UP TAKES SOME TIME TO OPEN-less than a sec
        //synchronization ISSUE

        //WAY 1- Thread.sleep(1000)- not recommended
        //WAY 2- Explicit Wait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        WebElement popupElement = wait.until(ExpectedConditions.visibilityOf(carettaRoomCreatePage.popupMessage));

        //Verify the message: HotelRoom was inserted successfully
        //Asserting message
        Assert.assertEquals(popupElement.getText(),"HotelRoom was inserted successfully");
Thread.sleep(3000);
        //Click OK
        carettaRoomCreatePage.okButton.click();

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        Driver.closeDriver();
    }


}
