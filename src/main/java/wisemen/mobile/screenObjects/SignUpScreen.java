package wisemen.mobile.screenObjects;

public interface SignUpScreen {
    void fillInUsername(String username);
    void fillInEmail(String email);
    void fillInPassword(String password);
    void fillInConfirmPassword(String password);
    void clickConfirmPrivacyPolicy();
    void clickSignUp();
    void signUp(String username, String email, String password);
    void clickAlreadyAccount();

}
