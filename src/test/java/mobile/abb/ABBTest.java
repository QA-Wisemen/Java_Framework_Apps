package mobile.abb;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;
import wisemen.mobile.screenObjects.AllScreens;
import wisemen.mobile.screenObjects.Android.LoginAndroid;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.google.common.truth.Truth.assertThat;

public class ABBTest {
    final String testRun = "1";
    AllScreens screens;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir") + "/target/Screenshots/"));
    }

    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        screens = new AllScreens();
        TimeUnit.SECONDS.sleep(5);
    }

    @AfterMethod
    public void afterTest() {
        screens.quit();
    }

    @Test
    public void CreatingAccounts() throws InterruptedException {
        for (int i = 0; i < LoginAndroid.LANGUAGES.size(); i++) {
            System.out.println("Register test for " + LoginAndroid.LANGUAGES.get(i));

            screens.loginScreen.clickLanguages();
            screens.loginScreen.getLanguage(LoginAndroid.LANGUAGES.get(i)).click();
            screens.loginScreen.clickSignUp();

            screens.signUpScreen.clickTermsAndConditions(i);
            TimeUnit.SECONDS.sleep(8);
            screens.screenshot(LoginAndroid.LANGUAGES_ENGLISH.get(i) + "TermsAndConditions");
            TimeUnit.SECONDS.sleep(1);
            screens.back();
            TimeUnit.SECONDS.sleep(2);
            screens.signUpScreen.clickPrivacyPolicy(i);
            TimeUnit.SECONDS.sleep(8);
            screens.screenshot(LoginAndroid.LANGUAGES_ENGLISH.get(i) + "PrivacyPolicy");
            TimeUnit.SECONDS.sleep(1);
            screens.back();
            TimeUnit.SECONDS.sleep(2);

            screens.signUpScreen.signUp("AutomationTest" + LoginAndroid.LANGUAGES_ENGLISH.get(i), "test+" + LoginAndroid.LANGUAGES_ENGLISH.get(i) + testRun + "@appwise.be", "Test1234");
            TimeUnit.SECONDS.sleep(2);

            if (screens.signUpScreen.errorMsgIsDisplayed()) {
                TimeUnit.SECONDS.sleep(2);
                screens.screenshot(LoginAndroid.LANGUAGES_ENGLISH.get(i) + "AccountExists");
            } else {
                screens.registerSuccessScreen.getBtnSuccess().click();
            }

            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Test
    public void ResetPasswords() throws InterruptedException {
        for (int i = 0; i < LoginAndroid.LANGUAGES.size(); i++) {
            System.out.println("Reset password test for " + LoginAndroid.LANGUAGES.get(i));

            screens.loginScreen.clickLanguages();
            screens.loginScreen.getLanguage(LoginAndroid.LANGUAGES.get(i)).click();

            screens.loginScreen.clickForgotPassword();

            screens.forgotPasswordScreen.fillInEmail("test+" + LoginAndroid.LANGUAGES_ENGLISH.get(i) + testRun + "@appwise.be");
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
        for (int i = 0; i < LoginAndroid.LANGUAGES.size(); i++) {
            System.out.println("Login test for " + LoginAndroid.LANGUAGES.get(i));

            screens.loginScreen.clickLanguages();
            screens.loginScreen.getLanguage(LoginAndroid.LANGUAGES.get(i)).click();
            screens.loginScreen.login("test+" + LoginAndroid.LANGUAGES_ENGLISH.get(i) + testRun + "@appwise.be", "Test1234");

            if (!screens.loginScreen.errorMsgIsDisplayed()) {
                TimeUnit.SECONDS.sleep(5);
                if (i == 0) {
                    screens.mainScreen.clickAllowLocationWhileUsingApp();
                    TimeUnit.SECONDS.sleep(2);
                }
                screens.back();
                screens.mainScreen.openMenu();
                screens.screenshot(LoginAndroid.LANGUAGES_ENGLISH.get(i) + "Menu");
                TimeUnit.SECONDS.sleep(2);
                screens.mainScreen.clickLogout();
                screens.mainScreen.clickConfirmLogout();
                TimeUnit.SECONDS.sleep(2);
            } else {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(LoginAndroid.LANGUAGES_ENGLISH.get(i) + " is not activated");
                screens.screenshot(LoginAndroid.LANGUAGES_ENGLISH.get(i) + "AccountIsNotActivated");
            }
        }
    }
}
