package wisemen.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wisemen.mobile.utils.MobileConfig;
import wisemen.testObjects.objects.ILoginObject;

public class LoginScreen extends BaseScreen implements ILoginObject {
    private String appPackage = MobileConfig.getAppPackage();
    private By usernameTxt = By.id(appPackage + ":id/etEmail");
    private By passwordTxt = By.id(appPackage + ":id/etPassword");
    private By loginBtn = By.id(appPackage + ":id/btnLogin");
    private By errorMsg = By.id(appPackage + ":id/snackbar_text");
    private By signUpBtn = By.id(appPackage + ":id/tvSignup");

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void fillInUsername(String username) {
        WebElement usernameTxtElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        usernameTxt
                ));
        usernameTxtElement.sendKeys(username);
    }

    @Override
    public void fillInPassword(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    @Override
    public void clickLogin() {
        WebElement loginBtnElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginBtn
                ));
        loginBtnElement.click();
    }

    public void clickSignUp() {
        WebElement signUpBtnElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        signUpBtn
                ));
        signUpBtnElement.click();
    }

    @Override
    public void login(String username, String password) {
        fillInUsername(username);
        fillInPassword(password);
        clickLogin();
    }

    @Override
    public void validUserLogin() {

    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
