package virgin_pulse.step_definitions;

import io.cucumber.java.*;
import org.openqa.selenium.*;
import virgin_pulse.utilities.*;
import static io.restassured.RestAssured.*;

public class Hooks {
    @Before("@API")
    public static void setUp(){
        baseURI = ConfigurationReader.getProperty("baseURI");
    }

    @After("@UI")
    public void tearDownScenario(Scenario scenario){
        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
