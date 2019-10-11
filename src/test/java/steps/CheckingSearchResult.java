package steps;

import forms.SearchForm;

public class CheckingSearchResult {

    public static void checkResult(String expectedFilmName) {
        SearchForm form = new SearchForm();
        form.checkFilm(expectedFilmName);
    }
}
