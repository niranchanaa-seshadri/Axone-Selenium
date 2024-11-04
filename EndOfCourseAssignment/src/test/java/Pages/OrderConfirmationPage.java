package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

    WebDriver driver;
    @FindBy(className = "page-heading") WebElement pageHeaderElement;
    @FindBy(xpath = "//div[@class='box order-confirmation']") WebElement orderDetailsElement;

    @FindBy(xpath = "//a[@class='button-exclusive btn btn-default']") WebElement orderHistoryPageLink;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyOrderConfirmationPage(){
        return pageHeaderElement.getText().equalsIgnoreCase("Order confirmation");
    }

    public String getOrderReferenceNumber(){
        String orderDetails = orderDetailsElement.getText();
        String orderReference = "dummy";
        String[] orderDetailTextArray = orderDetails.split("-");
        for (String s : orderDetailTextArray) {
            if (s.contains("order reference")) {
                String[] orderReferenceLineArray = s.split(" ");
                for(int i = 0; i<orderReferenceLineArray.length; i++){
                    if(orderReferenceLineArray[i].equalsIgnoreCase("reference"))
                    {
                        orderReference = orderReferenceLineArray[i+1];
                    }
                }
            }
        }
        String[] formattedOrderRef = orderReference.split("\\.");
        return formattedOrderRef[0];
    }

    public OrderHistoryPage viewOrderHistoryPage(){
        orderHistoryPageLink.click();
        return PageFactory.initElements(driver, OrderHistoryPage.class);
    }
}
