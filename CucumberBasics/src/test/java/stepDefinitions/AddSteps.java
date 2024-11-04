package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddSteps {

    int total = 0;
    int num1 = 0;
    int num2 = 0;

    @Given("User has two positive numbers {int} and {int}")
    public void collectNumbers(int arg0, int arg1){
        if((0<arg0 && arg0<2147483647) && (0<arg1 && arg1<2147483647)){
            num1 = arg0;
            num2 = arg1;
            addNumbers();
        }
    }

    @When("the user adds them")
    public void addNumbers() {
        total = num1 + num2;
    }

    @Then("the user should be able to see a result of {int}")
    public void printResult(int arg0) {
        Assert.assertEquals(total, arg0);
    }
}
