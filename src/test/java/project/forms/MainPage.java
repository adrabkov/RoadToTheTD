package project.forms;

import a1qa.selenium.browser.BrowserManager;
import a1qa.selenium.elements.interfaces.IButton;
import a1qa.selenium.forms.BaseForm;
import a1qa.selenium.forms.PageInfo;
import org.openqa.selenium.By;

@PageInfo(xpath = "//span[@id]/a/img", pageName = "Main page")
public class MainPage extends BaseForm {

    private final IButton listTypeGames = getElementFactory().getButton(By.xpath("//div[@id='genre_tab']/span"), "Game");
    private final IButton btnAction = getElementFactory().getButton(By.xpath("//*[@id='genre_flyout']//a[contains(text(), 'Экшен')] | //*[@id='genre_flyout']//a[contains(text(), 'Action')]"), "Action");

    public void clickActionBtn() {
        BrowserManager.getBrowser().refresh();
        listTypeGames.getMouseActions().moveMouseToElement();
        btnAction.click();
    }

}
