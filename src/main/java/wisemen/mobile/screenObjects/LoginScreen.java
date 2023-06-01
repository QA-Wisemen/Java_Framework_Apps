package wisemen.mobile.screenObjects;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface LoginScreen {

    void clickSignUp();

    void clickLanguages();

    WebElement getLanguageNorsk();

    boolean errorMsgIsDisplayed();
}
