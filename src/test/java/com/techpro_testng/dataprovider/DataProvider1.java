package com.techpro_testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {

    // Test Data:
//                manager	Manager1!
//                manager2	Manager2!
//                manager3	Manager3!

// Data provider is to get multiple data as ExcelUtil.
// We can only have this in TestNG framework
// Return type of the method is 2d Array==>  [][]
    @DataProvider
    public Object[][] getData(){



       //1st way to add data. this is longer
//  Object managerProfile[][] = new Object[3][2];
    // first one is row (outer), second one is column (inner);
        //1st row:
//        managerProfile[0][0] = "manager";
//        managerProfile[0][1] = "Manager1!";
//
//        //2nd row:
//        managerProfile[1][0] = "manager2";
//        managerProfile[1][1] = "Manager2!";
//
//        //3rd row:
//        managerProfile[2][0] = "manager3";
//        managerProfile[2][1] = "Manager3!";

    //2nd way to add data; easier
    String managerProfile[][] = {{"manager","Manager1!"},{"manager2","Manager2!"},
    {"manager3","Manager3!"}};// we can use either String(if data is String) or Object

        return managerProfile;
    }
    @Test(dataProvider = "getData")
    public void managerInfo(String userName, String password){
        System.out.println(userName +"---"+ password);
    }

}
