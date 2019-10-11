package forms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchForm extends BaseForm {

    @FindBy(id = "find_film")
    private WebElement filmName;

    @FindBy(xpath = "//select[contains(@class, 'el_17')]")
    private WebElement typeFilm;

    @FindBy(id = "from_year")
    private WebElement fromDate;

    @FindBy(id = "to_year")
    private WebElement toDate;

    @FindBy(xpath = "//input[contains(@class, 'el_18')and (@type='button')]")
    private WebElement submit;

    @FindAll(@FindBy(how = How.CSS, using = "div.element p.name"))
    List<WebElement> resultList;

    public void fillFilmName(String name) {
        log.info("Filling the field with the film name");
        filmName.sendKeys(name);
    }

    public void chooseFilmType(String filmType) {
        log.info("Choosing the film type");
        Select type = new Select(typeFilm);
        type.selectByVisibleText(filmType);
    }

    public void setYears(String fromYear, String toYear) {
        log.info("Date selection 'From'");
        Select yearsFrom = new Select(fromDate);
        yearsFrom.selectByValue(fromYear);
        log.info("date selection 'To'");
        Select yearsTo = new Select(toDate);
        yearsTo.selectByValue(toYear);
    }

    public void searchButton() {
        log.info("Click the search button");
        submit.click();
    }

    public void checkFilm(String expectedFilm) {

        log.info("Search for a movie in the list");
        List<String> result = new ArrayList<>();
        for (WebElement res : resultList) {
            if (res.getText().contains(expectedFilm)) {
                result.add(res.getText());
            }
        }
        log.info("Check that the " + expectedFilm + " is displayed");
        Assert.assertTrue(result.toString().contains(expectedFilm), expectedFilm + " is not displayed");
        log.info(expectedFilm + " is displayed on the search result");
    }
}
