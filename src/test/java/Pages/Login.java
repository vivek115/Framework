package Pages;

import Configuration.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    static WebDriver driver;

    By Username = By.name("txtUsername");
    By Password = By.name("txtPassword");
    By LoginButton = By.name("Submit1");
    By Profile = By.id("welcome");
    By Logout = By.xpath("//a[contains(text(),'Logout')]");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void GoToUrl(String url){
        driver.get(url);
    }

    public void enterUsernamePassword(String username, String password){
        driver.findElement(Username).sendKeys(username);
        driver.findElement(Password).sendKeys(password);
    }

    public void clickOnLoginButton(){
        driver.findElement(LoginButton).click();
    }
}
