package wisemen.mobile.utils;

import wisemen.common.JSONHelper;

//This class gets all the information out of the mobile config file
public class MobileConfig {
    private static final String mobileConfigFile = "src/main/java/wisemen/mobile/mobileConfig.json";

    public static String getAndroidDeviceName() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "AndroidDeviceName");
    }

    public static String getIOSDeviceName() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "IOSDeviceName");
    }

    public static String getAndroidPlatformName() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "AndroidPlatformName");
    }

    public static String getIOSPlatformName() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "IOSPlatformName");
    }

    public static String getAndroidPlatformVersion() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "AndroidPlatformVersion");
    }

    public static String getIOSPlatformVersion() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "IOSPlatformVersion");
    }

    public static String getAndroidAppActivity() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "AndroidAppActivity");
    }

    public static String getIOSAppActivity() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "appActivity");
    }

    public static String getAndroidAppPackage() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "AndroidAppPackage");
    }

    public static String getIOSAppPackage() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "appPackage");
    }

    public static String getAndroidApp() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "AndroidApp");
    }

    public static String getIOSApp() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "app");
    }

    public static String getAppiumURL() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "appiumURL");
    }
}
