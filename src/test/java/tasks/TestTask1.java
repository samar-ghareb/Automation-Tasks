package tasks;

import engine.Bot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageTask1;

public class TestTask1 {
    private Bot bot;
    private PageTask1 page;

    @BeforeMethod
    public void setup() {
        bot = new Bot();
        page = new PageTask1(bot);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        bot.quit();
    }

    @Test
    public void assertThatThePageTitleIsGoogle() {
        page.open();
        String actual = page.getTitle();

        Assert.assertEquals(actual, "Google",
                "Expected 'Google' but got: " + actual);
    }
}
