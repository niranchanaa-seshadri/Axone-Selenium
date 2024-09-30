package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Base.BasePage.WAIT_TIME_IN_SEC;

public class CartPage{

    @FindBy(xpath="//button[@class='btn btn-success']") WebElement placeOrderButton;
    @FindBy(xpath = "//div[@id='orderModal']//div[@class='modal-content']/div") List<WebElement> paymentFormElements;
    @FindBy(id="name") WebElement placeOrderFormName;
    @FindBy(id="country") WebElement placeOrderFormCountry;
    @FindBy(id="city") WebElement placeOrderFormCity;
    @FindBy(id="card") WebElement placeOrderFormCard;
    @FindBy(id="month") WebElement placeOrderFormMonth;
    @FindBy(id="year") WebElement placeOrderFormYear;
    @FindBy(xpath="//button[text()='Purchase']") WebElement purchaseButton;
    @FindBy(xpath="//button[@class='confirm btn btn-lg btn-primary']") WebElement purchaseConfirmationButton;

    WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void placeOrder(WebDriver driver) {
        placeOrderButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SEC));
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentFormElements));
        fillForm();
        purchaseButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(purchaseConfirmationButton));
        purchaseConfirmationButton.click();
    }

    public void fillForm(){
        placeOrderFormName.sendKeys("Random Name");
        placeOrderFormCountry.sendKeys("United Kingdom");
        placeOrderFormCity.sendKeys("London");
        placeOrderFormCard.sendKeys("123456789");
        placeOrderFormMonth.sendKeys("1");
        placeOrderFormYear.sendKeys("1940");
    }
}
