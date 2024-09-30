import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assign5Ques3 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
    }

    @Test
    public void dragSlider() {
        Actions action = new Actions(driver);
        action.clickAndHold(driver.findElement(By.tagName("input"))).moveByOffset(30,0).release().perform();
        int sliderVal = Integer.parseInt(driver.findElement(By.id("range")).getText());
        Assert.assertEquals(sliderVal, 4);
    }

    //Arrow right moves it too much to the right. Check with Sridhar if not answered in assignment video
    @Test
    public void moveSliderWithKeyboard() throws InterruptedException {
        Actions action = new Actions(driver);
        action.click(driver.findElement(By.tagName("input"))).sendKeys(Keys.ARROW_RIGHT).perform();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
