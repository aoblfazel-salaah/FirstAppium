package Basics.Android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Miscellaneous extends BaseTest{

    @Test
    public void misc() throws InterruptedException {

        driver.findElement(By.id("android:id/checkbox")).click();

        DeviceRotation landscape= new DeviceRotation(0,0,90);
        driver.rotate(landscape);

        Thread.sleep(1000);
        driver.findElement(By.xpath(
                "(//android.widget.RelativeLayout)[2]"))
                .click();
        Thread.sleep(1000);

        String title= driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(title, "WiFi settings");

        driver.setClipboardText("Omaid");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());

        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("mobile: clickGesture",
                ImmutableMap.of("x", 1250, "y", 150)
        );

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
