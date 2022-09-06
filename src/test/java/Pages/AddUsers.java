package Pages;

import Configuration.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUsers {
    WebDriver driver;

    @FindBy(xpath="//b[contains(text(),'Admin')]")
    private WebElement Admin;

    @FindBy(id="menu_admin_UserManagement")
    private WebElement User_Management;

    @FindBy(id="menu_admin_viewSystemUsers")
    private WebElement Users;

    @FindBy(id="searchSystemUser_userName")
    private WebElement SearchUser;

    @FindBy(id="searchBtn")
    private WebElement SearchButton;

    @FindBy(id="ohrmList_chkSelectRecord_10")
    private WebElement CheckBox;

    @FindBy(id="btnAdd")
    private WebElement AddButton;

    public AddUsers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void ClickOnUser(){
        Admin.click();
        ExtentLogger.pass("Clicked on admin icon");
        User_Management.click();
        ExtentLogger.pass("Clicked on user management option");
        Users.click();
        ExtentLogger.pass("Clicked on users.");
    }

    public void SearchUser(String user){
        SearchUser.sendKeys(user);
        ExtentLogger.pass("Searched user :-"+ user);
        SearchButton.click();
        ExtentLogger.pass("Clicked on search button.");
    }

    public void AddUser(){
        CheckBox.click();
        ExtentLogger.pass("Select user");
        AddButton.click();
        ExtentLogger.pass("Clicked on add button.");
    }
}