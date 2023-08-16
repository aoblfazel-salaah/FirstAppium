package Basics.IOS;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
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

public class IOSBaseTest {

    public static IOSDriver driver;
    public AppiumDriverLocalService service;

    @BeforeMethod
    public void configureAppium() throws MalformedURLException {
        service= new AppiumServiceBuilder()
                .withAppiumJS(new File
                ("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        XCUITestOptions options= new XCUITestOptions();
        options.setDeviceName("iPhone 14 Pro");
        options.setApp("/Users/omaid/Library/Developer/Xcode/DerivedData/" +
                "UIKitCatalog-gjfyminebzakdfbsypgwrliszxwi/Build/Products/" +
                "Debug-iphonesimulator/UIKitCatalog.app");
        options.setPlatformVersion("16.4");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));


        driver= new IOSDriver(
                new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
