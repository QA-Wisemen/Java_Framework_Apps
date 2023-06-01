package mobile.abb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import wisemen.mobile.screenObjects.AllScreens;
import wisemen.mobile.screenObjects.Android.LoginScreenAndroid;
import wisemen.mobile.screenObjects.LoginScreen;
import wisemen.mobile.utils.MobileConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.google.common.truth.Truth.assertThat;

public class SignUpTest {
    AllScreens screens;

    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        screens = new AllScreens();
        TimeUnit.SECONDS.sleep(5);
    }

    @AfterMethod
    public void afterTest() {
        screens.quit();
    }
/*
    @Test
    public void clickSignUp() throws InterruptedException {
        screens.loginScreen.clickSignUp();
        TimeUnit.SECONDS.sleep(1);
        assertThat(screens.signUpScreen.getBtnAlreadyAccount().isDisplayed()).isTrue();
    }

    @Test
    public void signUp() {
        screens.loginScreen.clickSignUp();
        screens.signUpScreen.signUp("Test", "Test@Test.com", "Test1234");
        assertThat(screens.registerSuccessScreen.getBtnSuccess().isDisplayed()).isTrue();
    }
 */
    final String testRun = "1";

    @Test
    public void CreatingAccounts() throws InterruptedException {
        for (int i = 0; i < LoginScreenAndroid.LANGUAGES.size(); i++) {
            System.out.println("Register test for " + LoginScreenAndroid.LANGUAGES.get(i));

            screens.loginScreen.clickLanguages();
            screens.loginScreen.getLanguage(LoginScreenAndroid.LANGUAGES.get(i)).click();
            screens.loginScreen.clickSignUp();

            screens.signUpScreen.clickTermsAndConditions(i);
            TimeUnit.SECONDS.sleep(8);
            screens.screenshot(LoginScreenAndroid.LANGUAGES_ENGLISH.get(i) + "TermsAndConditions");
            TimeUnit.SECONDS.sleep(1);
            screens.back();
            TimeUnit.SECONDS.sleep(2);
            screens.signUpScreen.clickPrivacyPolicy(i);
            TimeUnit.SECONDS.sleep(8);
            screens.screenshot(LoginScreenAndroid.LANGUAGES_ENGLISH.get(i) + "PrivacyPolicy");
            TimeUnit.SECONDS.sleep(1);
            screens.back();
            TimeUnit.SECONDS.sleep(2);

            screens.signUpScreen.signUp("AutomationTest" + LoginScreenAndroid.LANGUAGES_ENGLISH.get(i), "test+" + LoginScreenAndroid.LANGUAGES_ENGLISH.get(i) + testRun + "@appwise.be", "Test1234");
            TimeUnit.SECONDS.sleep(2);


/*
            if (screens.registerSuccessScreen.getBtnSuccess().isDisplayed()){
                screens.registerSuccessScreen.getBtnSuccess().click();
            } else {
                TimeUnit.SECONDS.sleep(2);
                screens.screenshot(LoginScreenAndroid.LANGUAGES_ENGLISH.get(i) + "AccountExists");
            }

 */

            if (screens.signUpScreen.errorMsgExists()){
                TimeUnit.SECONDS.sleep(2);
                screens.screenshot(LoginScreenAndroid.LANGUAGES_ENGLISH.get(i) + "AccountExists");
            } else {
                screens.registerSuccessScreen.getBtnSuccess().click();
            }

            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Test
    public void ResetPasswords() throws InterruptedException {
        for (int i = 0; i < LoginScreenAndroid.LANGUAGES.size(); i++) {
            System.out.println("Reset password test for " + LoginScreenAndroid.LANGUAGES.get(i));

            screens.loginScreen.clickLanguages();
            screens.loginScreen.getLanguage(LoginScreenAndroid.LANGUAGES.get(i)).click();

            screens.loginScreen.clickForgotPassword();

            screens.forgotPasswordScreen.fillInEmail("test+" + LoginScreenAndroid.LANGUAGES_ENGLISH.get(i) + testRun + "@appwise.be");
            screens.forgotPasswordScreen.clickSendMail();
            TimeUnit.SECONDS.sleep(5);


            screens.back();
            TimeUnit.SECONDS.sleep(2);
            screens.back();
            TimeUnit.SECONDS.sleep(2);
        }
    }

    @Test
    public void LoginWithAllAccounts() throws InterruptedException {
        for (int i = 0; i < LoginScreenAndroid.LANGUAGES.size(); i++) {
            System.out.println("Login test for " + LoginScreenAndroid.LANGUAGES.get(i));

            screens.loginScreen.clickLanguages();
            screens.loginScreen.getLanguage(LoginScreenAndroid.LANGUAGES.get(i)).click();
            screens.loginScreen.login("test+" + LoginScreenAndroid.LANGUAGES_ENGLISH.get(i) + testRun + "@appwise.be", "Test1234");
            TimeUnit.SECONDS.sleep(12);

            if (i == 0){
                screens.mainScreen.clickAllowLocationWhileUsingApp();
                TimeUnit.SECONDS.sleep(2);
            }
            screens.back();
            screens.mainScreen.openMenu();
            screens.screenshot(LoginScreenAndroid.LANGUAGES_ENGLISH.get(i) + "Menu");
            TimeUnit.SECONDS.sleep(2);
            screens.mainScreen.clickLogout();
            screens.mainScreen.clickConfirmLogout();
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
