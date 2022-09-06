package Test;

public class VerifySignUp extends BaseTest {

    public void Logout(String url, String username, String password){
        pageFactory.getLoginPage().Login(url, username, password);
        pageFactory.getLoginPage().Logout();
    }
}
