package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponent {

    @FindBy (id="cartur")
    WebElement cartLink;

    WebDriver driver;

    public HeaderComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CartPage clickOnCart(WebDriver driver){
        cartLink.click();
        return new CartPage(driver);
    }
}
