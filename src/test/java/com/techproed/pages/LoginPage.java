package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //1. create constructor
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //2. locate the objects with @FindBy
    @FindBy (id="UserName")
    public WebElement userName;

    @FindBy (xpath="//input[@id='Password']")
    public WebElement password;

    @FindBy (id="btnSubmit")
    public WebElement loginButton;

    @FindBy(id="divMessageResult")
    public WebElement errorMessage;

    @FindBy(id="details-button")
    public WebElement advanced;

    @FindBy(id="proceed-link")
    public WebElement proceedLink;

}
