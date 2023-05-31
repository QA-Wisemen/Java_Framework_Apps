package wisemen.mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileUtil {
    public static OS executionOS = OS.ANDROID;

    public enum OS {
        ANDROID,
        IOS
    }

    public static AppiumDriver driver;

    public static AppiumDriver createDriver() {
        if (driver != null) {
            return driver;
        }

        DesiredCapabilities capabilities;
        switch (executionOS) {
            case ANDROID -> {
                capabilities = getMandatoryAndroidCapabilities();
                /* File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/app/Android");
                File app = new File(appDir, "Contacts.apk");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "Pixel_4_API_30");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("appPackage", "com.jayway.contacts");
                capabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity"); */
                capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
                capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
                capabilities.setCapability("appActivity",MobileConfig.getAndroidAppActivity());
                capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/src/main/resources/" + MobileConfig.getAndroidApp());
                try {
                    driver = new AndroidDriver(new URL(MobileConfig.getAppiumURL()), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            case IOS -> {
                capabilities = getMandatoryIOSCapabilities();
                /* classpathRoot = new File(System.getProperty("user.dir"));
                appDir = new File(classpathRoot, "/app/iOS/");
                app = new File(appDir, "ContactsSimulator.app");
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", "iPhone 7");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("automationName", "XCUITest"); */
                capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
                capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
                capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "\\" + MobileConfig.getIOSApp());
                try {
                    driver = new IOSDriver(new URL(MobileConfig.getAppiumURL()), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return driver;
    }

    public static AndroidDriver createDriverWithApp() {
        /*
        //DesiredCapabilities desiredCapabilities = getMandatoryCapabilities();
        //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, MobileConfig.getAppPackage());
        //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, MobileConfig.getAppActivity());
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        //System.out.println(MobileConfig.getApp());
        //System.out.println("Working Directory = " + System.getProperty("user.dir"));
        //System.out.println(System.getProperty("user.dir") + "\\" + MobileConfig.getApp());
        desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "\\" + MobileConfig.getApp());
        try {
            return new AndroidDriver(new URL(MobileConfig.getAppiumURL()), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
         */
        return null;
    }

    private static DesiredCapabilities getMandatoryAndroidCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, MobileConfig.getAndroidDeviceName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobileConfig.getAndroidPlatformName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, MobileConfig.getAndroidPlatformVersion());
        return desiredCapabilities;
    }

    private static DesiredCapabilities getMandatoryIOSCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, MobileConfig.getIOSDeviceName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobileConfig.getIOSPlatformName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, MobileConfig.getIOSPlatformVersion());
        return desiredCapabilities;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
