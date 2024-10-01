package Assign6Ques1.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseTest {



    private WebDriver driver;
    private final Properties properties;
    private static final int WAIT_TIME_IN_SEC = 10;

    //Map to store the data values fetched from table rows
    public Map<String, String> tableValues;

    //Default constructor. It loads the property file
    public BaseTest() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/application.properties");
            properties = new Properties();
            properties.load(fis);
            tableValues = new HashMap<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Method to launch the browser according to user specs mentioned in property file
    public void launchBrowser(){
        String browser = properties.getProperty("browser");
        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Incorrect browser name");
        }
        //maximize browser
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME_IN_SEC));
    }

    //Method to navigate to URL
    public void navigateToURL(){
        String url = properties.getProperty("url");
        driver.get(url);
    }

    //Method to navigate to URL
    public void navigateToGolfURL(){
        String url = properties.getProperty("golf_url");
        driver.get(url);
    }

    //Method to fetch the element based on locator key
    public WebElement getElement(String locatorKey){
        String locator = properties.getProperty(locatorKey);
        WebElement element = null;

        if (locatorKey.endsWith("className")){
            element = driver.findElement(By.className(locator));
        } else if (locatorKey.endsWith("xpath")){
            element = driver.findElement(By.xpath(locator));
        }

        return element;
    }

    public void getRowWithCellText(String locatorKey, WebElement tableBody){
        String userData = properties.getProperty(locatorKey);
        int numRows = getNumRowsInTable(tableBody);
        System.out.println("num of rows = "+numRows);
        int numCols = tableBody.findElements(By.xpath("//tr[1]/td")).size();
        System.out.println("number of cols = " + numCols);
        boolean flag = false;
        for(int i=1; i<=10; i++){
            for(int j=1; j<=6; j++){
                String cellDataXpath = String.format("//tr[%d]/td[%d]",i ,j);
                String cellData = tableBody.findElement(By.xpath(cellDataXpath)).getText();
                if(userData.equalsIgnoreCase(cellData)){
                    System.out.println("Row with the text passed by user is "+i);
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

    }

    public int getNumRowsInTable(WebElement tableBody){
        return tableBody.findElements(By.tagName("tr")).size();
    }

    /**
     * Method to iterate over web elements and add selected data to Map
     * @param firstCell - cell number that user wants to pick data for - expected to be a string value
     * @param secondCell - cell number that user wants to pick data for - expected to be a double value
     */
    public void addValuesToMap(WebElement tableBody, int firstCell, int secondCell){
        for(int i = 1; i<=10; i++){
            String compNameXpath = String.format("//tr[%d]/td[%d]", i, firstCell);
            String currentPriceXpath = String.format("//tr[%d]/td[%d]", i, secondCell);
            String companyName = tableBody.findElement(By.xpath(compNameXpath)).getText();
            String currentPrice = tableBody.findElement(By.xpath(currentPriceXpath)).getText();
            tableValues.put(companyName, currentPrice);
        }
    }

    /*public void addValuesToMap1(WebElement tableBody, int firstCell, int secondCell){
        for(int i = 1; i<=10; i++){
            String companyName = tableBody.findElement(By.xpath("//tr["+i+"]/td["+firstCell+"]")).getText();
            String currentPrice = tableBody.findElement(By.xpath("//tr["+i+"]/td["+secondCell+"]")).getText();
            tableValues.put(companyName, currentPrice);
        }
    }*/

    /**
     * Iterates over the tableValues map and prints the key and value
     */
    public void iterateMapAndPrint(){
        for (String s : tableValues.keySet()) {
            System.out.println(s + " " + tableValues.get(s));
        }
    }

    //click on the identified element
    public void clickElement(String locatorKey){
        getElement(locatorKey).click();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

