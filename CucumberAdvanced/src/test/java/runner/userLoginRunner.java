package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = {"src/test/resources/userLogin.feature"},
 glue = {"stepDefs"}, plugin = {"pretty", "html:target/reports/userLoginReport.html"})
public class userLoginRunner extends AbstractTestNGCucumberTests {
}