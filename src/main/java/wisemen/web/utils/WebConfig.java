package wisemen.web.utils;

import wisemen.common.JSONHelper;

//This class gets all the information out of the web config file
public class WebConfig {
    private static final String webConfigFile = "src/main/java/*/webConfig.json";

    public static String getDefaultBrowser() {
        return JSONHelper.getJSONStringFromJSONFile(webConfigFile, "defaultBrowser");
    }

    public static String getDefaultTimeout() {
        return JSONHelper.getJSONStringFromJSONFile(webConfigFile, "defaultTimeout");
    }

    public static String getBaseUrl() {
        return JSONHelper.getJSONStringFromJSONFile(webConfigFile, "baseUrl");
    }

    public static String getLoginEndpoint() {
        return JSONHelper.getJSONStringFromJSONFile(webConfigFile, "loginEndpoint");
    }
}
