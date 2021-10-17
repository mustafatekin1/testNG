package com.techpro_testng.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
//singleton selenium driver pattern - popular
// It is the most important class for Page Object Model design pattern. POM is recommended.
// We do not use TestBase in the Page Object Model. Instead we use this Driver Class.
// We call it with the Driver.getDriver() method from the Driver class. We don't have to extend any classes.
    // from now on our "driver." becomes ==>>>> Driver.getDriver().
    private static WebDriver driver;
    public static WebDriver getDriver(){

        if(driver==null) { // if driver is not pointing anywhere instantiate the driver
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

    // we do not see  the browser. It runs in the background without visually displayed on the screen
                case "chrome-headless" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari": // I need to install this also!!!
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
            }




        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }


    public static void closeDriver (){

        if(driver!=null) { // if driver is not null (if it was initiated) then close

            driver.quit();

            driver = null;
            // we make it null so that we can initiate(instantiate) the driver with the upper method (getDriver());

        }

    }

}
