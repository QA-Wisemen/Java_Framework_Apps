package wisemen.mobile.screenObjects.Android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.reporters.jq.Main;
import wisemen.mobile.screenObjects.BaseScreen;
import wisemen.mobile.screenObjects.MainScreen;
import wisemen.mobile.utils.MobileConfig;

public class MainScreenAndroid extends BaseScreen implements MainScreen {
    private String appPackage = MobileConfig.getAndroidAppPackage();
    private By btnAllowLocationWhileUsingApp = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

    //private By btnMenu = By.id(appPackage + ":id/mtbDashboard"); //ID staat op het verkeerde element
    private By btnMenu = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.cardview.widget.CardView/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton");
    //Dit XPath kan veel beter

    private By btnLogout = By.id(appPackage + ":id/logout");

    private By btnLogoutConfirmation = By.id(appPackage + ":id/md_button_positive");

    public MainScreenAndroid(AppiumDriver driver) {
        super(driver);
    }

    public void clickAllowLocationWhileUsingApp(){
        wait.until(ExpectedConditions.elementToBeClickable(btnAllowLocationWhileUsingApp)).click();
    }

    public void openMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(btnMenu)).click();
    }

    public void clickLogout(){
        wait.until(ExpectedConditions.elementToBeClickable(btnLogout)).click();
    }

    public void clickConfirmLogout(){
        wait.until(ExpectedConditions.elementToBeClickable(btnLogoutConfirmation)).click();
    }
}
