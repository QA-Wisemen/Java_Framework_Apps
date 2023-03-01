package wisemen.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wisemen.mobile.utils.MobileConfig;
import wisemen.testObjects.objects.ILoginObject;

public class LoginScreen extends BaseScreen implements ILoginObject {
    private By usernameTxt = By.id("com.abbemobility.chargersync.dev:id/etEmail");
    private By passwordTxt = By.id("com.abbemobility.chargersync.dev:id/etPassword");
    private By loginBtn = By.cssSelector("button");
    private By errorMsg = By.cssSelector("#flash");
    private By signUpBtn = By.id("com.abbemobility.chargersync.dev:id/tvSignup");

    public LoginScreen(AndroidDriver driver) {
        super(driver, MobileConfig.getLoginEndpoint());
    }

    @Override
    public void fillInUsername(String username) {
        /*WebElement usernameTxtElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        usernameTxt
                ));*/
        driver.findElement(usernameTxt).sendKeys(username);
    }

    @Override
    public void fillInPassword(String password) {
        WebElement passwordTxtElement = driver.findElement(passwordTxt);
        passwordTxtElement.sendKeys(password);
    }

    @Override
    public void clickLogin() {

    }

    public void clickSignUp(){
        WebElement usernameTxtElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        signUpBtn
                ));
        usernameTxtElement.click();
    }

    @Override
    public void login(String username, String password) {

    }

    @Override
    public void validUserLogin() {

    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
