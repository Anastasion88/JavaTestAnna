package main.java;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class generalStoreBase {
    public static AndroidDriver<AndroidElement> capabilities()throws MalformedURLException {

        // show the path for Android app
        File appDir = new File("src");
        File app = new File(appDir, "General-Store.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath() );
        // UIAutomator2 core engine for Android apps
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
        // wait for new command 14 sec and close the app if nothing happened
//        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
//        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        // pass object cap with all settings to Android driver and url for listening localhost
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        return driver;
    }
}
