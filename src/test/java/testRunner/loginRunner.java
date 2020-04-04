package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,

        features = {"D:\\Frameworks\\Neosoft frameworks\\Demo_Ricki\\src\\test\\resources\\features"},
        glue = {"step_definitions"})

public class loginRunner {
}
