package main.java;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class basics extends base {

    public static void main(String[] args) throws MalformedURLException {
        //Tests
        test1();
        test2();
    }

    public static void test1() throws MalformedURLException {
        //Test: Click on Preference/Preference dependencies/WiFi check checkbox/WiFi settings/input text/click ok
        AndroidDriver<AndroidElement> driver = capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@content-desc='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
        // elements in array
        driver.findElementsByClassName("android.widget.Button").get(1).click();
    }

    public static void test2() throws MalformedURLException {
        //Test: Click on Preference/Preference dependencies/WiFi check checkbox/WiFi settings/input text/click ok
        AndroidDriver<AndroidElement> driver = capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("//android.widget.TextView[@content-desc='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@content-desc='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
        // elements in array
        driver.findElementsByClassName("android.widget.Button").get(1).click();
    }

}
