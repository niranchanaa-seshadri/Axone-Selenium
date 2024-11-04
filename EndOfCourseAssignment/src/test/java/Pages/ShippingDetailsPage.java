package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingDetailsPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='delivery_options']")
    WebElement shippingOptionsTable;

    @FindBy(id="uniform-cgv") WebElement tNcCheckBox;

    @FindBy(xpath = "//button[@name='processCarrier']") WebElement checkoutButton;

    public ShippingDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyShippingOptionsPopulated(){
        return shippingOptionsTable.isDisplayed();
    }

    public PaymentPage agreeAndProceed(){
        tNcCheckBox.click();
        checkoutButton.click();
        return PageFactory.initElements(driver, PaymentPage.class);
    }
}
