package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/createConsumer.feature",plugin="json:target/jsonReports/cucumber-report.json", glue = "stepDefinitions"

)

//tags = "@continueEnrollment"
public class TestRunner {

}
