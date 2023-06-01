package wisemen.mobile.screenObjects;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import wisemen.mobile.screenObjects.Android.*;
import wisemen.mobile.utils.MobileUtil;

import java.io.File;
import java.io.IOException;

public class AllScreens {
    private AppiumDriver driver;
    public LoginAndroid loginScreen;
    public SignUpAndroid signUpScreen;
    public RegisterSuccessScreen registerSuccessScreen;
    public ForgotPasswordScreen forgotPasswordScreen;
    public MainScreen mainScreen;
    public ConnectChargerScreen connectChargerScreen;

    //An allScreens object wil make it possible to refer to all the screens from your tests without the hassle of importing them one by one.
    public AllScreens() {
        //driver = MobileUtil.createDriverWithBrowser();
        //driver = MobileUtil.createDriverWithApp();
        driver = MobileUtil.createDriver();
        switch (MobileUtil.executionOS) {
            case ANDROID:
                //TimeUnit.SECONDS.sleep(5);
                loginScreen = new LoginAndroid(driver);
                signUpScreen = new SignUpAndroid(driver);
                registerSuccessScreen = new RegisterSuccessAndroid(driver);
                forgotPasswordScreen = new ForgotPasswordAndroid(driver);
                mainScreen = new MainAndroid(driver);
                connectChargerScreen = new ConnectChargerAndroid(driver);
                break;
            case IOS:
                //searchPage = new ContactSearchPageIOS(driver());
                //detailPage = new ContactDetailPageIOS(driver());
                break;
        }
    }

    public void quit() {
        driver.quit();
    }

    public void back() {
        driver.navigate().back();
    }

    public void screenshot(String filename) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //File srcFile = driver.getScreenshotAs(OutputType.FILE);
            //String filename = UUID.randomUUID().toString();
            //File targetFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\ImagesTestRun\\" + filename + ".png");
            File targetFile = new File(System.getProperty("user.dir") + "/target/Screenshots/" + filename + ".png");
            FileUtils.copyFile(srcFile, targetFile);
            System.out.println("Screenshot");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
