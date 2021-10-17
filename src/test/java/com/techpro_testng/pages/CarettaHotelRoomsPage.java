package com.techpro_testng.pages;

import com.techpro_testng.utilities.ConfigReader;
import com.techpro_testng.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CarettaHotelRoomsPage {

    public CarettaHotelRoomsPage(){
    PageFactory.initElements(Driver.getDriver(), this);
    }


@FindBy(xpath = "//*[@class='hidden-480']")
public WebElement addHotelRoomButton;

}
