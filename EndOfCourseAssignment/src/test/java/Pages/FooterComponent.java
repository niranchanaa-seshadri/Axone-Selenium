package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterComponent {

    WebDriver driver;

    @FindBy(xpath = "//a[@title='New products']") WebElement newProductsLink;

    public FooterComponent(WebDriver driver) {
        this.driver = driver;
    }

    public NewProductsPage navigateToNewProductsPage(){
        newProductsLink.click();
        return PageFactory.initElements(driver, NewProductsPage.class);
    }

}
