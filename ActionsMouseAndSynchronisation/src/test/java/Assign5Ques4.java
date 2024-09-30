import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Assign5Ques4 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://uitest.automationtester.uk/bootstrap-dual-list-box-demo.html");
        driver.manage().window().maximize();
    }

    //Check with Sridhar how to use Assert.assertListContains()
    @Test
    public void testMove() {
        driver.findElement(By.xpath("//div[@class='dual-list list-left col-md-5']//input")).sendKeys("bootstrap");
        driver.findElement(By.xpath("//div[@class='dual-list list-left col-md-5']//a[contains(@class, 'btn btn-default selector')]")).click();
        //driver.findElement(By.xpath("//div[@class='dual-list list-left col-md-5']//li[@class='list-group-item']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm move-right']")).click();
        List<String> rightList =  driver.findElements(By.xpath("//div[@class='dual-list list-right col-md-5']//li")).stream().map(WebElement::getText).collect(Collectors.toList());
        Assert.assertTrue(rightList.contains("bootstrap-duallist"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
