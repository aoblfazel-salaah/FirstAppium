package Basics.Android;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeDemo extends BaseTest{

    @Test
    public void swipeDemo(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath(
                "//android.widget.TextView[@text='1. Photos']")).click();
        WebElement firstImage= driver.findElement(By.xpath("//android.widget.ImageView"));
        Assert.assertEquals(firstImage.getAttribute("focusable"),"true");

        //swipe
        swipe(firstImage, "left");

        Assert.assertEquals(firstImage.getAttribute("focusable"),"false");
    }
}
