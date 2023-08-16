package E_Commerce_App;

import Basics.Android.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCart extends BaseTest {
    @Test
    public void addToCart() {
        FillForm.fillForm();

        scrollIntoView("Jordan 6 Rings");
        driver.findElement(By.xpath("//android.widget.TextView" +
                "[@text='Jordan 6 Rings']//following-sibling::android.widget.LinearLayout[2]" +
                "//android.widget.TextView[@text='ADD TO CART']")).click();

    }
    @Test
    public void checkCart(){
        addToCart();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"))
                .click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement pageTitle = driver.findElement(By.id(
                "com.androidsample.generalstore:id/toolbar_title"));
        wait.until(ExpectedConditions.attributeToBe(pageTitle,
                "text", "Cart"));

        String productInCart= driver.findElement(By.id
         ("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(productInCart, "Jordan 6 Rings");
    }
}
