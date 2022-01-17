package main.java;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;


import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class gestures extends base{

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Automation for gestures
        AndroidDriver<AndroidElement> driver = capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();
       // If you want to Tap on element for drag and drop
        TouchAction t = new TouchAction(driver);
        WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@content-desc='Expandable Lists']");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandList))).perform();
        driver.findElementByXPath("//android.widget.TextView[@content-desc='1. Custom Adapter']").click();
        WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        // Tap and hold for 2 seconds
        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peopleNames)).withDuration(Duration.ofSeconds(2))).release().perform();
        Thread.sleep(2000);
        System.out.println(driver.findElementById("android:id/title").isDisplayed());
    }
}
