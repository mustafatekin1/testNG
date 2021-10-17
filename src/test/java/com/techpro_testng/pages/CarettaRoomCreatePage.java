package com.techpro_testng.pages;

import com.techpro_testng.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarettaRoomCreatePage {

    public CarettaRoomCreatePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="IDHotel")
    public WebElement dropDownHotels;

    @FindBy(id="Code")
    public WebElement code;

    @FindBy(id="Name")
    public WebElement name;

    @FindBy(id="Location")
    public WebElement location;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement textarea;

    @FindBy(id="Price")
    public WebElement price;

    @FindBy(xpath = "//li[@data-id='500']")
    public WebElement price500;





}
