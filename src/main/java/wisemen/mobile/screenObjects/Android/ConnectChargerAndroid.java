package wisemen.mobile.screenObjects.Android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wisemen.mobile.screenObjects.BaseScreen;
import wisemen.mobile.screenObjects.ConnectChargerScreen;
import wisemen.mobile.utils.MobileConfig;

public class ConnectChargerAndroid extends BaseScreen implements ConnectChargerScreen {
    private String appPackage = MobileConfig.getAndroidAppPackage();
    private By btnScanBarcode = By.id(appPackage + ":id/btnScanBarcode");

    public ConnectChargerAndroid(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getScanBarcode() {
        return wait.until(ExpectedConditions.elementToBeClickable(btnScanBarcode));
    }
}
