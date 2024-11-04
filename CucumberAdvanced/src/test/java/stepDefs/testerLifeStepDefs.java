package stepDefs;

import io.cucumber.java.en.*;

public class testerLifeStepDefs {

    @Given ("I am a {string} tester")
    public void findTypeOfTester(String testerType){
        System.out.printf("I am a %s tester%n", testerType);
    }

    @When("I {string} my tasks")
    public void findTaskStatus(String taskStatus) {
        System.out.printf("I %s my tasks%n", taskStatus);
    }

    @And("{string} important bugs")
    public void findTesterAction(String testerAction) {
        System.out.printf("I %s important bugs%n", testerAction);
    }

    @Then("My manager {string} me")
    public void findManagerOutcome(String managerOutcome) {
        System.out.printf("My manager %s me%n", managerOutcome);
    }

    @But("Developer {string} me")
    public void findDeveloperOutcome(String developerOutcome) {
        System.out.printf("Developer %s me%n", developerOutcome);
    }
}
