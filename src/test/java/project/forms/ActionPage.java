package project.forms;

import a1qa.selenium.elements.interfaces.IButton;
import a1qa.selenium.forms.BaseForm;
import a1qa.selenium.forms.PageInfo;
import org.openqa.selenium.By;

@PageInfo(xpath = "//h2[contains(text(), 'Экшен')] | //h2[contains(text(), 'Action')]", pageName = "Action page")
public class ActionPage extends BaseForm {

    private static final String TOP_SELLERS = "//div[@id='tab_select_TopSellers']";
    private final IButton salesLeaders = getElementFactory().getButton(By.xpath(TOP_SELLERS), "Sales Leaders tab");

    public void clickSalesLeaders() {

        salesLeaders.click();
    }
}
