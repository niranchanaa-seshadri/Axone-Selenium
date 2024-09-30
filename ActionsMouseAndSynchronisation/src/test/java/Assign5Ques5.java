import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assign5Ques5 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://uitest.automationtester.uk/bootstrap-download-progress-demo.html");
        driver.manage().window().maximize();
    }

    @Test
    public void explicitlyWait() {
        driver.findElement(By.id("cricle-btn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='percenttext']"), "100%"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
