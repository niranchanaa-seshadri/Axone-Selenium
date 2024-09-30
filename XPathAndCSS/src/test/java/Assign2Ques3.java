import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assign2Ques3 {

    WebDriver driver = null;

    @Parameters ({"browserName", "browserParam", "url"})

    @BeforeMethod
    public void setUp(String browserName, String param, String url) throws Exception {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(param);
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("edge")){
            EdgeOptions options = new EdgeOptions();
            options.addArguments(param);
            driver = new EdgeDriver(options);
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            throw new Exception(browserName + " is not valid");
        }

        driver.get(url);
    }

    @Test
    public void printDetails(){
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
