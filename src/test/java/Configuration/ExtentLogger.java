package Configuration;

import Test.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import java.sql.Driver;
import java.lang.String.*;
import Configuration.DriverManager;

public final class ExtentLogger {

    private ExtentLogger(){

    }

    public static void pass(String message){
        ExtentReport.test.pass(message);
    }

    public static void fail(String message){
        ExtentReport.test.fail(MarkupHelper.createLabel(message,ExtentColor.RED));
    }

    public static void skip(String message){
        ExtentReport.test.skip(MarkupHelper.createLabel(message,ExtentColor.BLUE));
    }
}