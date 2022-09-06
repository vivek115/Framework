package Pages;

import Configuration.ExtentLogger;
import Configuration.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
    WebDriver driver;

    @FindBy(name="txtUsername")
    private WebElement enterUsername;

    @FindBy(name="txtPassword")
    private WebElement enterPassword;

    @FindBy(name="Submit")
    private WebElement LoginButton;

    @FindBy(id="welcome")
    private WebElement Profile;

    @FindBy(xpath="//a[contains(text(),'Logout')]")
    private WebElement Logout;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void Login(String url,String username, String password) {
        driver.get(url);
        enterUsername.sendKeys(username);
        ExtentLogger.pass("Enter username:- "+username);
        enterPassword.sendKeys(password);
        ExtentLogger.pass("Enter password:- "+password);
        LoginButton.click();
        ExtentLogger.pass("Clicked on login button");
    }

    public void Logout(){
        Profile.click();
        ExtentLogger.pass("Clicked on profile icon");
        Logout.click();
        ExtentLogger.pass("Clicked on Logout button");
    }
}