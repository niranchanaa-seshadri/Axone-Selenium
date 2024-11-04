package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.HeaderPage;
import pages.SignInPage;

import java.time.Duration;

public class loginLogoutStepDefs {

    WebDriver driver;
    HeaderPage header;
    SignInPage signInPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("I am on the {string} page")
    public void navigateToPage(String url) {
        driver.get(url);
    }

    @When("I click the sign-in link")
    public void clickTheSignInLink() {
        header = PageFactory.initElements(driver, HeaderPage.class);
        signInPage = header.clickSignIn();
    }

    @And("enter a valid registered email {string} and password {string}")
    public void enterEmailAndPassword(String email, String password) {
        signInPage.signIn(email, password);
    }

    @Then("I should be logged in successfully")
    public void checkLoginSuccess() {
        String userName = header.getSignedInUserName();
        Assert.assertEquals(userName, "Sridhar Bandi");
    }

    @And("if I click on logout")
    public void clickOnLogout() {
        header.signOut();
    }

    @Then("I should be logged out of the session")
    public void checkSessionLogout() {
        Assert.assertTrue(header.verifySignOut());
    }

    @After
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}
