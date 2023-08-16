package Basics.IOS;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class IOSLongpress extends IOSBaseTest{

    @Test
    public void IOSLongPress(){
        driver.findElement(AppiumBy.iOSClassChain(
       "**/XCUIElementTypeStaticText[`label == \"Steppers\"`]"))
                .click();

        WebElement incrementButton =driver.findElement(AppiumBy.iOSClassChain(
     "**/XCUIElementTypeButton[`label == \"Increment\"`][3]"));

        Map<String , Object> params= new HashMap<>();
        params.put("element", ((RemoteWebElement) incrementButton).getId());
        params.put("duration", 5);

        driver.executeScript("mobile:touchAndHold", params);
    }
}
