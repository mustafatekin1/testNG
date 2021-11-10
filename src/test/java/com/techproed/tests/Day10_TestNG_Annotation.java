package com.techproed.tests;

import org.testng.annotations.*;

public class Day10_TestNG_Annotation {
    /*
There are many before/after methods in TestNG

- BeforeSuite / AfterSuite: entire framework
- BeforeTest : before all tests in the framework
- BeforeGroups: before test groups
- BeforeClass : before the class
- BeforeMethod: before the test method same as BEFORE in JUNIT

- @Ignore // skips this method
- (enabled = false) // this parameter also skips the method the same as @ignore annotation. 
We can add priority of the test methods.
If we do not prioritize, they are in alphabetical order.


     */
    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod() {

        System.out.println("After Method");
    }

    @BeforeClass
    public void beforeClass() {

        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass() {

        System.out.println("After Class");
    }

    @Ignore // skips this method
    @Test
    public void test1() {

        System.out.println("Test 1");
    }

    @Test(enabled = false) // this parameter also skips the method the same as @ignore annotation.
    public void test4() {

        System.out.println("Test 4");
    }

    @Test (groups = "regression-group-1")// Since I dont assign a priority this runs first
    public void test2() {

        System.out.println("Test 2");
    }

    @Test (priority = 2, groups = "regression-group-1")
    public void test3() {

        System.out.println("Test 3");
    }
    @Test (priority = 1)
    public void testA() {

        System.out.println("Test A");
    }

}
