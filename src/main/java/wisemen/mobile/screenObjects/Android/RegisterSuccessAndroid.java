package wisemen.mobile.screenObjects.Android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wisemen.mobile.screenObjects.BaseScreen;
import wisemen.mobile.screenObjects.RegisterSuccessScreen;
import wisemen.mobile.utils.MobileConfig;

public class RegisterSuccessAndroid extends BaseScreen implements RegisterSuccessScreen {
    private String appPackage = MobileConfig.getAndroidAppPackage();
    private By btnSucces = By.id(appPackage + ":id/btnRegisterSuccess");

    public RegisterSuccessAndroid(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBtnSuccess() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(
                        btnSucces
                ));
    }
}