package Basics.Android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserBaseTest {

    public static AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeMethod
    public void configureAppium() throws MalformedURLException {
        service= new AppiumServiceBuilder()
                .withAppiumJS(new File
                        ("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        UiAutomator2Options options= new UiAutomator2Options();
        options.setDeviceName("Pixel6");

        options.setChromedriverExecutable(
                "/Users/omaid/Downloads/chromedriver_mac64 (3)/chromedriver");

        //have to tell it to open chrome
        options.setCapability("browserName", "Chrome");

        driver= new AndroidDriver(
                new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        service.stop();
    }

    public static Double getFormattedAmount(String amount){
        amount=amount.substring(1);
        return Double.parseDouble(amount);
    }
}
