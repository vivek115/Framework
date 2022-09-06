package Test;

import Pages.ForgotPasswordPage;
import org.testng.annotations.Test;

public class ForgotPassword extends BaseTest {

    @Test(dataProvider="WebsiteLoginData")
    public void ForgetPassword(String url, String username, String password) {
        pageFactory.getForgotPasswordPage().ForgetPassword(username);
    }
}