package Base;

import Pages.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {

    public WebDriver driver;
    public final Properties properties;
    public static final int WAIT_TIME_IN_SEC = 10;
    public ExtentReports report = new ExtentReports();
    public ExtentTest test;


    public BasePage() {
        properties = new Properties();
        try {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/SparkReport.html");
            report.attachReporter(spark);
            FileInputStream fis = new FileInputStream("src/test/resources/application.properties");
            properties.load(fis);
        } catch(IOException exception){
            throw new RuntimeException(exception);
        }
    }

    public WebDriver launchBrowser(){
        String browser = properties.getProperty("browser");
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser value");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME_IN_SEC));
        return driver;
    }

    public HomePage navigateToURL(WebDriver driver){
        driver.get(properties.getProperty("url"));
        return new HomePage(driver);
    }

}
