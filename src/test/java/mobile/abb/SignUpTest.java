package mobile.abb;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import wisemen.mobile.screenObjects.AllScreens;

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
        assertThat(screens.signUpScreen.getBtnAlreadyAccount().isDisplayed()).isTrue();
    }

    @Test
    public void signUp() throws InterruptedException {
        screens.login.clickSignUp();
        screens.signUpScreen.SignUp("Test", "Test@Test.com", "Test123");
        //assertThat(screens.signUpScreen.getBtnAlreadyAccount().isDisplayed()).isTrue();
    }
}
