import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assign4Ques6 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://uitest.automationtester.uk/basic-first-form-demo.html");
    }

    @Test
    public void fetchAllAgeGroups(){
        String allExamplesClassAtrribute = driver.findElement(By.cssSelector("ul[id='treemenu']>li>i")).getAttribute("class");
        if (allExamplesClassAtrribute.contains("glyphicon-chevron-right")){
            driver.findElement(By.cssSelector("ul[id='treemenu']>li>i")).click();
        }

        String inputFormsClassAttribute = driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>i")).getAttribute("class");
        if(inputFormsClassAttribute.contains("glyphicon-chevron-right")){
            driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>i")).click();
        }

        driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>ul>li>a[href='./basic-radiobutton-demo.html']")).click();

        driver.findElement(By.xpath("//div/h4[text() = 'Age Group :']/following-sibling::label/input[@value='0 - 5']")).click();

        List<WebElement> ageGroupLabels = driver.findElements(By.xpath("//div/h4[text() = 'Age Group :']/following-sibling::label/input"));

        for(WebElement ageGroupLabel : ageGroupLabels){
            String value = ageGroupLabel.getAttribute("value");
            boolean isSelected = ageGroupLabel.isSelected();
            System.out.println(value + " is selected? " + isSelected);
        }
    }

    @Test
    public void checkGetValues() {
        String allExamplesClassAtrribute = driver.findElement(By.cssSelector("ul[id='treemenu']>li>i")).getAttribute("class");
        if (allExamplesClassAtrribute.contains("glyphicon-chevron-right")){
            driver.findElement(By.cssSelector("ul[id='treemenu']>li>i")).click();
        }

        String inputFormsClassAttribute = driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>i")).getAttribute("class");
        if(inputFormsClassAttribute.contains("glyphicon-chevron-right")){
            driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>i")).click();
        }

        driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>ul>li>a[href='./basic-radiobutton-demo.html']")).click();

        driver.findElement(By.xpath("//input[@name='gender' and @value='Male']")).click();
        driver.findElement(By.xpath("//input[@name='ageGroup' and @value='0 - 5']")).click();

        driver.findElement(By.xpath("//button[text()='Get values']")).click();

        System.out.println(driver.findElement(By.xpath("//p[@class='groupradiobutton']")).getText());

    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
