package com.techpro_testng.dataprovider;

import com.techpro_testng.pages.DefaultPage;
import com.techpro_testng.pages.LoginPage;
import com.techpro_testng.utilities.ConfigReader;
import com.techpro_testng.utilities.Driver;
import com.techpro_testng.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {
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

        String managerProfile[][] = {
                {"manager","Manager1!"},
                {"manager2","Manager2!"},
                {"manager3","Manager3!"}};
        // we can use either String(if data is String) or Object
        return managerProfile;
    }
    DefaultPage DefaultPage;
    @Test(dataProvider = "getData")
    public void managerLoginTest(String managerId, String managerPass){
        setUp();
        loginPage.userName.sendKeys(managerId);
        loginPage.password.sendKeys(managerPass);
        loginPage.loginButton.click();

        DefaultPage = new DefaultPage();
        Assert.assertTrue(DefaultPage.userId.isDisplayed());

    }

    @AfterMethod
    public void tearDown() {
    Driver.closeDriver();

    }
}
