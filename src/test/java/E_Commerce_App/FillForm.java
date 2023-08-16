package E_Commerce_App;

import Basics.Android.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FillForm extends BaseTest {
    @Test
    public static void fillForm() {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
                .sendKeys("Omaid");

        driver.hideKeyboard();

        driver.findElement(By.xpath("//android.widget.RadioButton" +
                "[@text='Female']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"))
                .click();

        scrollIntoView("Australia");

        driver.findElement(By.xpath("//android.widget.TextView" +
                "[@text='Australia']")).click();

        driver.findElement(By.id(
                "com.androidsample.generalstore:id/btnLetsShop")).click();

    }

    @Test // toast Message
    public void fillFormNoName() {

        driver.findElement(By.xpath("//android.widget.RadioButton" +
                "[@text='Female']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"))
                .click();

        scrollIntoView("Australia");

        driver.findElement(By.xpath("//android.widget.TextView" +
                "[@text='Australia']")).click();

        driver.findElement(By.id(
                "com.androidsample.generalstore:id/btnLetsShop")).click();

        //toast Message --- always in android.widget.Toast tag
        // their message will be in name attribute

        String toastMessage = driver.findElement
                        (By.xpath("//android.widget.Toast"))
                .getAttribute("name");

        Assert.assertEquals(toastMessage, "Please enter your name");

    }
}
