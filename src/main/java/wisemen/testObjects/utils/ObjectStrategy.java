package wisemen.testObjects.utils;

import wisemen.mobile.screenObjects.AllScreens;
import wisemen.testObjects.objects.IAllObjects;

public class ObjectStrategy {
    public static IAllObjects createTestObject() {
        return createTestObject(ObjectConfig.getTestObject());
    }

    public static IAllObjects createTestObject(String testObject) {

        return switch (testObject) {
            case "mobile" -> new AllScreens();
            default -> null;
        };
    }
}
