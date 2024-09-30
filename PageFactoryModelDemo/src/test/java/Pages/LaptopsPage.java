package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopsPage {

    @FindBy (xpath = "//div[@id='tbodyid']//a[contains(text(), 'MacBook Pro')]")
    WebElement laptopLink;

    WebDriver driver;

    public LaptopsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LaptopProductDetailPage clickOnPreferredLaptop(){
        laptopLink.click();
        return new LaptopProductDetailPage(driver);
    }
}
