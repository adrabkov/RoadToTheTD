package project.forms;

import a1qa.selenium.elements.interfaces.IButton;
import a1qa.selenium.forms.BaseForm;
import a1qa.selenium.forms.PageInfo;
import org.openqa.selenium.By;

@PageInfo(xpath = "//input[@type='checkbox']", pageName = "Page about age")
public class AgeCheckPage extends BaseForm {

    private static final String OPEN = "//div[contains(@class, 'agegate_text')]/a[1]";
    private final IButton openPage = getElementFactory().getButton(By.xpath(OPEN), "Open page button");

    public void acceptAge() {

        openPage.click();
    }
}
