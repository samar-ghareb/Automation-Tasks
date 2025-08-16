package engine;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Bot {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public Bot() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Chrome started");
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
        System.out.println("Navigated to: " + url);
    }

    public String getTitle() {
        String title = driver.getTitle();
        System.out.println("Page title: " + title);
        return title;
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        System.out.println("Clicked on element: " + locator);
    }

    public void type(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
        System.out.println("Typed '" + text + "' into: " + locator);
    }

    public void typeAndEnter(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text + Keys.ENTER);
        System.out.println("Typed & ENTER '" + text + "' into: " + locator);
    }

    public boolean isDisplayed(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    public String getAttribute(By locator, String name) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(name);
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
            System.out.println("Chrome closed");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
