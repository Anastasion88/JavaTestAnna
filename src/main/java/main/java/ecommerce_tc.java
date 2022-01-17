package main.java;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ecommerce_tc extends generalStoreBase{
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        test1();
        test2();
        test3();
        test4();
        test5();
          test6();
    }

    public static void test1() throws MalformedURLException {
        // 1. fill the form details -> happy path
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByClassName("android.widget.EditText").sendKeys("Anna");
        // If you need to hide keyboard
        driver.hideKeyboard();
        driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        driver.findElementById("android:id/text1").click();
        // scroll
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        // second option
        // driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "United States" + "\").instance(0))"));
        driver.findElementByXPath("//android.widget.TextView[@text='Argentina']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

    }

    public static void test2() throws MalformedURLException {
        // 2. fill the form details and verify toast error message displayed for wrong inputs
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        // Toasts sometimes are not visible but we can use xpath abow
        String name = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
        System.out.println("Attribute Name: " + name);
    }

    public static void test3() throws MalformedURLException {
        // 3. shop items by scrolling to specific product and add to the cart, open the cart
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByClassName("android.widget.EditText").sendKeys("Anna");
        driver.hideKeyboard();
        driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        driver
                .findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
                        + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                        + "new UiSelector().text(\"Jordan 6 Rings\"));"));

        int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
        for (int i=0; i < count; i++){
            String pName = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
            if (pName.equalsIgnoreCase("Jordan 6 Rings")){
                driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                break;
            }
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        String result = driver.findElementById("com.androidsample.generalstore:id/productName").getText();
        Assert.assertEquals("Jordan 6 Rings", result);
        System.out.println("Product in the cart: " + result);
    }

    public static void test4() throws MalformedURLException {
        // 4. Validate the total amount of two products are displayed in the checkout page matches with sum of product amounts selected
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByClassName("android.widget.EditText").sendKeys("Anna");
        driver.hideKeyboard();
        driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
        driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String price1String = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
        String price2String = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
        String totalString = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
        double p1 = getAmount(price1String);
        double p2 = getAmount(price2String);
        double total = getAmount(totalString);
        double sumOfP = p1 + p2;

        // for loop for getting a price
//        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
//        double sumForLoop = 0;
//        for (int i=0; i<count; i++){
//          String amount =  driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
//          double am = getAmount(amount);
//          sumForLoop = sumForLoop + am;
//        }

        // One more option to get price and convert to int
//        String price1 = price1String.replace("$","");
//        BigDecimal sPrice1 = new BigDecimal(price1);
//        String price2 = price2String.replace("$","");
//        BigDecimal sPrice2 = new BigDecimal(price2);
//        String total = totalString.replace("$ ","");
//        BigDecimal sTotal = new BigDecimal(total);
//        BigDecimal sPrice3 = sPrice1.add(sPrice2);

        System.out.println("Price 1: " + p1 + " Price 2: " + p2 + " Total: " + total);
        Assert.assertEquals(sumOfP, total);
    }

    public static void test5() throws MalformedURLException {
        // 5. Validate mobile gestures working Links (long press) and navigate to web browser
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByClassName("android.widget.EditText").sendKeys("Anna");
        driver.hideKeyboard();
        driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
        driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String totalString = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
        double total = getAmount(totalString);
        // for loop for getting a price
        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sumForLoop = 0;
        for (int i=0; i<count; i++){
          String amount =  driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
          double am = getAmount(amount);
          sumForLoop = sumForLoop + am;
        }
        Assert.assertEquals(sumForLoop, total);

        // Mobile Gestures
        WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
        TouchAction t = new TouchAction(driver);
        t.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(checkbox)))
                .perform();
        WebElement terms = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
        t.longPress(LongPressOptions
                .longPressOptions()
                .withElement(ElementOption.element(terms))
                .withDuration(Duration.ofSeconds(2)))
                .release()
                .perform();
        Assert.assertTrue(driver.findElement(By.className("android.widget.FrameLayout")).isDisplayed());
        driver.findElementById("android:id/button1").click();
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();


    }

    public static void test6() throws MalformedURLException, InterruptedException {
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
        driver.findElement(By.name("q")).sendKeys("weather in Dallas");

//        driver.quit();




    }


    // function to help convert string to double and remove $ sign, returns double
    public static double getAmount(String value){
        value = value.substring(1);
        double amountValue = Double.parseDouble(value);
        return amountValue;
    }

}
