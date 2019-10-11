package project.forms;

import a1qa.selenium.elements.interfaces.IButton;
import a1qa.selenium.elements.interfaces.IComboBox;
import a1qa.selenium.forms.BaseForm;
import a1qa.selenium.forms.PageInfo;
import org.openqa.selenium.By;

@PageInfo(xpath = "//div[@class='agegate_birthday_selector']", pageName = "Page about age")
public class BirthdayPage extends BaseForm {

    private static final String OPEN = "//a[contains(@class, 'btnv6_blue_hoverfade')]";
    private static final String DROPDOWN = "//select[@id='ageYear']";
    private final IButton openPage = getElementFactory().getButton(By.xpath(OPEN), "Open page button");
    private final IComboBox yearField = getElementFactory().getComboBox(By.xpath(DROPDOWN), "Birthday year dropdown list");

    public void checkingAge(String yearBirth) {

        yearField.selectByText(yearBirth);
        openPage.click();
    }
}
