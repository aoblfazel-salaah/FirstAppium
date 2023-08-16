package Basics.Android;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPress extends BaseTest{

    @Test
    public void longPressGesture(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget." +
                "TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement peoplesNames=
                driver.findElement(By.xpath(
             "//android.widget.TextView[@text='People Names']"));

        longPress(peoplesNames);

        String menuText= driver.findElement(By.id("android:id/title")).getText();
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
        Assert.assertEquals(menuText, "Sample menu");

    }
}
