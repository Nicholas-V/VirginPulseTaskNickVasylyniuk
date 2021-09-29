package virgin_pulse.runners;

import io.cucumber.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "virgin_pulse/step_definitions",
        dryRun = false,
        tags = "@Smoke"
)
public class CukesRunner {
}
