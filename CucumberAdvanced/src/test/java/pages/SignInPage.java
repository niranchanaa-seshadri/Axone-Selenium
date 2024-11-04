package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

    WebDriver driver;

    @FindBy (id = "email") WebElement emailField;
    @FindBy (id = "passwd") WebElement passwordField;
    @FindBy (id = "SubmitLogin") WebElement signInBtn;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInBtn.click();
    }

}
