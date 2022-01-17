package main.java;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class uiAutomatorTest extends base {

    public static void main(String[] args) throws MalformedURLException{
        // Use UI Automator to automate with only attributes and properties
        AndroidDriver<AndroidElement> driver = capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        // UiAutomator path rule ("attribute(\"value\")")
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
        // Validate clickable feature for all options
        // Syntax =>  driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");
        System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());

    }

}
