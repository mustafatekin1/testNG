package com.techproed.excelautomation;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day15_LoginSmokeTest {
    //  excelUtil objects
    ExcelUtil excelUtil;

    List<Map<String, String>> testData;// list of map of strings!!!

    LoginPage carettaHotelLoginPage;
    DefaultPage carettaHotelDefaultPage;


    public void setUp(){

        Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        carettaHotelLoginPage = new LoginPage();
        carettaHotelDefaultPage = new DefaultPage();

        try {
            carettaHotelLoginPage.advanced.click();
            carettaHotelLoginPage.proceedLink.click();
        } catch (Exception e) {
            System.out.println("There is no advanced link and proceed link");

        }
        // There appears error when the following if block is executed.
        // So we put thm in a try{} catch(){} block as above
//        if (carettaHotelLoginPage.advanced.isDisplayed()) {
//            carettaHotelLoginPage.advanced.click();
//            carettaHotelLoginPage.proceedLink.click();
//        }



    }


    @Test
    public void adminLoginTest(){
        String path = "src/test/java/resources/smoketestdata.xlsx";
        String sheet = "admin_login_info";
        ExcelUtil excelUtil = new ExcelUtil(path, sheet);
        testData = excelUtil.getDataList();
        System.out.println(testData);

        for(Map<String, String> eachData: testData) {//eachData is each map data in the testData
            setUp();// we call "setup()" so that we can login wor each map data eachData
            carettaHotelLoginPage.userName.sendKeys(eachData.get("username"));
            carettaHotelLoginPage.password.sendKeys(eachData.get("password"));
            carettaHotelLoginPage.loginButton.click();

        }

//we did The following before the above to test the login
//        setUp();
//    carettaHotelLoginPage.userName.sendKeys("manager");
//    carettaHotelLoginPage.password.sendKeys("Manager1!");
//    carettaHotelLoginPage.loginButton.click();
    // we have logged in so far.

    }
    @Test
    public void managerLoginTest(){
    String path = "src/test/java/resources/smoketestdata.xlsx";
    String sheet = "manager_login_info";
    excelUtil = new ExcelUtil(path, sheet);
    testData = excelUtil.getDataList();

    for(Map<String, String> eachData : testData) {
        setUp();
        carettaHotelLoginPage.userName.sendKeys(eachData.get("username"));
        carettaHotelLoginPage.password.sendKeys(eachData.get("password"));
        carettaHotelLoginPage.loginButton.click();


    }


    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
