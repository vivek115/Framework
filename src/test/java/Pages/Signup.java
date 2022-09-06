package Pages;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
public class Signup {
    WebDriver driver;
    @FindBy(css = "[name='name']")
    private WebElement nameEditBox;
    @FindBy(xpath = "//label[contains(text(),'Check me out if you Love IceCreams!')]")
    private WebElement Icelabel;
    @FindBy(id = "inlineRadio1")
    private WebElement RBD;
    @FindBy(xpath = "(//input[@class='form-control ng-untouched ng-pristine ng-invalid'])[1]")
    private WebElement click_on_name;
    @FindBy(xpath = "(//input[@class='form-control ng-untouched ng-pristine ng-invalid'])[2]")
    private WebElement click_on_email;
    @FindBy(xpath = "//input[@id='exampleInputPassword1']")
    private WebElement click_on_password;
    @FindBy(xpath = "//select[@id='exampleFormControlSelect1']")
    private WebElement Click_On_dropdownarrow;
    @FindBy(xpath = "//select[@id='exampleFormControlSelect1']//option[2]")
    private WebElement select_gender;
    @FindBy(xpath = "(//div[@class='form-check form-check-inline'])[2]")
    private WebElement Employee_Status;
    @FindBy(xpath = "//input[@class='btn btn-success']")
    private WebElement Click_on_submitbutton;
    public Signup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @Test
    public void Login() throws IOException {
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
        click_on_email.sendKeys("vivek@yopmail.com");





        click_on_name.sendKeys("vivek");
        click_on_password.sendKeys("Vivek@123");
        driver.findElement(with(By.tagName("input")).toLeftOf(Icelabel)).click();
        Click_On_dropdownarrow.click();
        Employee_Status.click();
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(RBD)).getText());
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // fileutils is used to copy the file from the src object to out local mission
        FileUtils.copyFile(src,new File("C://Users//VivekJoshi//Desktop//Scrrenshot.png"));
        driver.close();
    }
}
