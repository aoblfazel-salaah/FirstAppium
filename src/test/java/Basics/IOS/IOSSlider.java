package Basics.IOS;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSSlider extends IOSBaseTest{

    @Test
    public void slider(){
        driver.findElement(AppiumBy.accessibilityId("Sliders")).click();
        WebElement slider1= driver.findElement(By.xpath(
                "//XCUIElementTypeApplication[@name=" +
                        "'UIKitCatalog']/XCUIElementTypeWindow/" +
                        "XCUIElementTypeOther/XCUIElementTypeOther/" +
                        "XCUIElementTypeOther/XCUIElementTypeOther/" +
                        "XCUIElementTypeOther/XCUIElementTypeOther/" +
                        "XCUIElementTypeOther/XCUIElementTypeTable/" +
                        "XCUIElementTypeCell[1]/XCUIElementTypeSlider"));
        slider1.sendKeys("0.9");
        slider1.sendKeys("0");
        slider1.sendKeys("0.5");
        Assert.assertEquals(slider1.getAttribute("value"),"52%");
    }
}
