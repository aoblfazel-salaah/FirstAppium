package Basics.IOS;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class IOSScrollTest extends IOSBaseTest{
    @Test
    public void IOSScroll() throws InterruptedException {
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Web View"));
        Map<String , Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement)element).getId());
        driver.executeScript("mobile:scroll", params);
        element.click();

        driver.findElement(
        By.xpath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]"))
                .click();

        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();

        driver.findElement(AppiumBy.accessibilityId("Red color component value"))
                .sendKeys("80");

        driver.findElement(AppiumBy.accessibilityId("Green color component value"))
                .sendKeys("220");

        WebElement bluePicker =
       driver.findElement(AppiumBy.accessibilityId("Blue color component value"));
        bluePicker.sendKeys("105");

        Assert.assertEquals(bluePicker.getText(), "105");

    }
}
