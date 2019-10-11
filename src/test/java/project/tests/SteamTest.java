package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import project.steps.SteamSteps;

public class SteamTest extends BaseTest {

    @Test
    @Parameters({"year"})
    protected void runTest(String year) {
        SteamSteps steamSteps = new SteamSteps();
        steamSteps.mainPageIsOpened();
        steamSteps.changeLanduage();
        steamSteps.openActionPage();
        steamSteps.actionPageIsOpened();
        steamSteps.openTopSellersTab();

        steamSteps.findGameWithMaxDiscountAndOpen();
        steamSteps.checkFormAboutAge(year);
        steamSteps.checkThatGamesWithMaxDiscountIsOpened();

        steamSteps.clickInstallSteamBtn();
        steamSteps.InstallSteamFileIsDownloaded();
    }
}
