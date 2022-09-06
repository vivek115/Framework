package Configuration;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class DriverManager {

    public WebDriver driver;

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    static WebDriver getDriver(){
        return dr.get();
    }

    static void setDriver(WebDriver driver){
        dr.set(driver);
    }

    static void unload(){
        dr.remove();
    }

    public WebDriver getDrivers() {
        return driver;
    }
}