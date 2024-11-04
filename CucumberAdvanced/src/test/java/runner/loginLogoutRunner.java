package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = {"src/test/resources/loginLogout.feature"},
glue = {"stepDefs"}, plugin = {"pretty", "html:target/reports/loginLogoutReport.html"})
public class loginLogoutRunner extends AbstractTestNGCucumberTests {
}
