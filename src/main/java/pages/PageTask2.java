package pages;

import engine.Bot;
import org.openqa.selenium.By;

public class PageTask2 {
    private final Bot bot;
    private static final String URL = "https://duckduckgo.com/";

    private final By logo = By.xpath("//div[contains(@class,'Desktop')]//img");

    public PageTask2(Bot bot) {
        this.bot = bot;
    }

    public void open() {
        bot.navigateTo(URL);
    }

    public boolean isLogoDisplayed() {
        return bot.isDisplayed(logo);
    }
}
