package virgin_pulse.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import virgin_pulse.utilities.*;

import java.util.List;

public class WelcomePagePetStoreSwagger extends BasePage implements WelcomePageParametrization{

    @FindBy(xpath = "//button[contains(@aria-label,'pet')]")
    private List<WebElement> petTables;

    @FindBy(xpath = "//button[contains(@aria-label,'store')]")
    private List<WebElement> storeTables;

    @FindBy(xpath = "//button[contains(@aria-label,'user')]")
    private List<WebElement> userTables;

    @FindBy(xpath = "//button[contains(text(),'Try it out')]")
    private WebElement tryItOutButton;

    @Override
    public WebElement getElement(String element) {
        switch (element){
            case TRY_IT_OUT_BUTTON: return tryItOutButton;
            default: throw new NoElementDefinedException("getElement method failed");
        }
    }

    @Override
    public String getTitleCustomMethod() {
        return Driver.getDriver().getTitle();
    }

    @Override
    public String getAttributeCustomMethod(String attributeName, String element) {
        return this.getElement(element).getAttribute(attributeName);
    }

    @Override
    public List<WebElement> getList(String listName) {
        switch (listName){
            case PET_TABLE: return petTables;
            case STORE_TABLE: return storeTables;
            case USER_TABLE: return  userTables;
            default: throw new NoSuchListException("getList Custom Method Failed");
        }
    }

    @Override
    public boolean elementIsDisplayed(String element) {
        return this.getElement(element).isDisplayed();
    }

    @Override
    public void clickElementMethod(String element) {
        this.getElement(element).click();
    }

}
