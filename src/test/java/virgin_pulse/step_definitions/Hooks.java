package virgin_pulse.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import virgin_pulse.utilities.Driver;
import static io.restassured.RestAssured.baseURI;

public class Hooks {

    @Before("@API")
    public static void setUp(){
        baseURI = "https://petstore.swagger.io/v2";
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
