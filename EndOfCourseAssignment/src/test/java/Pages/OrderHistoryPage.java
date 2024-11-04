package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage {

    WebDriver driver;
    @FindBy(xpath = "//tr[@class='first_item ']/td[1]/a") WebElement firstOrderRefElement;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstOrderReference(){
        return firstOrderRefElement.getText();
    }
}
