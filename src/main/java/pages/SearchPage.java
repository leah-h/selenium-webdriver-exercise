package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SearchPage {

    public static void main(String[] args) {

        final Logger logger = LoggerFactory.getLogger(SearchPage.class);

        String URL = "https://www.google.com";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // open url
        driver.get(URL);

        // Find element will wait for 20 seconds for the WebElement
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("educative", Keys.RETURN);

        // create a WebDriver wait object, max wait time of 15 seconds before throwing
        // an exception
        By locator = By.xpath("//a[contains(@href, 'https://www.educative.io')]");
        List<WebElement> list = driver.findElements(locator);
        logger.info("list: " + list);

        Set<Cookie> getAllCookies = driver.manage().getCookies();
        logger.info("getAllCookies: " + getAllCookies);

    }
}
