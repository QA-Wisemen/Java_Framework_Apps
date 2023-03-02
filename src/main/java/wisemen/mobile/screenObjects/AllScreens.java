package wisemen.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import wisemen.mobile.utils.MobileUtil;

public class AllScreens {

    private AndroidDriver driver;
    public LoginScreen login;
    public SignUpScreen signUpScreen;


    //An allScreens object wil make it possible to refer to all the screens from your tests without the hassle of importing them one by one.
    public AllScreens() {
        //driver = MobileUtil.createDriverWithBrowser();
        driver = MobileUtil.createDriverWithApp();
        login = new LoginScreen(driver);
        signUpScreen = new SignUpScreen(driver);
    }

    public void quit() {
        driver.quit();
    }
}
