package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day11_FirstConfigTest {
    // lets get URL from the configuration.properties file

    @Test
    public void getUrlFromConfig () {

    String expUrlFromConfig = ConfigReader.getProperty("app_url");
    System.out.println("The url we got from the config.properties is : " + expUrlFromConfig);

        // So lets call the url via the key using also Driver
    Driver.getDriver().get(ConfigReader.getProperty("app_url"));
    String urlFromDriver = Driver.getDriver().getCurrentUrl();
    Assert.assertEquals(urlFromDriver, expUrlFromConfig);
        /* By using classes
      - Driver
      - ConfigReader
      We use dynamic codes instead of hardcoding.
         */

        // Assert the title if it is Caretta Hotel - Home
    String titleFromDriver = Driver.getDriver().getTitle();
    String titleFromConfigReader = ConfigReader.getProperty("app_title");

    Assert.assertEquals(titleFromDriver, titleFromConfigReader);


    }

}
