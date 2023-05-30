package wisemen.mobile.screenObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Set-up for a basic screen
public class BaseScreen {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
