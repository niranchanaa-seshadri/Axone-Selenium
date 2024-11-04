package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    WebDriver driver;

    @FindBy (className = "cheque") WebElement payByChequeLink;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public ChequePaymentPage clickPayByCheque(){
        payByChequeLink.click();
        return PageFactory.initElements(driver, ChequePaymentPage.class);
    }
}
