package Test;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

import javax.xml.crypto.Data;
import java.security.Key;

public class DemoTest extends BaseTest {

    @Parameters("Data")
    @Test
    public void GoogleSearch(String Data){
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys(Data, Keys.ENTER);
    }
}