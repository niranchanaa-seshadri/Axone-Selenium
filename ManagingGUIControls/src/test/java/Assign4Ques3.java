import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assign4Ques3 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.zoho.com/");
    }

    @Test
    public void fetchEmail() {
        driver.findElement(By.xpath("//div[@class='signupcontainer']/a[@class='login']")).click();
        driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("abc.def@gmail.com");
        System.out.println(driver.findElement(By.xpath("//input[@id='login_id']")).getAttribute("value"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
