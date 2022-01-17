package main.java;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class dragDrop extends base{
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Drag and Drop']").click();
        TouchAction t = new TouchAction(driver);
        // long press(element) -> move to destination -> release and perform
        WebElement firstE = driver.findElementsByClassName("android.view.View").get(0);
        WebElement secondE = driver.findElementsByClassName("android.view.View").get(1);
        t.longPress(ElementOption.element(firstE)).moveTo(ElementOption.element(secondE)).release().perform();
        // assertion
        System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='Dropped!']").isDisplayed());


    }
}
