package Configuration;

import Test.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listeners extends BaseTest implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReports();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result){
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        Object Listeners = result.getInstance();
        WebDriver webDriver = ((BaseTest) Listeners).getDrivers();
        if (webDriver != null)
        {
            ExtentReport.test.pass(result.getMethod().getMethodName() + " is passed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
    }

    @Override
    public void onTestFailure(ITestResult result){
        Object Listeners = result.getInstance();
        WebDriver webDriver = ((BaseTest) Listeners).getDrivers();
        if (webDriver != null) {
            ExtentReport.test.fail(MarkupHelper.createLabel(String.valueOf(result.getThrowable()), ExtentColor.RED));
            ExtentReport.test.fail(result.getMethod().getMethodName() + " is failed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result){
        ExtentLogger.skip(result.getMethod().getMethodName() +" is skiped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public static String getBase64Image(){
        return ((TakesScreenshot) BaseTest.getDrivers()).getScreenshotAs(OutputType.BASE64);
    }
}
