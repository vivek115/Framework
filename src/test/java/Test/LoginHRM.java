package Test;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginHRM extends BaseTest {

    @Parameters({"url","username","password"})
    @Test
    public void Login(String url, String username, String password){
        pageFactory.getLoginPage().Login(url, username, password);
    }
}