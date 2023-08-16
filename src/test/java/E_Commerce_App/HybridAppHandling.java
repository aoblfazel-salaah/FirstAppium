package E_Commerce_App;

import Basics.Android.BaseTest;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class HybridAppHandling extends BaseTest {

    @Test
    public void changeContextToWeb() throws InterruptedException {
        PlaceOrder.placeOrder();
        Thread.sleep(4000);
        Set<String> handles= driver.getContextHandles();

        for (String handle : handles) {
            System.out.println(handle);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        WebElement searchBar= driver.findElement(By.name("q"));
        searchBar.sendKeys("Aoblfazel Salaah");
        searchBar.sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
    }
}
