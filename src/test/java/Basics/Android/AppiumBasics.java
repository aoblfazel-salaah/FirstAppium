package Basics.Android;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseTest {
    @Test
    public void WifiSettingsName() {

        //Locators
        // Xpath, Accessibility ID, classname, androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget." +
                "TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]"))
                .click();
        String title= driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(title, "WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Omaid");
        driver.findElements(AppiumBy.className("android.widget.Button"))
                .get(1).click();
        
    }
    @Test
    public void WifiSettingsNameLandscape() throws InterruptedException {

        //Locators
        // Xpath, Accessibility ID, classname, androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget." +
                "TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();

        DeviceRotation landscape= new DeviceRotation(0,0,90);
        driver.rotate(landscape);

        Thread.sleep(1000);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]"))
                .click();
        String title= driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(title, "WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Omaid");
        driver.findElements(AppiumBy.className("android.widget.Button"))
                .get(1).click();

    }
}
