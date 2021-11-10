package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    // Create constructor

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Create page objects (elements)
@FindBy(linkText = "Log in")
  public WebElement loginButton;



}
