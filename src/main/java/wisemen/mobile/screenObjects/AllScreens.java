package wisemen.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import wisemen.mobile.utils.MobileConfig;
import wisemen.mobile.utils.MobileUtil;
import wisemen.testObjects.objects.IAllObjects;
import wisemen.testObjects.objects.ILoginObject;

public class AllScreens implements IAllObjects {

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

    @Override
    public ILoginObject loginObject() {
        return login;
    }

    public void quit() {
        driver.quit();
    }
}
