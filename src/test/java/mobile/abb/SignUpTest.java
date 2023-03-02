package mobile.abb;

import org.testng.annotations.*;
import wisemen.mobile.screenObjects.AllScreens;

import static com.google.common.truth.Truth.assertThat;

public class SignUpTest {
    AllScreens screens;


    @BeforeMethod
    public void beforeTest(){
        screens = new AllScreens();
    }

    @AfterMethod
    public void afterTest(){
        screens.quit();
    }

    @Test
    public void clickSignUp() {
        screens.login.clickSignUp();
        assertThat(screens.signUpScreen.getBtnAlreadyAccount().isDisplayed()).isTrue();
    }

    @Test
    public void signUp() {
        screens.login.clickSignUp();
        screens.signUpScreen.SignUp("Test", "Test@Test.com", "Test1234");
        assertThat(screens.registerSuccesScreen.getBtnSucces().isDisplayed()).isTrue();
    }
}
