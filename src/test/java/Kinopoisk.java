import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.CheckingSearchResult;
import steps.HeaderSteps;
import steps.SearchingSteps;

public class Kinopoisk extends BaseTest {

    @Test
    @Parameters({"filmName", "filmType", "fromDate", "toDate", "expectedFilmName"})

    public void testSearchFilm(String filmName, String filmType, String fromDate, String toDate, String expectedFilmName) {

        HeaderSteps.header();
        SearchingSteps.search(filmName, filmType, fromDate, toDate);
        CheckingSearchResult.checkResult(expectedFilmName);
    }
}
