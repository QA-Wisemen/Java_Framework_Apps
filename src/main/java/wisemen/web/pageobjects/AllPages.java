package wisemen.web.pageobjects;

import org.openqa.selenium.WebDriver;
import wisemen.testObjects.objects.ILoginObject;
import wisemen.web.utils.BrowserUtil;

public class AllPages {
    public LoginPage loginPage;
    private WebDriver driver;

    public AllPages(){
        driver = BrowserUtil.createBrowser();
        loginPage = new LoginPage(driver);
    }

    public void quit(){
        driver.quit();
    }

    @Override
    public ILoginObject loginObject() {
        return loginPage;
    }
}
