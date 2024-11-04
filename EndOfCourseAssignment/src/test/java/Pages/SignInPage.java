package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    WebDriver driver;

    @FindBy (id = "email") WebElement emailField;
    @FindBy (id = "passwd") WebElement passwordField;
    @FindBy (id = "SubmitLogin") WebElement signInButton;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage signIn(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(driver, MyAccountPage.class);
    }
}
