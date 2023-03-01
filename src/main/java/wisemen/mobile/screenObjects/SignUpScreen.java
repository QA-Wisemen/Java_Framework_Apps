package wisemen.mobile.screenObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.lang.model.element.Element;
import java.awt.*;

public class SignUpScreen extends BaseScreen {
    private By usernameTxt = By.id("com.abbemobility.chargersync.dev:id/etUsername");
    private By registerBtn = By.id("com.abbemobility.chargersync.dev:id/btnRegister");
    private By alreadyAccountBtn = By.id("com.abbemobility.chargersync.dev:id/tvAlreadyAccount");

    public SignUpScreen(AndroidDriver driver) {
        super(driver, "/");
    }

    public void clickAlreadyAccount() {
        driver.findElement(alreadyAccountBtn).click();
    }

    public WebElement getAlreadyAccountBtn() {
        WebElement alreadyAccountElement = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*part_id.*\"))"));

        return alreadyAccountElement;
    }
}
