package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponent {

    WebDriver driver;

    @FindBy(className = "login")
    WebElement signInLink;

    @FindBy(xpath = "//span[@class='ajax_cart_quantity unvisible']") public WebElement numberOfProductsInCart;

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage clickSignInLink(){
        signInLink.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public int checkNumberInCart(){
        String numberInCartStr = numberOfProductsInCart.getText();
        if(numberInCartStr == ""){
            return 0;
        } else {
            return Integer.parseInt(numberInCartStr);
        }
    }
}
