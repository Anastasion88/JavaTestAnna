package main.java;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Keys;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ecommerce_hybrid_tc extends generalStoreBase{
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        test();
    }

    public static void test() throws MalformedURLException, InterruptedException {
        // 6. Navigate to browser and back
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByClassName("android.widget.EditText").sendKeys("Anna");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
        Thread.sleep(5000); // 5 seconds
        // Switch to Selenium API instead Appium
        Set<String> contexts = driver.getContextHandles();
        for (String contextName: contexts){
            System.out.println("Context Name: " + contextName);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        // do more web testing if we want
        driver.findElementByXPath("//input[@name='q']").sendKeys("weather in Dallas");
        driver.findElementByXPath("//input[@name='q']").sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        // switch to Native App
        driver.context("NATIVE_APP");
    }
}
