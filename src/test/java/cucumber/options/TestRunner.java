package cucumber.options;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utility.Helper;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/feature/createConsumer.feature",
    glue = "stepDefinitions",
    plugin = {
        "pretty",
        "html:target/htmlReports",
        "json:target/jsonReports/cucumber-report.json"
    },
   
    monochrome = true,
    dryRun = false
)

public class TestRunner {

    @AfterClass
    public static void generateReport() {
        Helper.generateReport();
    }
}
