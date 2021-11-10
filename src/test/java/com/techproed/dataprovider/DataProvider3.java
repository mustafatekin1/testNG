package com.techproed.dataprovider;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import com.techproed.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider3 {
    // we will get the data from excel.
    // The only difference from DataProvider2 is not storing/creating a data inside the class
    //Instead we will call from the excel with DataProvider
    /*
    It will be the best usage for using multiple data in our test cases:
    - We store the test data in excel file
    - Call it from our DataProvider class and use it
        -- It will be easier to get data from excel with DataProvider
        -- It will be faster
     */

    //task: Test the login functionality with manager credentials
    // first lets create a setup method to be able to use during login
    LoginPage loginPage;
    public void setUp() {
    loginPage = new LoginPage();
    Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        try{
        ReusableMethods.waitFor(1);
        loginPage.advanced.click();
        loginPage.proceedLink.click();}
        catch(Exception e){
        System.out.println("Advanced link and proceed link is not displayed");
         }
    }


    @DataProvider
    public Object[][] getData(){

//        String managerProfile[][] = {
//                {"manager","Manager1!"},
//                {"manager2","Manager2!"},
//                {"manager3","Manager3!"}};
        // we can use either String(if data is String) or Object

        // The following is the most used to get data
        // We make the code more dynamic (get rid of hard codes) by:
        // Calling from ExcelUtil and using that data with @DataProvider
        // Note: DataProvider is in TestNG. We have to use ExcelUtil with a loop to get data

    String path = "src/test/java/resources/smoketestdata.xlsx";
    String sheet = "manager_login_info";
    ExcelUtil excelUtil = new ExcelUtil(path, sheet);
    Object managerProfile[][] = excelUtil.getDataArrayWithoutFirstRow();

        return managerProfile;
    }
    com.techproed.pages.DefaultPage DefaultPage;
    @Test(dataProvider = "getData")
    public void managerLoginTest(String managerId, String managerPass){
        setUp();
        loginPage.userName.sendKeys(managerId);
        loginPage.password.sendKeys(managerPass);
        loginPage.loginButton.click();

        DefaultPage = new DefaultPage();

        ReusableMethods.waitFor(1); // In order to be sure the below assertion is displayed
        Assert.assertTrue(DefaultPage.userId.isDisplayed());

    }

    @AfterMethod
    public void tearDown() {
    //    Driver.closeDriver();

    }


}
