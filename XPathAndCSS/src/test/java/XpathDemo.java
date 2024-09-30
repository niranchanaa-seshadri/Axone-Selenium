import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class XpathDemo {

    WebDriver driver = null;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://uitest.automationtester.uk/basic-first-form-demo.html");
    }

    @Test
    public void actOnElementsUsingStaticMethods() {
        driver.findElement(By.id("user-message")).sendKeys("Demo msg");
        System.out.println(driver.findElement(By.className("container-fluid")).getTagName());
        System.out.println(driver.findElement(By.name("robots")).getAttribute("content"));
        System.out.println(driver.findElement(By.className("site-name")).getTagName());
        driver.findElement(By.linkText("Demo Home")).click();
    }

    @Test
    public void usingTagNameAttributeText() throws InterruptedException {
        System.out.println(driver.findElement(By.id("btn_basic_example")).getText());
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[text()='Simple Form Demo']")).click();
        Thread.sleep(5000);

        //The below don't work in the following tests if all the tests are run sequentially.
        //They work when it is part of the same test
        //They also work when I comment out the first 2 tests and run the rest separately
        System.out.println(driver.findElement(By.xpath("//div[contains(text(), 'Two Input Fields')]")).getAttribute("class"));
        System.out.println(driver.findElement(By.xpath("//input[contains(@placeholder, 'Please enter')]")).getAttribute("id"));


    }

    //Check with Sridhar
/*
    @Test
    public void usingContains(){
        //System.out.println(driver.findElement(By.xpath("//div[contains(text(), 'Two Input Fields')]")).getAttribute("class"));
        //System.out.println(driver.findElement(By.xpath("//input[contains(@placeholder, 'Please enter')]")).getAttribute("id"));
    }

    @Test
    public void usingStartsWith() throws InterruptedException {
        driver.findElement(By.id("sum1")).sendKeys("10");
        driver.findElement(By.id("sum2")).sendKeys("20");
        driver.findElement(By.xpath("//button[starts-with(text(), 'Get')]")).click();
        Thread.sleep(5000);
    }

     */

    @Test
    public void usingAndOr(){
        System.out.println(driver.findElement(By.xpath("//form[@id='gettotal' and @method='post']/div/label")).getText());
        System.out.println(driver.findElement(By.xpath("//form[@id='gettotal']/following-sibling::div/label")).getText());
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
