package steps;

import forms.SearchForm;

public class SearchingSteps {

    public static void search(String filmName, String filmType, String fromDate, String toDate) {
        SearchForm form = new SearchForm();
        form.fillFilmName(filmName);
        form.chooseFilmType(filmType);
        form.setYears(fromDate, toDate);
        form.searchButton();
    }
}
