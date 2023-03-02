package mobile;

import wisemen.mobile.screenObjects.AllScreens;

import java.util.concurrent.TimeUnit;

public class MobileTest {
    public static void main(String[] args) throws InterruptedException {
        AllScreens screens = new AllScreens();
        screens.login.fillInUsername("Test");
        TimeUnit.MINUTES.sleep(5);
    }
}
