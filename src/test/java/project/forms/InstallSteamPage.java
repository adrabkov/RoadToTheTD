package project.forms;

import a1qa.selenium.elements.interfaces.IButton;
import a1qa.selenium.forms.BaseForm;
import a1qa.selenium.forms.PageInfo;
import org.openqa.selenium.By;

@PageInfo(xpath = "//div[@class='steam_logo']/img", pageName = "Install steam page")
public class InstallSteamPage extends BaseForm {

    private static final String INSTALL_BUTTON = "//div[@id='global_action_menu']/div/a";
    private static final String DOWNLOAD_BUTTON = "//div[contains(@class, 'about_install')]/a";
    private final IButton btnInstall = getElementFactory().getButton(By.xpath(INSTALL_BUTTON), "Install steam");
    private final IButton btnDownload = getElementFactory().getButton(By.xpath(DOWNLOAD_BUTTON), "Download Steam");

    public void clickInstallBtn() {
        btnInstall.click();
    }

    public void clickDownloadBtb() {
        btnDownload.clickAndWait();
    }

}
