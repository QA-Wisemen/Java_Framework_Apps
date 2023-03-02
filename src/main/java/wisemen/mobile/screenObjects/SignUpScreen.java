package wisemen.mobile.screenObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wisemen.mobile.utils.MobileConfig;

public class SignUpScreen extends BaseScreen {
    private String appPackage = MobileConfig.getAppPackage();
    private By txtUsername = By.id(appPackage + ":id/etUsername");
    private By txtEmail = By.id(appPackage + ":id/etEmail");
    private By txtPassword = By.id(appPackage + ":id/etPassword");
    private By txtConfirmPassword = By.id(appPackage + ":id/etConfirmPassword");
    private By cbPrivacyPolicy = By.id(appPackage + ":id/cbReadPrivacyPolicy");
    private By btnRegister = By.id(appPackage + ":id/btnRegister");
    private By btnAlreadyAccount = By.id(appPackage + ":id/tvAlreadyAccount");

    public SignUpScreen(AndroidDriver driver) {
        super(driver);
    }

    public void fillInUsername(String username) {
        WebElement usernameTxtElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        txtUsername
                ));
        usernameTxtElement.sendKeys(username);
    }

    public void fillInEmail(String email) {
        WebElement emailTxtElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        txtEmail
                ));
        emailTxtElement.sendKeys(email);
    }

    public void fillInPassword(String password) {
        WebElement passwordTxtElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        txtPassword
                ));
        passwordTxtElement.sendKeys(password);
    }

    public void fillInConfirmPassword(String password) {
        driver.findElement(txtConfirmPassword).sendKeys(password);
    }

    public void clickConfirmPrivacyPolicy() {
        driver.findElement(cbPrivacyPolicy).click();
    }

    public void clickSignUp() {
        getBtnSignUp().click();
    }

    public void SignUp(String username, String email, String password) {
        fillInUsername(username);
        fillInEmail(email);
        fillInPassword(password);
        fillInConfirmPassword(password);
        clickConfirmPrivacyPolicy();
        clickSignUp();
    }

    public void clickAlreadyAccount() {
        driver.findElement(btnAlreadyAccount).click();
    }

    public WebElement getBtnAlreadyAccount() {
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().textContains(\"" + "already have an account" + "\").instance(0))"));
    }

    public WebElement getBtnSignUp() {
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().textContains(\"" + "sign up" + "\").instance(0))"));
    }
}
