import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assign4Ques4 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://uitest.automationtester.uk/");
    }

    @Test
    public void validateAddition(){
        driver.findElement(By.cssSelector("ul[id='treemenu']>li:first-of-type>ul:first-of-type>li:first-of-type>a")).click();
        driver.findElement(By.cssSelector("li[class='tree-branch']>ul>li>a[href='./basic-first-form-demo.html']")).click();
        driver.findElement(By.cssSelector("input[id='sum1']")).sendKeys("10");
        driver.findElement(By.cssSelector("input[id='sum2']")).sendKeys("5");
        driver.findElement(By.cssSelector("form[id='gettotal'] button")).click();
        int total = Integer.parseInt(driver.findElement(By.cssSelector("span[id='displayvalue']")).getText());
        System.out.println("Total received = "+ total);
        Assert.assertEquals(total, 15);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
