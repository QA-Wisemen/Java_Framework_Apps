package wisemen.mobile.utils;

import wisemen.common.JSONHelper;

//This class gets all the information out of the mobile config file
public class MobileConfig {
    private static final String mobileConfigFile = "src/main/java/wisemen/mobile/mobileConfig.json";

    public static String getDeviceName(){
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "deviceName");
    }

    public static String getPlatformName(){
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "platformName");
    }

    public static String getPlatformVersion(){
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "platformVersion");
    }

    public static String getChromeDriverExecutable(){
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "chromeDriverExecutable");
    }

    public static String getBrowsername(){
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "browsername");
    }

    public static String getAppActivity() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "appActivity");
    }

    public static String getAppPackage() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "appPackage");
    }

    public static String getApp() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "app");
    }

    public static String getAppiumURL() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "appiumURL");
    }

    public static String getBaseUrl(){
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "baseUrl");
    }

    public static String getLoginEndpoint() {
        return JSONHelper.getJSONStringFromJSONFile(mobileConfigFile, "loginEndpoint");
    }
}
