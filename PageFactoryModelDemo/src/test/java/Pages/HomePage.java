package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  {

    @FindBy (xpath = "//a[@id='cat']/following-sibling::a[contains(text(), 'Laptops')]")
    WebElement laptopPageLink;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LaptopsPage goToLaptopsPage(){
        laptopPageLink.click();
        return new LaptopsPage(driver);
    }
}
