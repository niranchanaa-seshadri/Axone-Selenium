package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlousePage {
    WebDriver driver;

    @FindBy(xpath = "//ul[@id='color_to_pick_list']//a[@name='White']")
    WebElement whiteColour;

    @FindBy(xpath = "//p[@id='add_to_cart']/button") WebElement addToCartButton;
    @FindBy(xpath = "//a[@title='Proceed to checkout']") WebElement proceedToCheckOutButton;

    public BlousePage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseColour(String colour){
        if(colour.equalsIgnoreCase("white")){
            whiteColour.click();
        }
    }

    public void addToCart(){
        addToCartButton.click();
    }

    public ShoppingCartSummaryPage proceedToCheckout(){
        proceedToCheckOutButton.click();
        return PageFactory.initElements(driver, ShoppingCartSummaryPage.class);
    }

}
