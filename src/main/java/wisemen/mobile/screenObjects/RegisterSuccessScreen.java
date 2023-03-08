package wisemen.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wisemen.mobile.utils.MobileConfig;

public class RegisterSuccessScreen extends BaseScreen {
    private String appPackage = MobileConfig.getAppPackage();
    private By btnSucces = By.id(appPackage + ":id/btnRegisterSuccess");

    public RegisterSuccessScreen(AndroidDriver driver) {
        super(driver);
    }

    public WebElement getBtnSucces() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(
                        btnSucces
                ));
    }
}