package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = "src/test/resources/Features/buyAProduct.feature",
glue = "StepDefs",
plugin = {"pretty", "html:target/reports/report.html"})
public class buyAProductRunner extends AbstractTestNGCucumberTests {
}
