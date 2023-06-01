package wisemen.mobile.screenObjects.Android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wisemen.mobile.screenObjects.BaseScreen;
import wisemen.mobile.utils.MobileConfig;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUpAndroid extends BaseScreen implements wisemen.mobile.screenObjects.SignUpScreen {
    private String appPackage = MobileConfig.getAndroidAppPackage();
    private By txtUsername = By.id(appPackage + ":id/etUsername");
    private By txtEmail = By.id(appPackage + ":id/etEmail");
    private By txtPassword = By.id(appPackage + ":id/etPassword");
    private By txtConfirmPassword = By.id(appPackage + ":id/etConfirmPassword");
    private By cbPrivacyPolicy = By.id(appPackage + ":id/cbReadPrivacyPolicy");
    private By btnRegister = By.id(appPackage + ":id/btnRegister");
    private By btnAlreadyAccount = By.id(appPackage + ":id/tvAlreadyAccount");
    private By btnLanguages = By.id(appPackage + ":id/tvChangeLanguage");
    private By btnPrivacyPolicy = By.id(appPackage + ":id/tvReadPrivacyPolicy");
    private By msgError = By.id(appPackage + ":id/snackbar_text");

    public SignUpAndroid(AppiumDriver driver) {
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
        wait.until(ExpectedConditions.elementToBeClickable(cbPrivacyPolicy)).click();
    }

    public void clickSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(getBtnSignUp())).click();
    }

    public void signUp(String username, String email, String password) {
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

    public void clickLanguages(){
        driver.findElement(btnLanguages).click();
    }

    public static final List<Integer> xCoordinatesTermsAndConditions = Arrays.asList(
            700, 400, 10, 10, 10, 250, 500, 500, 700, 500, 500, 10, 600, 10, 500, 600, 400, 600, 650, 100, 10, 700, 700, 10, 600, 600);

    public static final List<Integer> yCoordinatesTermsAndConditions = Arrays.asList(
            15, 50, 50, 50, 50, 10, 10, 10, 10, 10, 10, 50, 10, 50, 10, 50, 10, 10, 10, 50, 50, 10, 10, 60, 60, 10);

    public static final List<Integer> xCoordinatesPrivacyPolicy = Arrays.asList(
            500, 400, 10, 10, 10, 10, 400, 10, 550, 100, 500, 400, 10, 600, 10, 400, 10, 400, 400, 10, 10, 300, 100, 700, 10, 10);

    public static final List<Integer> yCoordinatesPrivacyPolicy = Arrays.asList(
            70, 100, 100, 100, 100, 10, 60, 70, 60, 60, 60, 60, 100, 60, 100, 100, 60, 60, 60, 100, 100, 70, 70, 60, 100, 70);

    public void clickPrivacyPolicy(int indexLanguage){
        WebElement privacyPolicy = driver.findElement(btnPrivacyPolicy);
        Point point = privacyPolicy.getLocation();

        Map<String, Object> args = new HashMap<>();
        //args.put("element", ((RemoteWebElement)privacyPolicy).getId());
        args.put("x", point.x + xCoordinatesPrivacyPolicy.get(indexLanguage));
        args.put("y", point.y + yCoordinatesPrivacyPolicy.get(indexLanguage));
        driver.executeScript("mobile: longClickGesture", args);
    }

    public void clickTermsAndConditions(int indexLanguage){
        WebElement privacyPolicy = driver.findElement(btnPrivacyPolicy);
        Point point = privacyPolicy.getLocation();

        Map<String, Object> args = new HashMap<>();
        //args.put("element", ((RemoteWebElement)privacyPolicy).getId());
        args.put("x", point.x + xCoordinatesTermsAndConditions.get(indexLanguage));
        args.put("y", point.y + yCoordinatesTermsAndConditions.get(indexLanguage));
        driver.executeScript("mobile: longClickGesture", args);
    }

    public boolean errorMsgIsDisplayed(){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(msgError));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getBtnAlreadyAccount() {
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().resourceIdMatches(\".*:id/tvAlreadyAccount\"))"));
    }

    public WebElement getBtnSignUp() {
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().resourceIdMatches(\".*:id/btnRegister\"))"));
    }

    /*
    public WebElement getBtnSignUp() {
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().resourceId(\"" + btnRegister + "\"))"));
    }
     */

    public WebElement getLanguageNorsk(){
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().textContains(\"" + "norsk" + "\"))"));
    }
}
