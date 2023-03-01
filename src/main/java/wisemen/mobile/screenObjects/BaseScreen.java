package wisemen.mobile.screenObjects;

import wisemen.mobile.utils.MobileConfig;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Set-up for a basic screen
public class BaseScreen {
    protected AndroidDriver driver;
    protected String url;
    protected WebDriverWait wait;

    public BaseScreen(AndroidDriver driver, String endpoint) {
        this.driver = driver;
        url = MobileConfig.getBaseUrl() + endpoint;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void navigateTo(){
        this.driver.get(url);
    }
}
