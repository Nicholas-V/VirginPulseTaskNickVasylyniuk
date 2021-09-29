package virgin_pulse.runners;

import io.cucumber.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "com/cybertek/step_definitions"
)
public class FailedTestRunner {
}