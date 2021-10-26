package com.techpro_testng.pages;

import com.techpro_testng.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefaultPage {
// 1 create constructor

    public DefaultPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

// 2 locate the object
    @FindBy(xpath="//*[contains(text(),'Add User')]")
    public WebElement addUserButton;

    @FindBy(xpath = "//span[contains(text(),'Hotel Management')]")
    public WebElement hotelManagement;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoomsTab;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement userId;

}
