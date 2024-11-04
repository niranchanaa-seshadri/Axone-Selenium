package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrderAddressPage {

    WebDriver driver;

    @FindBy(id="address_delivery") WebElement deliveryAddress;

    @FindBy(id="address_invoice") WebElement billingAddress;

    @FindBy(xpath = "//button[@name='processAddress']") WebElement checkOutButton;

    public MyOrderAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyAddressPopulated(){
        return deliveryAddress.isDisplayed() && billingAddress.isDisplayed();
    }

    public ShippingDetailsPage proceedToCheckout(){
        checkOutButton.click();
        return PageFactory.initElements(driver, ShippingDetailsPage.class);
    }
}
