package mobile.abb;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import wisemen.mobile.screenObjects.AllScreens;

import static com.google.common.truth.Truth.assertThat;

public class SignUpTest {
    AllScreens screens;

    @BeforeClass
    public void testSetup(){
        screens = new AllScreens();
        //testObject.loginObject().navigateTo();
    }

    @Test
    public void clickSignUp(){
        screens.login.clickSignUp();
        assertThat(screens.signUpScreen.getAlreadyAccountBtn().isDisplayed()).isTrue();
    }
}
