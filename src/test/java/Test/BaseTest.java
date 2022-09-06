package Test;

import Pages.PageFactory;
import ReadExcelData.ExcelDataConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public class BaseTest {
    private static WebDriver driver;
    protected PageFactory pages;
    @BeforeClass
    public void testbase() {
        Properties prop = new Properties();
//      System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekJoshi\\IdeaProjects\\Framework\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pages = new PageFactory(driver);
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\VivekJoshi\\Desktop\\SeleniumFramework\\DemoInfostride\\src\\test\\java\\ConfigProperties\\Config\\Config.properties");
            prop = new Properties();
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }
    //    static WebDriver driver;
//    protected PageFactory pageFactory;
//
//    @Parameters("browserName")
//    @BeforeClass
//    public void setUp(String browserName) throws MalformedURLException {
//
//        if(browserName.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            pageFactory=new PageFactory(driver);
//        }
//        else if(browserName.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//            driver.manage().window().maximize();
//            pageFactory=new PageFactory(driver);
//        }
//    }
    public static WebDriver getDrivers() {
        return driver;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
//    @DataProvider(name = "WebsiteLoginData")
//    public String[][] passData() throws IOException {
//        String excelSheetPath = System.getProperty("user.dir");
//        ExcelDataConfig config = new ExcelDataConfig(excelSheetPath+"//TestData//TestExceldata.xls");
//        int rows = config.getRowCount(1);
//        int cols = config.getCellCount(1,1);
//        String[][] data = new String[rows][cols];
//        for(int i=1;i<=rows;i++){
//            for(int j=0; j<cols; j++) {
//                data[i-1][j] = config.getData(1, i, j);
//            }
//        }
//        return data;
//    }
//    @DataProvider(name = "AddUserData")
//    public String[][] passDataForUers() throws IOException {
//        String excelSheetPath = System.getProperty("user.dir");
//        ExcelDataConfig config = new ExcelDataConfig(excelSheetPath+"//TestData//TestExceldata.xls");
//        int rows = config.getRowCount(0);
//        int cols = config.getCellCount(0,1);
//        String[][] data = new String[rows][cols];
//        for(int i=1;i<=rows;i++){
//            for(int j=0; j<cols; j++) {
//                data[i-1][j] = config.getData(0, i, j);
//            }
//        }
//        return data;
