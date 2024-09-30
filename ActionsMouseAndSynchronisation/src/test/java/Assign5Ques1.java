import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class Assign5Ques1 {

    WebDriver driver;
    String secondWindowHandle;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        driver.manage().window().maximize();
        System.out.println("The default window is " + driver.getTitle());
    }

    @Test
    public void navigateToNewWindow()  {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://seleniumpractice.axone-tech.uk/index.php?controller=prices-drop");
        secondWindowHandle = driver.getWindowHandle();
        System.out.println("New window title is " + driver.getTitle());
    }

    @Test (dependsOnMethods = {"navigateToNewWindow"})
    public void openNewTab()  {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://seleniumpractice.axone-tech.uk/index.php?controller=authentication&back=my-account");
        System.out.println("New tab title is " + driver.getTitle());
        driver.findElement(By.id("email_create")).sendKeys("Selenium4@axone.uk");
        driver.findElement(By.id("SubmitCreate")).click();
        System.out.println("New tab navigated to " + driver.getTitle());

        driver.switchTo().window(secondWindowHandle);
        System.out.println("Current window = "+ driver.getTitle());

        driver.findElement(By.id("search_query_top")).sendKeys("shirt");
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        System.out.println("Searched for shirts. Navigated to " + driver.getTitle());
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Teardown being called");
        driver.quit();
    }
}
