package pages;

import engine.Bot;
import org.openqa.selenium.By;

public class PageTask3 {
    private final Bot bot;
    private static final String URL = "https://duckduckgo.com/";

    // Locators
    private final By searchBox = By.id("searchbox_input");
    private final By firstResultLink = By.cssSelector("a[data-testid='result-title-a']");

    public PageTask3(Bot bot) {
        this.bot = bot;
    }

    // Actions
    public void open() {
        bot.navigateTo(URL);
    }

    public void search(String query) {
        bot.typeAndEnter(searchBox, query);
    }

    public String getFirstResultHref() {
        return bot.getAttribute(firstResultLink, "href");
    }
}
