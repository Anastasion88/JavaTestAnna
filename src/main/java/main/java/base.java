package main.java;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class base {

    public static AndroidDriver<AndroidElement> capabilities(String device)throws MalformedURLException {

        // show the path for Android app
        File appDir = new File("src");
        File app = new File(appDir, "ApiDemos-debug.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        // automatically change devices
        if(device.equals("real")){
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Anastassiya-RealDevice");
        } else if (device.equals("emulator")){
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AnastassiyaTest-Pixel");
        }
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath() );
        // UIAutomator2 core engine for Android apps
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        // pass object cap with all settings to Android driver and url for listening localhost
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        return driver;
    }
}
