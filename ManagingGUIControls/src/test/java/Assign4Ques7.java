import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class Assign4Ques7 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://uitest.automationtester.uk/basic-first-form-demo.html");
    }

    @Test
    public void checkMultiSelect() throws InterruptedException {
        String allExamplesClassAtrribute = driver.findElement(By.cssSelector("ul[id='treemenu']>li>i")).getAttribute("class");
        if (allExamplesClassAtrribute.contains("glyphicon-chevron-right")){
            driver.findElement(By.cssSelector("ul[id='treemenu']>li>i")).click();
        }

        String inputFormsClassAttribute = driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>i")).getAttribute("class");
        if(inputFormsClassAttribute.contains("glyphicon-chevron-right")){
            driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>i")).click();
        }

        driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>ul>li>a[href='./basic-select-dropdown-demo.html']")).click();

        String isMultiSelect = driver.findElement(By.id("multi-select")).getAttribute("multiple");
        if(isMultiSelect.equalsIgnoreCase("multiple")){
            System.out.println("It is a multi select dropdown");
        }
        driver.findElement(By.xpath("//select[@id='multi-select']/option[@value='California']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@id='multi-select']/option[@value='Pennsylvania']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void checkFirstSelected() throws InterruptedException {
        String allExamplesClassAtrribute = driver.findElement(By.cssSelector("ul[id='treemenu']>li>i")).getAttribute("class");
        if (allExamplesClassAtrribute.contains("glyphicon-chevron-right")){
            driver.findElement(By.cssSelector("ul[id='treemenu']>li>i")).click();
        }

        String inputFormsClassAttribute = driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>i")).getAttribute("class");
        if(inputFormsClassAttribute.contains("glyphicon-chevron-right")){
            driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>i")).click();
        }

        driver.findElement(By.cssSelector("ul[id='treemenu']>li>ul>li:first-of-type>ul>li>a[href='./basic-select-dropdown-demo.html']")).click();

        //String isMultiSelect = driver.findElement(By.id("multi-select")).getAttribute("multiple");
//        if(isMultiSelect.equalsIgnoreCase("multiple")){
//            System.out.println("It is a multi select dropdown");
//        }

        WebElement multiSelectCheckbox = driver.findElement(By.id("multi-select"));
        Select selectMenu = new Select(multiSelectCheckbox);
        System.out.println("is this a multi select drop down? " + selectMenu.isMultiple());
        selectMenu.selectByValue("California");
        selectMenu.selectByValue("Pennsylvania");
        //driver.findElement(By.xpath("//select[@id='multi-select']/option[@value='California']")).click();
        //driver.findElement(By.xpath("//select[@id='multi-select']/option[@value='Pennsylvania']")).click();

        driver.findElement(By.id("printMe")).click();
        Thread.sleep(2000);

        String firstSelected = selectMenu.getFirstSelectedOption().getText();
        List<WebElement> allSelected = selectMenu.getAllSelectedOptions();
        List<String> allStringSelected = new ArrayList<>();
        for (WebElement webElement : allSelected) {
            String s = webElement.getText();
            allStringSelected.add(s);
        }
        Set<String> allSelectedSet = new HashSet<>(allStringSelected);
        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("California");
        expectedSet.add("Pennsylvania");
        Assert.assertEquals(firstSelected, "California");
        Assert.assertEquals(allSelectedSet, expectedSet );
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
