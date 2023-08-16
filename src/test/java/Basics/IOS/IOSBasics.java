package Basics.IOS;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest{

    @Test
    public void IOSBasicsTest(){

        // xpath, classname, IOS, iosClassChain , IOSPredicateString, acc id, id

        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();

        driver.findElement(AppiumBy.iOSClassChain(
       "**/XCUIElementTypeStaticText[`name == 'Text Entry'`]"))
                .click();

        driver.findElement(By.className("XCUIElementTypeTextField"))
                .sendKeys("Omaid");

        driver.findElement(AppiumBy.iOSClassChain(
                "**/XCUIElementTypeButton[`label == \"OK\"`]"))
                .click();

        driver.findElement(AppiumBy.iOSNsPredicateString(
                "type == 'XCUIElementTypeStaticText' AND" +
                        " value BEGINSWITH[c] 'Confirm'")).click();
                //              also ENDSWITH available, c means not case-sensitive

        System.out.println(
                driver.findElement(AppiumBy.iOSNsPredicateString("label " +
                "BEGINSWITH 'A message'")).getText());

        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'"));

    }
}
