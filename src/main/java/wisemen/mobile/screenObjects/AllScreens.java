package wisemen.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import wisemen.mobile.utils.MobileUtil;
import wisemen.testObjects.objects.IAllObjects;
import wisemen.testObjects.objects.ILoginObject;

public class AllScreens implements IAllObjects {
    public LoginScreen login;
    private AndroidDriver driver;

    //An allScreens object wil make it possible to refer to all the screens from your tests without the hassle of importing them one by one.
    public AllScreens(){
        driver = MobileUtil.createDriverWithBrowser();
        login = new LoginScreen(driver);
    }

    @Override
    public ILoginObject loginObject() {
        return login;
    }

    public void quit(){
        driver.quit();
    }
}
