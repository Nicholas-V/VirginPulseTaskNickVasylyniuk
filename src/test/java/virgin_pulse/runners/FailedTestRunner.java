package virgin_pulse.runners;

import io.cucumber.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "virgin_pulse/step_definitions"
)
public class FailedTestRunner {
}