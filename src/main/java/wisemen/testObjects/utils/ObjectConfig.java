package wisemen.testObjects.utils;

import wisemen.common.JSONHelper;

public class ObjectConfig {
    //private static final String testConfigJsonFile = "src/main/java/wisemen/testConfig.json";

    public static String getTestObject(){
        String testObject = System.getProperty("testObject");
        if (testObject != null){
            return testObject;
        } else {
            return getDefaultTestObject();
        }
    }

    public static String getDefaultTestObject(){
        return "web";
        //return JSONHelper.getJSONStringFromJSONFile(testConfigJsonFile, "defaultTestObject");
        //TODO: check of config bestand hier nuttig is
    }
}
