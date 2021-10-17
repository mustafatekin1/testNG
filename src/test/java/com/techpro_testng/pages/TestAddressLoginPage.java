package com.techpro_testng.pages;

import com.techpro_testng.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestAddressLoginPage {
    /*
 We will use this page class for the page objects only
1. Create Contructor
2. Create page objects for the test class/method
  */
// 1. Create Contructor
// initialize page objects to "this" page class

    public TestAddressLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
// 2. Create page objects required for the test class/method
    @FindBy(id="session_email")  // Locate with any of the 8 locators
    public WebElement email;

    @FindBy(id="session_password")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signInButton;

    }




