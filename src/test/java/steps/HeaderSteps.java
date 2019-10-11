package steps;

import forms.KinopoiskHeader;

public class HeaderSteps {

    public static void header() {
        KinopoiskHeader header = new KinopoiskHeader();
        header.clickAdvanced();
    }
}
