import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Assign5Ques2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://uitest.automationtester.uk/drag-and-drop-demo.html");
        driver.manage().window().maximize();
    }

    @Test
    public void dragAndDrop(){
        Actions action = new Actions(driver);
        List<WebElement> draggableItems = driver.findElements(By.xpath("//div[@id='todrag']/span"));
        List<String> draggedItemNames = new ArrayList<>();
        WebElement dropZone = driver.findElement(By.id("mydropzone"));
        for (WebElement draggableItem : draggableItems) {
            draggedItemNames.add(draggableItem.getText());
            action.dragAndDrop(draggableItem, dropZone).perform();
        }
        List<String> droppedItemNames = driver.findElements(By.xpath("//div[@id = 'droppedlist']/span")).stream().map(WebElement::getText).collect(Collectors.toList());

        Assert.assertEquals(droppedItemNames , draggedItemNames);
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
