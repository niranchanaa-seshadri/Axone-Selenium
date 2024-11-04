package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src/test/resources/Features/add.feature"},
glue={"stepDefinitions"},
plugin = {"html:target/reports/report.html"})
public class testNGRunner extends AbstractTestNGCucumberTests {

}
