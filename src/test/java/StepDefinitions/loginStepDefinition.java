package StepDefinitions;

import Pages.Login;
import Test.BaseTest;
import TestRunner.TestRunnerClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class loginStepDefinition {

	Login login = new Login(driver);
	static WebDriver driver;

    @Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("Inside Step - user is on login page");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Login login = new Login(driver);
		login.GoToUrl("https://opensource-demo.orangehrmlive.com/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		System.out.println("Inside Step - user enters username and password");
		login.enterUsernamePassword(username,password);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("Inside Step - clicks on login button");
		login.clickOnLoginButton();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("Inside Step - user is navigated to the home page");
	}
}