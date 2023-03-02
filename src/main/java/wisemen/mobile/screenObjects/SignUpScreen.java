package wisemen.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wisemen.mobile.utils.MobileConfig;

public class SignUpScreen extends BaseScreen {
    private String appPackage = MobileConfig.getAppPackage();
    private By usernameTxt = By.id(appPackage + ":id/etUsername");
    private By registerBtn = By.id(appPackage + ":id/btnRegister");
    private By alreadyAccountBtn = By.id(appPackage + ":id/tvAlreadyAccount");

    public SignUpScreen(AndroidDriver driver) {
        super(driver);
    }

    public void clickAlreadyAccount() {
        driver.findElement(alreadyAccountBtn).click();
    }

    public WebElement getAlreadyAccountBtn() {
        /*WebElement alreadyAccountElement = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(" + alreadyAccountBtn + "))"));*/

        return driver.findElement(alreadyAccountBtn);
    }
}
