package wisemen.testObjects.objects;

public interface ILoginObject extends IBaseObject{
    void fillInUsername(String username);
    void fillInPassword(String password);
    void clickLogin();
    void login(String username, String password);
    void validUserLogin();
    String getErrorMessage();
}
