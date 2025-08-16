package engine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bot {
    private WebDriver driver;

    public Bot() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
        WebElement element = driver.findElement(locator);
        element.click();
        System.out.println("Clicked on element: " + locator);
    }

    public void type(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
        System.out.println("Typed '" + text + "' into: " + locator);
    }

    public boolean isDisplayed(By locator) {
        boolean displayed = driver.findElement(locator).isDisplayed();
        System.out.println("Element displayed [" + locator + "]: " + displayed);
        return displayed;
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
