package tasks;

import engine.Bot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageTask2;

public class TestTask2 {
    private Bot bot;
    private PageTask2 page;

    @BeforeMethod
    public void setup() {
        bot = new Bot();
        page = new PageTask2(bot);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        if (bot != null) {
            bot.quit();
        }
    }

    @Test
    public void assertThatTheDuckDuckGoLogoIsDisplayed() {
        page.open();
        Assert.assertTrue(
                page.isLogoDisplayed(), "DuckDuckGo logo should be displayed on homepage"
        );
    }
}
