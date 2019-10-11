package project.steps;

import a1qa.selenium.elements.interfaces.ICheckBox;
import a1qa.selenium.elements.interfaces.IElement;
import a1qa.selenium.forms.BaseForm;
import a1qa.selenium.forms.PageInfo;
import org.openqa.selenium.By;
import org.testng.Assert;
import project.forms.*;

import static aqa.assertion.AqaAssert.isTrue;


@PageInfo(xpath = "//span[@id]/a/img", pageName = "Main page")
public class SteamSteps extends BaseForm {

    private static final String DISCOUNT = "//div[@class='game_purchase_action']//div[@class='discount_pct']";
    private static final String PRICE = "//div[@class='game_purchase_action']//div[@class='discount_final_price']";
    private static final String BIRTHDAY_FORM = "//div[@class='agegate_birthday_selector']";
    private static final String ACCEPT_AGE = "//input[@type='checkbox']";

    public void mainPageIsOpened() {
        isTrue(new MainPage().isFormDisplayed(), "Sites main page is opened");
    }

    public void changeLanduage() {
        new langCheckPage().changeLang();
    }

    public void openActionPage() {
        new MainPage().clickActionBtn();
    }

    public void actionPageIsOpened() {
        isTrue(new ActionPage().isFormDisplayed(), "Action page is opened");
    }

    public void openTopSellersTab() {
        new ActionPage().clickSalesLeaders();
    }

    public void findGameWithMaxDiscountAndOpen() {
        SearchPage searchPage = new SearchPage();
        searchPage.findGameWithDiscount();
        searchPage.openGameWithDiscount();
    }

    public void checkFormAboutAge(String age) {
        AgeCheckPage ageCheckPage = new AgeCheckPage();
        BirthdayPage birthdayPage = new BirthdayPage();
        IElement formWithBirthdayFields = getElementFactory().getLabel(By.xpath(BIRTHDAY_FORM), "Birthday form");
        ICheckBox formWithAcceptAge = getElementFactory().getCheckBox(By.xpath(ACCEPT_AGE), "Warning page");

        if (formWithBirthdayFields.isDisplayed()) {
            birthdayPage.checkingAge(age);
        }
        if (formWithAcceptAge.isDisplayed()) {
            ageCheckPage.acceptAge();
        }
    }

    public void checkThatGamesWithMaxDiscountIsOpened() {
        Integer actualDiscount = Integer.valueOf(getElementFactory().getLabel(By.xpath(DISCOUNT), "Actual Discount").getText().substring(1, 3));
        String actualPrice = getElementFactory().getLabel(By.xpath(PRICE), "Actual price").getText();
        String actualName = getElementFactory().getLabel(By.xpath("//div[@class='apphub_AppName']"), "Actual name of the game").getText();
        System.out.println(actualName);
        int expectedDiscount = SearchPage.discount;
        String expectedPrice = SearchPage.price;
        String expectedName = SearchPage.name;
        Assert.assertEquals(expectedDiscount, (int) actualDiscount, "Discount on games does not match expected");
        Assert.assertTrue(actualPrice.contains(expectedPrice), "Price on games does not match expected");
        Assert.assertTrue(actualName.contains(expectedName), "Name of the game does not math expected");
    }


    public void clickInstallSteamBtn() {
        InstallSteamPage installSteamPage = new InstallSteamPage();
        installSteamPage.clickInstallBtn();
        installSteamPage.clickDownloadBtb();
    }

    public void InstallSteamFileIsDownloaded() {
        new CheckFileDownloaded().testFileDownloaded();
    }
}
