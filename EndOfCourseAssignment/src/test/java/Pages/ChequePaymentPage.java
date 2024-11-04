package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChequePaymentPage {

    WebDriver driver;
    @FindBy(id = "currency_payment") WebElement dropDownElement;
    @FindBy (xpath = "//span[text()='I confirm my order']") WebElement btnConfirmOrder;

    public ChequePaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectOption(String option){
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByVisibleText(option);
    }

    public OrderConfirmationPage confirmOrder(){
        btnConfirmOrder.click();
        return PageFactory.initElements(driver, OrderConfirmationPage.class);
    }
}
