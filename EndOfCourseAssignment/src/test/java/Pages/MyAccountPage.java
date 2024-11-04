package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;
    MyAccountAddressPage myAccountAddressPage;


    @FindBy(xpath = "//a[@title='Addresses']") WebElement myAddressesLink;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkAddressPresent(){
        myAddressesLink.click();
        myAccountAddressPage = PageFactory.initElements(driver, MyAccountAddressPage.class);
        return myAccountAddressPage.verifyAddressDisplayed();
    }
}
