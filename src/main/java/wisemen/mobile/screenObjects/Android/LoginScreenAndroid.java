package wisemen.mobile.screenObjects.Android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wisemen.mobile.screenObjects.BaseScreen;
import wisemen.mobile.utils.MobileConfig;

import java.util.Arrays;
import java.util.List;

public class LoginScreenAndroid extends BaseScreen implements wisemen.mobile.screenObjects.LoginScreen {
    private String appPackage = MobileConfig.getAndroidAppPackage();
    private By txtUsername = By.id(appPackage + ":id/etEmail");
    private By txtPassword = By.id(appPackage + ":id/etPassword");
    private By btnLogin = By.id(appPackage + ":id/btnLogin");
    private By msgError = By.id(appPackage + ":id/snackbar_text");
    private By btnSignUp = By.id(appPackage + ":id/tvSignup");
    private By btnLanguages = By.id(appPackage + ":id/tvChangeLanguage");

    public static final List<String> LANGUAGES = Arrays.asList(
            "English", "slovenščina", "slovenčina", "polski", "svenska", "עברית", "dansk", "日本語", "Ελληνικά", "italiano", "português",
            "magyar", "français", "Türkçe", "norsk", "latviešu", "čeština", "română", "hrvatski", "Nederlands", "Deutsch", "한국어", "suomi", "español",
            "eesti", "lietuvių");

    public static final List<String> LANGUAGES_ENGLISH = Arrays.asList("English", "Slovenian", "Slovak", "Polish", "Swedish", "Hebrew", "Danish", "Japanese", "Greek", "Italian", "Portuguese",
            "Hungarian", "French", "Turkish", "Norwegian", "Latvian", "Czech", "Romanian", "Croatian", "Dutch", "German", "Korean", "Finnish", "Spanish",
            "Estonian", "Lithuanian"
    );

    public LoginScreenAndroid(AppiumDriver driver) {
        super(driver);
    }

    public void fillInUsername(String username) {
        WebElement usernameTxtElement = wait.until(ExpectedConditions.elementToBeClickable(txtUsername));
        usernameTxtElement.sendKeys(username);
    }

    public void fillInPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtnElement = wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        loginBtnElement.click();
    }

    public void clickSignUp() {
        WebElement signUpBtnElement = wait.until(ExpectedConditions.elementToBeClickable(btnSignUp));
        signUpBtnElement.click();
    }

    public void login(String username, String password) {
        fillInUsername(username);
        fillInPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return null;
    }

    public void clickLanguages() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLanguages)).click();
    }

    public WebElement getLanguageNorsk() {
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().textContains(\"" + "norsk" + "\"))"));
    }

    public WebElement getLanguage(String language) {
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().textContains(\"" + language + "\"))"));
    }
}
