package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

    WebDriver driver;

    @FindBy (className = "login") WebElement signInLink;
    @FindBy (className = "account") WebElement userName;
    @FindBy (className = "logout") WebElement signOutLink;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage clickSignIn(){
        signInLink.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public String getSignedInUserName(){
        return userName.getText();
    }

    public void signOut(){
        signOutLink.click();
    }

    public boolean verifySignOut(){
        return signInLink.isDisplayed();
    }
}
