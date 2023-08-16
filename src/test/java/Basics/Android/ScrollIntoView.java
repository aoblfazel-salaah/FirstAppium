package Basics.Android;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollIntoView extends BaseTest{

    @Test
    public void scrollIntoView(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scrollIntoView("WebView");
    }
}
