package wisemen.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import wisemen.mobile.utils.MobileConfig;
import wisemen.testObjects.objects.ILoginObject;

public class LoginScreen extends BaseScreen implements ILoginObject {
    public LoginScreen(AndroidDriver driver) {
        super(driver, MobileConfig.getLoginEndpoint());
    }

    @Override
    public void fillInUsername(String username) {

    }

    @Override
    public void fillInPassword(String password) {

    }

    @Override
    public void clickLogin() {

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
