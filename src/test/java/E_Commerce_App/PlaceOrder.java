package E_Commerce_App;

import Basics.Android.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrder extends BaseTest {
    @Test
    public void longPressOnTerms(){
        ValidateSumAmount.validateSum();

        WebElement termsButton= driver.findElement(
                By.id("com.androidsample.generalstore:id/termsButton"));
        longPress(termsButton);
        String alertTitle= driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle"))
                .getText();
        Assert.assertEquals(alertTitle, "Terms Of Conditions");
        driver.findElement(By.id("android:id/button1")).click();
        WebElement pageTitle = driver.findElement(By.id(
                "com.androidsample.generalstore:id/toolbar_title"));

        Assert.assertEquals(pageTitle.getText(), "Cart");
    }
    @Test
    public static void placeOrder(){
        ValidateSumAmount.validateSum();

        WebElement pageTitle = driver.findElement(By.id(
                "com.androidsample.generalstore:id/toolbar_title"));

        Assert.assertEquals(pageTitle.getText(), "Cart");

        driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"))
                .click();
    }
}
