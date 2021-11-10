package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomCreatePage {

    public RoomCreatePage(){

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

    @FindBy(id="IDGroupRoomType")
    public WebElement roomTypeDropdown;

    @FindBy(id="MaxAdultCount")
    public WebElement maxAdultCount;

    @FindBy(id="MaxChildCount")
    public WebElement maxChildrenCount;

    @FindBy(id="IsAvailable")
    public WebElement isApprovedCheckbox;

    @FindBy(id="btnSubmit")
    public WebElement saveButton;

    @FindBy(xpath="//div[@class='bootbox-body']")
    public WebElement popupMessage;

    @FindBy(xpath="//button[@data-bb-handler='ok']")
    public WebElement okButton;


    @FindBy(xpath = "//li[@data-id='700']")
    public WebElement price700;
    //LOCATE ALL OBJECTS IN THIS CLASS
    //AND



}
