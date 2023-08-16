package Basics.Android;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropDemo extends BaseTest{
    @Test
    public void dragAndDropDemo(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement firstCircle= driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        dragAndDrop(firstCircle,830,805);

        WebElement droppedMessage= driver.findElement(
                By.id("io.appium.android.apis:id/drag_result_text"));
        Assert.assertTrue(droppedMessage.isDisplayed());
        Assert.assertEquals(droppedMessage.getText(),"Dropped!");
    }
}
