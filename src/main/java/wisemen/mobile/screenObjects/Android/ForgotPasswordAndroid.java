package wisemen.mobile.screenObjects.Android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wisemen.mobile.screenObjects.BaseScreen;
import wisemen.mobile.screenObjects.ForgotPasswordScreen;
import wisemen.mobile.utils.MobileConfig;

public class ForgotPasswordAndroid extends BaseScreen implements ForgotPasswordScreen {
    private String appPackage = MobileConfig.getAndroidAppPackage();
    private By txtEmail = By.id(appPackage + ":id/etEmail");
    private By btnSendMail = By.id(appPackage + ":id/btnSendMail");

    public ForgotPasswordAndroid(AppiumDriver driver) {
        super(driver);
    }

    public void fillInEmail(String email){
        wait.until(ExpectedConditions.elementToBeClickable(txtEmail)).sendKeys(email);
    }

    public void clickSendMail(){
        wait.until(ExpectedConditions.elementToBeClickable(btnSendMail)).click();
    }
}
