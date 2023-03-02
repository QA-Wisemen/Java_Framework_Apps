package mobile.abb;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import wisemen.mobile.screenObjects.AllScreens;

import java.util.concurrent.TimeUnit;

import static com.google.common.truth.Truth.assertThat;

public class SignUpTest {
    AllScreens screens;

    @BeforeClass
    public void testSetup(){
        screens = new AllScreens();
    }

    @Test
    public void clickSignUp() throws InterruptedException {
        screens.login.clickSignUp();
        assertThat(screens.signUpScreen.getAlreadyAccountBtn().isDisplayed()).isTrue();
    }
}
