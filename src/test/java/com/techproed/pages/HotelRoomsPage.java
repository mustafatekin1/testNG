package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelRoomsPage {

    public HotelRoomsPage(){
    PageFactory.initElements(Driver.getDriver(), this);
    }


@FindBy(xpath = "//*[@class='hidden-480']")
public WebElement addHotelRoomButton;

}
