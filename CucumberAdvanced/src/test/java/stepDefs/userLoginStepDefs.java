package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class userLoginStepDefs {

    private WebDriver driver;

    @Given("I am on https:\\/\\/the-internet.herokuapp.com\\/login registration page")
    public void launchPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/login");}


    @And("I enter user name {string}")
    public void enterUserName(String userName) {
        driver.findElement(By.id("username")).sendKeys(userName);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click on Login button")
    public void clickOnLoginButton() {
        driver.findElement(By.tagName("button")).click();
    }

    @Then("user should be shown {string}")
    public void showMessageToUser(String message) {
        String textDisplayed = driver.findElement(By.id("flash-messages")).getText();
        System.out.println(textDisplayed);
        if(message.equalsIgnoreCase("warning")){
            Assert.assertTrue(textDisplayed.contains("Your username is invalid!"));
        } else if (message.equalsIgnoreCase("success")) {
            Assert.assertTrue(textDisplayed.contains("You logged into a secure area!"));
        }
    }

    @After
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
