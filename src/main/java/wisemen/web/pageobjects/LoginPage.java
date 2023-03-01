package wisemen.web.pageobjects;

import org.openqa.selenium.WebDriver;
import wisemen.testObjects.objects.ILoginObject;
import wisemen.web.utils.WebConfig;

public class LoginPage extends BasePage implements ILoginObject {


    public LoginPage(WebDriver driver) {
        super(driver, WebConfig.getLoginEndpoint());
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
