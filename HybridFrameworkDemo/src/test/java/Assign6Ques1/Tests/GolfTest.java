package Assign6Ques1.Tests;

import Assign6Ques1.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GolfTest extends BaseTest {

    @BeforeTest
    public void setUp(){
        launchBrowser();
    }

    @Test
    public void testSlider() throws InterruptedException {

        //navigate to url
        navigateToGolfURL();
        Thread.sleep(3000);

        //Click on Golf Club link
        clickElement("golfClub_lnk_xpath");
        Thread.sleep(3000);

        //Click on Sets of Iron Link
        clickElement("setsOfIrons_lnk_xpath");
        Thread.sleep(3000);

        //
        Actions actions = new Actions(getDriver());
        WebElement sliderTop = getElement("price_topRange_slider_xpath");
        actions.dragAndDropBy(sliderTop, -20, 0).perform();
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown(){
        getDriver().quit();
    }

}
