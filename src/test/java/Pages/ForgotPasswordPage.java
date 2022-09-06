package Pages;

import Configuration.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ForgotPasswordPage {
    WebDriver driver;

    @FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
    private WebElement ForgetPassword;

    @FindBy(id="securityAuthentication_userName")
    private WebElement UserName;

    @FindBy(id="btnSearchValues")
    private WebElement ResetPassword;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void ForgetPassword(String username) {
        ForgetPassword.click();
        ExtentLogger.pass("Clicked on forget password button.");
        UserName.sendKeys(username);
        ExtentLogger.pass("Enter username:- "+username);
        ResetPassword.click();
        ExtentLogger.pass("Clicked on reset password button");
    }
}