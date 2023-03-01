package wisemen.mobile.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileUtil {
    public static AndroidDriver createDriverWithBrowser(){
        DesiredCapabilities desiredCapabilities = getMandatoryCapabilities();
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.BROWSER_NAME, MobileConfig.getBrowsername());
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, MobileConfig.getChromeDriverExecutable());

        try {
            return new AndroidDriver(new URL(MobileConfig.getAppiumURL()), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static AndroidDriver createDriverWithApp(){
        DesiredCapabilities desiredCapabilities = getMandatoryCapabilities();
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, MobileConfig.getAppPackage());
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, MobileConfig.getAppActivity());

        try {
            return new AndroidDriver(new URL(MobileConfig.getAppiumURL()), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static DesiredCapabilities getMandatoryCapabilities(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, MobileConfig.getDeviceName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobileConfig.getPlatformName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, MobileConfig.getPlatformVersion());
        return desiredCapabilities;
    }
}
