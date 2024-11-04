package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage {
    WebDriver driver;
    @FindBy(xpath = "//table[@id='cart_summary']//a[contains(text(), 'Blouse')]")
    WebElement blouseInCart;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']") WebElement proceedToCheckoutButton;

    public ShoppingCartSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyBlousePresentInCart(){
        return blouseInCart.isDisplayed();
    }

    public MyOrderAddressPage proceedToCheckout(){
        proceedToCheckoutButton.click();
        return PageFactory.initElements(driver, MyOrderAddressPage.class);
    }
}
