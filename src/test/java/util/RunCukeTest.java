package util;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"step_definitions"},
        format = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "json:target/surefire-reports/cucumber.json"}
)

public class RunCukeTest {




}




