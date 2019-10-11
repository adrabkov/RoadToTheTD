package project.forms;

import a1qa.selenium.elements.interfaces.IButton;
import a1qa.selenium.elements.interfaces.IElement;
import a1qa.selenium.forms.BaseForm;
import a1qa.selenium.forms.PageInfo;
import framework.configurations.Configuration;
import org.openqa.selenium.By;

@PageInfo(xpath = "//span[@id]/a/img", pageName = "Main page")
public class langCheckPage extends BaseForm {

    private final IElement lang = getElementFactory().getLabel(By.xpath("//html"), "");
    private final IButton langButton = getElementFactory().getButton(By.xpath("//span[@id='language_pulldown']"), "");
    private final String langPath = Configuration.getCurrentEnvironment().getLang();
    private final IButton chooseLang = getElementFactory().getButton(By.xpath("//div[@id='language_dropdown']//a[contains(@href, '" + langPath + "')]"), "");

    public void changeLang() {
        if (lang.getAttribute("lang").equals(langPath)) {
        } else {
            langButton.clickAndWait();
            chooseLang.clickAndWait();
        }
    }
}
