import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assign2Ques1 {

    WebDriver driver = null;

    @DataProvider (name = "browserData")
    public Object[][] browserName(){
        return new Object[][] {
                {"chrome"},
                {"safari"}
        };
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.safaridriver().setup();
    }

    @Test (dataProvider = "browserData")
    public void openBrowser(String browser) throws Exception {
        if (browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        } else {
            throw new Exception(browser + " is not supported");
        }

        driver.get("https://uitest.automationtester.uk/basic-first-form-demo.html");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
