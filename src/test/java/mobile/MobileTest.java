package mobile;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import wisemen.mobile.screenObjects.AllScreens;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MobileTest {
    public static void main(String[] args) throws InterruptedException {
        AllScreens screens = new AllScreens();
        screens.login.fillInUsername("Test");
        TimeUnit.MINUTES.sleep(5);
    }
}
