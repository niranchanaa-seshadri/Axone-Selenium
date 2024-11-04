package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = {"src/test/resources/testerLife.feature"},
        glue = {"stepDefs"}, plugin = {"html:target/reports/report.html", "pretty"})
public class testerLifeRunner extends AbstractTestNGCucumberTests {
}
