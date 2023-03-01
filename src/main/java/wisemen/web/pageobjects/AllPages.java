package wisemen.web.pageobjects;

import org.openqa.selenium.WebDriver;
import wisemen.testObjects.objects.IAllObjects;
import wisemen.testObjects.objects.ILoginObject;
import wisemen.web.utils.BrowserUtil;

//An allPages object wil make it possible to refer to all the pages from your tests without the hassle of importing them one by one.
public class AllPages implements IAllObjects {
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
