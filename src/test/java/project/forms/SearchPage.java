package project.forms;

import a1qa.selenium.browser.BrowserManager;
import a1qa.selenium.elements.interfaces.ILabel;
import a1qa.selenium.elements.interfaces.ILink;
import a1qa.selenium.forms.BaseForm;
import a1qa.selenium.forms.PageInfo;
import org.openqa.selenium.By;
import project.models.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@PageInfo(xpath = "//div[@id='tab_content_TopSellers']", pageName = "Top selling name page")
public class SearchPage extends BaseForm {

    private static final String GAMES_LIST = "//div[@id='TopSellersRows']/a";
    private static final String DISCOUNT_FIELD = "//div[@class= 'discount_pct']";
    private static final String NAME_FIELD = "//div[@class= 'tab_item_name']";
    private static final String PRICE_FIELD = "//div[@class= 'discount_final_price']";
    private List<Game> gamesListWithDisc = new ArrayList<>();
    public static int discount;
    public static String price;
    public static String name;

    public void findGameWithDiscount() {
        List<ILabel> gamesList = getElementFactory().findElements(By.xpath(GAMES_LIST), ILabel.class);
        for (ILabel element : gamesList) {
            if (element.findChildElement(By.xpath(DISCOUNT_FIELD), ILabel.class).isExist()) {
                String gameName = element.findChildElement(By.xpath(NAME_FIELD), ILabel.class).getText();
                int gameDiscount = Integer.valueOf(element.findChildElement(By.xpath(DISCOUNT_FIELD), ILabel.class).getText().substring(1, 3));
                String gamePrice = element.findChildElement(By.xpath(PRICE_FIELD), ILabel.class).getText();
                Game games = new Game(gameName, gameDiscount, gamePrice);
                gamesListWithDisc.add(games);
            }

        }
    }

    private Game gameWithMaxDiscount() {
        discount = Collections.max(gamesListWithDisc).getDiscount();
        price = Collections.max(gamesListWithDisc).getPrice();
        name = Collections.max(gamesListWithDisc).getName();
        return Collections.max(gamesListWithDisc);
    }

    public void openGameWithDiscount() {
        List<ILink> linkGame = getElementFactory().findElements(By.xpath(GAMES_LIST), ILink.class);
        List<String> list = new ArrayList<>();
        for (ILink element : linkGame) {
            if (element.findChildElement(By.xpath(NAME_FIELD), ILabel.class).getText().equals(gameWithMaxDiscount().getName())) {
                list.add(element.getHref());
            }
        }
        BrowserManager.getBrowser().goTo(list.get(0));
    }
}

