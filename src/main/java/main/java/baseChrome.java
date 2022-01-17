package main.java;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.lang.model.element.Element;
import java.net.MalformedURLException;
import java.net.URL;

public class baseChrome {

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
        // setup main settings
        AndroidDriver<AndroidElement> driver;
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AnastassiyaTest-Pixel");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
        // if you need to work with browser
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap); // wb- webDriver/hub
        return driver;
    }

}
