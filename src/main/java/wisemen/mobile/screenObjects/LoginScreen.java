package wisemen.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wisemen.mobile.utils.MobileConfig;

public class LoginScreen extends BaseScreen {
    private String appPackage = MobileConfig.getAppPackage();
    private By txtUsername = By.id(appPackage + ":id/etEmail");
    private By txtPassword = By.id(appPackage + ":id/etPassword");
    private By btnLogin = By.id(appPackage + ":id/btnLogin");
    private By msgError = By.id(appPackage + ":id/snackbar_text");
    private By btnSignUp = By.id(appPackage + ":id/tvSignup");

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    public void fillInUsername(String username) {
        WebElement usernameTxtElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        txtUsername
                ));
        usernameTxtElement.sendKeys(username);
    }


    public void fillInPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtnElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        btnLogin
                ));
        loginBtnElement.click();
    }

    public void clickSignUp() {
        WebElement signUpBtnElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        btnSignUp
                ));
        signUpBtnElement.click();
    }

    public void login(String username, String password) {
        fillInUsername(username);
        fillInPassword(password);
        clickLogin();
    }

    public void validUserLogin() {

    }

    public String getErrorMessage() {
        return null;
    }
}
