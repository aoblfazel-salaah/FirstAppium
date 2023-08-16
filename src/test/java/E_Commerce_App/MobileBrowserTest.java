package E_Commerce_App;

import Basics.Android.BrowserBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {

    @Test
    public void browserTest() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(
                By.xpath("//span[@class='navbar-toggler-icon']"))
                .click();

        driver.findElement(
                By.xpath("//a[@href='/angularAppdemo/products']"))
                .click();

        ((JavascriptExecutor)driver)
                .executeScript("window.scrollBy(0,1000)","");
        String actualText= driver.findElement(By.linkText("Devops")).getText();
        Assert.assertEquals(actualText, "Devops");


    }
}
