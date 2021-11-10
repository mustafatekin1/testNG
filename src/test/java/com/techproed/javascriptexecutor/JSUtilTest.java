package com.techproed.javascriptexecutor;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSUtils;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class JSUtilTest {

    @Test
    public void scrollIntoView() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement recentBlog = Driver.getDriver().findElement(By.xpath("//*[.='Recent Blog']"));

        JSUtils.scrollIntoViewJS(recentBlog);
       // Thread.sleep(5000);
        // Instead we can call the hard or explicit waits from the ReusableMethods class
        ReusableMethods.waitFor(2);//hard wait from reusable methods
        // we need the wait because we have to wait after scrolling so that the text is displayed
        Assert.assertEquals(recentBlog.getText(), "Recent Blog");

    }

    @Test
    public void clickWithJS(){
    Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        // javascript executer click is stronger and it may be better to use
    WebElement checkAvailability = Driver.getDriver().
            findElement(By.xpath("//input[@value='Check Availability']"));
    JSUtils.clickElementByJS(checkAvailability);
    }

    @Test
    public void flashJS() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement checkAvailability = Driver.getDriver().
                findElement(By.xpath("//input[@value='Check Availability']"));
        JSUtils.flash(checkAvailability);

    }

    @Test
    public void changeColorJS() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement checkAvailability = Driver.getDriver().
                findElement(By.xpath("//input[@value='Check Availability']"));
        JSUtils.changeColor("red",checkAvailability);

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}
