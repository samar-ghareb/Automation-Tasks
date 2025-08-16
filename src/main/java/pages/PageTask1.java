package pages;

import engine.Bot;

public class PageTask1 {
    private final Bot bot;
    private static final String URL = "https://duckduckgo.com/";

    public PageTask1(Bot bot) {
        this.bot = bot;
    }

    public void open() {
        bot.navigateTo(URL);
    }

    public String getTitle() {
        return bot.getTitle();
    }
}
