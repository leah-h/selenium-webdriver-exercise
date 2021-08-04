package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RightClick {

    public static void main(String[] args) {

        final Logger logger = LoggerFactory.getLogger(RightClick.class);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://codetoautomate.com/educative-selenium-demo/");

        WebElement source = driver.findElement(By.id("prompt"));
        Actions actions = new Actions(driver);

        actions.contextClick(source).build().perform();

        logger.info("right-click example");

        // driver.close();

    }
}
