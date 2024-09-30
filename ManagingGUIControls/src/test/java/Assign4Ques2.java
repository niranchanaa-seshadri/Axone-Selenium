import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Assign4Ques2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.bbc.co.uk/");
    }

    @Test
    public void getLinkTexts(){
        List<WebElement> menuList = driver.findElements(By.cssSelector("ul[class*=NavigationBarLinkList-En] li"));
        System.out.println("*******");
        for (WebElement menu : menuList) {
            System.out.println(menu.findElement(By.tagName("a")).getAttribute("href"));
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
