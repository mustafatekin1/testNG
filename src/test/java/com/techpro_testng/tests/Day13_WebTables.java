package com.techpro_testng.tests;

import com.techpro_testng.pages.CarettaHotelDefaultPage;
import com.techpro_testng.pages.CarettaHotelLoginPage;
import com.techpro_testng.pages.CarettaHotelMainPage;
import com.techpro_testng.utilities.ConfigReader;
import com.techpro_testng.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class Day13_WebTables {
    /*
    How to write xpath from table elements
TABLE
//table//tbody -> to create table body. returns entire table
//table//tbody//tr -> returns all rows in tbody
//table//tbody//tr[1] -> first row in tbody
//table//tbody//tr[1]//td -> returns all table cells on the first row
//table//tbody//tr[1]//td[4] -> returns 4th cell on the first row in tbody
//table//tbody//tr[4]//td[5] -> 4th row 5th column
//table//tbody//tr[10]//td[2] -> row 10 cell 2

NO tc in web tables. We have tr or td. We use combination of tr and td to fo certain column
//table//tbody//tr//td[5] -> all rows in column 5
     */

/* The task:
 Create a class: WebTables
Create a method: login()
Log in https://www.carettahotel.com/
//Click on Hotel Management
//Click on Hotel Rooms
Create a test method: entireTable() and Find the size of the entire table body and print all of headers
Create a test method: printRows() and Print all of the rows and print the element s on the 4th row
Create a test method: printCells() and a the total number of cells in the table body and print all of the cells
Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 5th column
Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column

  */

    CarettaHotelMainPage carettaHotelMainPage;
    CarettaHotelLoginPage carettaHotelLoginPage;
    CarettaHotelDefaultPage carettaHotelDefaultPage;
@BeforeMethod
public void setup(){
    Driver.getDriver().get(ConfigReader.getProperty("app_url"));
    carettaHotelMainPage = new CarettaHotelMainPage();
    carettaHotelLoginPage = new CarettaHotelLoginPage();
    carettaHotelDefaultPage = new CarettaHotelDefaultPage();

    carettaHotelMainPage.loginButton.click();
    carettaHotelLoginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
    carettaHotelLoginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
    carettaHotelLoginPage.loginButton.click();

    boolean isAddUserDisplayed = carettaHotelDefaultPage.addUserButton.isDisplayed();
    Assert.assertTrue(isAddUserDisplayed);
}

}
