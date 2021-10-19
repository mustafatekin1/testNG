package com.techpro_testng.pages;

import com.techpro_testng.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarettaTablePage {

    public CarettaTablePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

   @FindBy(xpath = "//table//tbody")
    public WebElement tableBody;


}
