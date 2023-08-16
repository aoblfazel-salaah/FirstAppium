package E_Commerce_App;

import Basics.Android.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ValidateSumAmount extends BaseTest {
    @Test
    public static void validateSum(){
        FillForm.fillForm();
        List <WebElement> addToCartButtons = driver.findElements(
                By.id("com.androidsample.generalstore:id/productAddCart"));

        for (WebElement button:addToCartButtons){
            button.click();
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"))
                .click();

        List <WebElement> productPrices= driver.findElements
                (By.id("com.androidsample.generalstore:id/productPrice"));

        double expectedTotalPrice=0;
        for (WebElement price:productPrices){
            double cPrice= Double.parseDouble(
                    price.getText().substring(1));
            expectedTotalPrice += cPrice;
        }

        WebElement totalAmountElement= driver.findElement(By.id(
                "com.androidsample.generalstore:id/totalAmountLbl"
        ));

        double actualTotalAmount= getFormattedAmount(totalAmountElement.getText());

        System.out.println(actualTotalAmount +"?="+ expectedTotalPrice);

        Assert.assertEquals(actualTotalAmount, expectedTotalPrice);
    }
}
