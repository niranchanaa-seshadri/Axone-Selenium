import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assign4Ques5 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://uitest.automationtester.uk/basic-first-form-demo.html");
    }

    @Test
    public void fetchAllCheckboxValues(){
        String allExamplesClassAtrribute = driver.findElement(By.cssSelector("ul[id='treemenu']>li>i")).getAttribute("class");
        if (allExamplesClassAtrribute.contains("glyphicon-chevron-right")){
            driver.findElement(By.cssSelector("ul[id='treemenu']>li>i")).click();
        }

        String inputFormsClassAttribute = driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>i")).getAttribute("class");
        if(inputFormsClassAttribute.contains("glyphicon-chevron-right")){
            driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>i")).click();
        }

        driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>ul>li>a[href='./basic-checkbox-demo.html']")).click();

        driver.findElement(By.cssSelector("div[class='col-md-6 text-left']>div[class='panel panel-default']:nth-of-type(2)>div[class='panel-body']>div[class='checkbox']:first-of-type>label>input")).click();

        List<WebElement> checkboxLabels = driver.findElements(By.cssSelector("div[class='col-md-6 text-left']>div[class='panel panel-default']:nth-of-type(2)>div[class='panel-body']>div[class='checkbox']>label"));
        for(WebElement label : checkboxLabels){
            boolean isChecked = label.findElement(By.cssSelector("input[class='cb1-element']")).isSelected();
            if(isChecked){
                System.out.println(label.getText() + " is selected");
            }
            else {
                System.out.println(label.getText() + " is not selected");
            }
        }
    }

    @Test
    public void checkAll() throws InterruptedException {
        String allExamplesClassAtrribute = driver.findElement(By.cssSelector("ul[id='treemenu']>li>i")).getAttribute("class");
        if (allExamplesClassAtrribute.contains("glyphicon-chevron-right")){
            driver.findElement(By.cssSelector("ul[id='treemenu']>li>i")).click();
        }

        String inputFormsClassAttribute = driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>i")).getAttribute("class");
        if(inputFormsClassAttribute.contains("glyphicon-chevron-right")){
            driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>i")).click();
        }

        driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>ul>li>a[href='./basic-checkbox-demo.html']")).click();

        String areAllChecked = driver.findElement(By.cssSelector("input[id='check1']")).getAttribute("value");
        Thread.sleep(2000);
        if(areAllChecked.equalsIgnoreCase("Check All")){
            driver.findElement(By.cssSelector("input[id='check1']")).click();
            Thread.sleep(2000);
        }
        areAllChecked = driver.findElement(By.cssSelector("input[id='check1']")).getAttribute("value");
        if(areAllChecked.equalsIgnoreCase("Uncheck All")){
            driver.findElement(By.cssSelector("input[id='check1']")).click();
            Thread.sleep(2000);
        }

    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
