package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProductsPage {

    WebDriver driver;
    @FindBy(xpath = "//div[@id='best-sellers_block_right']//a[contains(text(), 'Blouse')]")
    WebElement blouseLink;

    public NewProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public BlousePage clickBlouseLink(){
        blouseLink.click();
        return PageFactory.initElements(driver, BlousePage.class);
    }


}
