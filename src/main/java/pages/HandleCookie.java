package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandleCookie {

    public static void main(String[] args) {

        final Logger logger = LoggerFactory.getLogger(HandleCookie.class);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://codetoautomate.com/educative-selenium-demo/");

        // Create and add a new cookie
        Cookie addCookie = new Cookie("newCookie", "educativeCookie");
        driver.manage().addCookie((addCookie));

        // Get the cookie
        String getCookieValue = driver.manage().getCookieNamed("newCookie").getValue();
        logger.info("Cookie Value: " + getCookieValue);

        // Delete the cookie
        driver.manage().deleteCookieNamed("newCookie");

        driver.close();
    }
}
