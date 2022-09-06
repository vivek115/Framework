package Test;
import org.testng.annotations.Test;
public class AddUser extends BaseTest {
    @Test(dataProvider="WebsiteLoginData")
    public void LoginThroughExcelData(String url, String username, String password) throws InterruptedException {
        pageFactory.getLoginPage().Login(url, username, password);
    }
    @Test(dependsOnMethods = "LoginThroughExcelData", dataProvider="AddUserData")
    public void AddUsers(String user) {
        pageFactory.getAddUsers().ClickOnUser();
        pageFactory.getAddUsers().SearchUser(user);
        pageFactory.getAddUsers().AddUser();
    }
}
