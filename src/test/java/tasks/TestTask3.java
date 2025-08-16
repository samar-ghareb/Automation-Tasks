package tasks;

import engine.Bot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageTask3;

public class TestTask3 {
    private Bot bot;
    private PageTask3 duckPage;

    @BeforeMethod
    public void setup() {
        bot = new Bot();
        duckPage = new PageTask3(bot);
    }

    @Test
    public void testDuckDuckGoFirstResultForSelenium() {
        duckPage.open();
        duckPage.search("Selenium WebDriver");

        String actualFirstResult = duckPage.getFirstResultHref();
        String expected = "https://www.selenium.dev/documentation/webdriver/";

        Assert.assertEquals(actualFirstResult, expected,
                "First result link should be Selenium WebDriver documentation page");
    }

    @AfterMethod
    public void teardown() {
        bot.quit();
    }
}
