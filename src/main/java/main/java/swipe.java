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

public class swipe extends base{

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Date Widgets']").click();
        driver.findElementByXPath("//android.widget.TextView[@content-desc='2. Inline']").click();
        // if you want to skip tagName and accept any tagNames: ("//*[@attribute='value']")
        driver.findElementByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='9']").click();
        // long press for 2sec on element -> move to another element and release
        TouchAction t = new TouchAction(driver);
        WebElement time15 = driver.findElementByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='15']");
        WebElement time45 = driver.findElementByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='45']");
        // swipe simulation
        t.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(time15))
                .withDuration(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(time45))
                .release()
                .perform();
        // assertion
        System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='45']").isDisplayed());

    }
}
