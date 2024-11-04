package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountAddressPage {

    WebDriver driver;
    @FindBy(xpath = "//div[@class='bloc_adresses row']//h3[text() = 'My address']") WebElement address;

    public MyAccountAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyAddressDisplayed(){
        return address.isDisplayed();
    }

}
