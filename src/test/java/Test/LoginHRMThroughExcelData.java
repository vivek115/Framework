package Test;

import Configuration.ExtentReport;
import Pages.LoginPage;
import ReadExcelData.ExcelDataConfig;
import ReadExcelData.ReadExcel;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public final class LoginHRMThroughExcelData extends BaseTest {

    private LoginHRMThroughExcelData(){}

    @Test(dataProvider="WebsiteLoginData")
    public void LoginThroughExcelData(String url, String username, String password) {
//        LoginPage loginPage = new LoginPage(driver);
        pageFactory.getLoginPage().Login(url, username, password);
    }
}