package forms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KinopoiskHeader extends BaseForm {

    @FindBy(className = "header-fresh-search-partial-component__advanced-search-button")
    private WebElement advancedSearch;

    public void clickAdvanced() {
        log.info("Opening the advanced search");
        advancedSearch.click();
    }
}
