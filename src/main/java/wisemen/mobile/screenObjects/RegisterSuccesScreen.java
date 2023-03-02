package wisemen.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wisemen.mobile.utils.MobileConfig;

public class RegisterSuccesScreen extends BaseScreen {
    private String appPackage = MobileConfig.getAppPackage();
    private By btnSucces = By.id(appPackage + ":id/btnRegisterSuccess");

    public RegisterSuccesScreen(AndroidDriver driver) {
        super(driver);
    }

    public WebElement getBtnSucces() {
        return driver.findElement(btnSucces);
    }
}
