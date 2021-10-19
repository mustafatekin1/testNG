package com.techpro_testng.tests;

import com.techpro_testng.pages.*;
import com.techpro_testng.utilities.ConfigReader;
import com.techpro_testng.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

//table//tbody//tr[1]//td -> returns all table cells on the row 1
//table//tbody//tr//td[2] -> returns all table cells in column 2

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
    CarettaHotelRoomsPage carettaHotelRoomsPage;

    CarettaTablePage carettaTablePage;
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
    Assert.assertTrue(isAddUserDisplayed); // we verified that we logged in

    carettaHotelDefaultPage.hotelManagement.click(); // we navigate to Hotel Rooms
    carettaHotelDefaultPage.hotelRoomsTab.click();

    carettaHotelRoomsPage = new CarettaHotelRoomsPage();
}
    @Test
    public void entireTable() throws InterruptedException {
//Task1: Print the entire table body - ilk 2 denemede yazdiramadim!!! ilginctir 3. denemede yazdirdim.
        // And print table headers (thead)
        System.out.println("*entire table*");
        System.out.println("*Table body*");

        carettaTablePage = new CarettaTablePage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        Thread.sleep(3000);// exp wait kurtarmadi!!!
        WebElement tableBody = wait.until(ExpectedConditions.visibilityOf(carettaTablePage.tableBody));
        //WebElement tableBody = Driver.getDriver().findElement(By.xpath("//table//tbody"));
        System.out.println("This is the table body" + tableBody.getText());

        WebElement row2C3 = Driver.getDriver().findElement(By.xpath("//table//tbody//tr[2]//td[3]"));
        System.out.println("1st try: " + row2C3.getText());

        String row2C3Text = row2C3.getText();
        System.out.println("2nd try: " + row2C3Text);

        // task 1-b : print headers

        WebElement headers = Driver.getDriver().findElement(By.xpath("//th"));
        System.out.println("headers yazar mi ? : " + headers.getText());
        System.out.println();
        List<WebElement> headersList = Driver.getDriver().findElements(By.xpath("//th"));
        for (WebElement eachHeader : headersList) {
            System.out.print(eachHeader.getText() + "--");
        }
    }
    @Test
    public void printRows(){
  // Task2 a - print all of the rows and print the size
        System.out.println("Lets Print Rows");
      List <WebElement> listOfRows = Driver.getDriver().findElements(By.xpath("//table//tbody//tr"));
      int i=1;
      for(WebElement eachRow: listOfRows) {
          System.out.println("row number "+ i +" ==>" + eachRow.getText());
          i++;
      }
        System.out.println("The number of rows are " + listOfRows.size() + " or equals (i-1) ==>" + (i-1) );

        // 2b  print the elements on the 4th row.
    //1st way
        WebElement row4 = Driver.getDriver().findElement(By.xpath("//table//tbody//tr[4]"));
        System.out.println("1st way ==>" + row4.getText());
     // 2nd way - I tried. I get the same results
      List <WebElement> row4thCells = Driver.getDriver().findElements(By.xpath("//table//tbody//tr[4]"));
      int k=1;
      for (WebElement each4thCell : row4thCells) {
          System.out.println("2nd way " + k + " ==>" + each4thCell.getText());
          k++;
      }
    }

    @Test
    public void printCells() {
    // Task 3 : print all of the cells and the number of total cells.
    List  <WebElement> listOfCells = Driver.getDriver().findElements(By.xpath("//table//tbody//td"));
      int i=0;
      for (WebElement eachCell: listOfCells) {
          i++;
          System.out.println("Cell " + i + " ==> " + eachCell.getText());

      }
        System.out.println("Number of cells in the table is " + listOfCells.size());

    }
    @Test
    public void printColumns() {
        //Task 4: print the number of total columns ans print the 5th column
        // number of "th" equals to the number of columns
 List <WebElement> listOfColumns=Driver.getDriver().findElements(By.xpath("//th"));
        System.out.println("Number of columns is " + listOfColumns.size());
// 4b. print the 5th column
       List<WebElement> cellsOfColumn5 = Driver.getDriver().findElements(By.xpath("//table//tbody//tr//td[5]"));
       int i =0;
       for(WebElement eachCell:cellsOfColumn5) {
           i++;
           System.out.println("Column 5 - Cell " + i + " ==> " + eachCell.getText());
       }

    }

//    @Test
//    public void printRowColumn(int row, int column) {
//        // print the only cell specified in the method parameters.
//    WebElement specificCell = Driver.getDriver().findElement(By.xpath("//table//tbody//tr[row]//td[column]//"));
//        System.out.println("Row "+row + " Column " + column +" refers to ==> " +specificCell.getText());
//    }


    @AfterMethod
    public void teardown(){
    Driver.closeDriver();
    }

    }


