package virgin_pulse.step_definitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import virgin_pulse.pages.WelcomePagePetStoreSwagger;
import virgin_pulse.utilities.*;

import java.util.List;

import static virgin_pulse.pages.WelcomePageParametrization.*;

public class RestMethodSectionStepDefinitions  {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    WelcomePagePetStoreSwagger welcomePage = new WelcomePagePetStoreSwagger();

    @Given("user is on the welcome page")
    public void user_is_on_the_welcome_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("petSwaggerURL"));
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String titleMessage) {
        wait.until(ExpectedConditions.titleIs(titleMessage));
        Assertions.assertEquals(welcomePage.getTitleCustomMethod(), titleMessage);
    }

    @Then("user verifies all tables expand and collapse")
    public void user_verifies_all_tables_expand_and_collapse(List<String> tableName) {
        for (int i = 0; i < tableName.size(); i++) {
            for (WebElement eachMethod : welcomePage.getList(tableName.get(i))) {
                eachMethod.click();
                Assertions.assertTrue(welcomePage.elementIsDisplayed(TRY_IT_OUT_BUTTON));
                eachMethod.click();
                String isCollapsed = eachMethod.getAttribute("aria-expanded");
                Assertions.assertEquals("false", isCollapsed);
            }
        }
    }
}
