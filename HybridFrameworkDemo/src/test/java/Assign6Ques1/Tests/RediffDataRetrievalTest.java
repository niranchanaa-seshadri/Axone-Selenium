package Assign6Ques1.Tests;

import Assign6Ques1.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class RediffDataRetrievalTest extends BaseTest {

    @BeforeTest
    public void setUp(){
        launchBrowser();
    }

    /**
     * Navigate to Rediff and print names and current price of companies listed
     */
    @Test
    public void printNamesAndPrice() throws InterruptedException {

        //navigate to url
        navigateToURL();
        Thread.sleep(3000);

        //Click on consent button
        clickElement("consent_btn_className");

        //Fetch the data table
        WebElement tableBodyElement = getElement("data_table_body_xpath");

        //Obtain the name and current price of all the rows in the table and add it to a map
        addValuesToMap(tableBodyElement, 1, 4);

        //print the values of the map
        iterateMapAndPrint();

        //Find the row number of the specified value - searches for the first match
        getRowWithCellText("search_String", tableBodyElement);
    }

    @AfterTest
    public void tearDown(){
        getDriver().quit();
    }
}
