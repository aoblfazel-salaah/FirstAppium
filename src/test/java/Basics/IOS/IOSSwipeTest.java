package Basics.IOS;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOSSwipeTest extends IOSBaseTest{
    @Test
    public void swipe(){

        Map<String , String> params= new HashMap<>();
        params.put("bundleId", "com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp",params );

        List < WebElement> allPhotos= driver.findElements
                (By.className("XCUIElementTypeCell"));

        driver.findElement(AppiumBy.iOSClassChain("" +
                "**/XCUIElementTypeCell[`name BEGINSWITH 'Photo'`]"))
                .click();

        Map <String, Object> params1= new HashMap<>();
        params1.put("direction", "left");

        List<String> photoDates=new ArrayList<>();

        for (WebElement photo:allPhotos) {
            String dateAndTimeOfThePhoto=
            driver.findElement(By.className("XCUIElementTypeNavigationBar"))
                    .getAttribute("name");

            photoDates.add(dateAndTimeOfThePhoto);

            Assert.assertTrue(photoDates.contains(dateAndTimeOfThePhoto));

            driver.executeScript("mobile:swipe", params1);
        }
        driver.findElement(AppiumBy.iOSClassChain("" +
                "**/XCUIElementTypeButton[`label == \"All Photos\"`]")).click();
    }
}
