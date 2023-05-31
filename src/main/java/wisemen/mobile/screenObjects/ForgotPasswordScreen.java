package wisemen.mobile.screenObjects;

import org.openqa.selenium.support.ui.ExpectedConditions;

public interface ForgotPasswordScreen {
    void fillInEmail(String email);

    void clickSendMail();
}
