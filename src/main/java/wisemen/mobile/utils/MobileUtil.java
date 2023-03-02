package wisemen.mobile.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileUtil {
    public static AndroidDriver createDriverWithApp() {
        DesiredCapabilities desiredCapabilities = getMandatoryCapabilities();
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
    }

    private static DesiredCapabilities getMandatoryCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, MobileConfig.getDeviceName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobileConfig.getPlatformName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, MobileConfig.getPlatformVersion());
        return desiredCapabilities;
    }
}
