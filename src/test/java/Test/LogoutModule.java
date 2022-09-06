package Test;

import Pages.LoginPage;
import org.testng.annotations.Test;

public class LogoutModule extends BaseTest {

    @Test(dataProvider="WebsiteLoginData")
    public void Logout(String url, String username, String password){
        pageFactory.getLoginPage().Login(url, username, password);
        pageFactory.getLoginPage().Logout();
    }
}