package main.java;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.net.MalformedURLException;

public class browse extends baseChrome{

    public static void main(String[] args) throws MalformedURLException {
        // setup main settings
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        // click on hamburger button, scroll down, verify Devops course has Devops word
        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        driver.findElement(By.cssSelector("a[href*='products']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        String text = driver.findElementByXPath("(//li[@class='list-group-item'])[3]/div/div/a").getText();
        Assert.assertEquals(text, "Devops");
    }
}
