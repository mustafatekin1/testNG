package com.techpro_testng.dataprovider;

import com.techpro_testng.utilities.ConfigReader;
import com.techpro_testng.utilities.Driver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ObjectInputFilter;

public class DataProvider2 {
    //task: Test the login functionality with manager credentials

    @DataProvider
    public Object[][] getData(){

        String managerProfile[][] = {
                {"manager","Manager1!"},
                {"manager2","Manager2!"},
                {"manager3","Manager3!"}};
        // we can use either String(if data is String) or Object
        return managerProfile;
    }
    @Test(dataProvider = "getData")
    public void managerLoginTest(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

    }

}
