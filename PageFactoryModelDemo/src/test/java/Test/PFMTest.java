package Test;

import Base.BasePage;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PFMTest extends BasePage {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = launchBrowser();
    }

    @Test
    public void placeOrder() throws InterruptedException {
        test = report.createTest("Demo Blaze Store Order Placement Test");

        //Navigate to the demo blaze site
        HomePage homePageObj = navigateToURL(driver);
        test.pass("Launched browser and navigated to Demo Blaze homepage");

        //Click on 'Laptops' from the categories on the left pane
        LaptopsPage laptopsPage = homePageObj.goToLaptopsPage();
        test.pass("Navigated to laptops page");

        //Click on Macbook pro from the laptops listed
        LaptopProductDetailPage laptopProductDetailPage = laptopsPage.clickOnPreferredLaptop();
        test.pass("Clicked on Macbook pro from the list of laptops");

        //Add Macbook pro to cart
        laptopProductDetailPage.addToCart();
        test.pass("Added Macbook pro to cart");

        //Click on the cart link from the header menu
        HeaderComponent headerComponent = new HeaderComponent(driver);
        CartPage cartPage = headerComponent.clickOnCart(driver);
        test.pass("Navigated to cart page");

        //Enter details and place order
        cartPage.placeOrder(driver);
        test.pass("Order placed");

        report.flush();
    }

    @AfterTest
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
