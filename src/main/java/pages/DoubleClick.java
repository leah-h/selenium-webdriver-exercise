package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DoubleClick {

    public static void main(String[] args) {

        final Logger logger = LoggerFactory.getLogger(DoubleClick.class);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://codetoautomate.com/educative-selenium-demo/");

        // scroll to element
        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
        jsDriver.executeScript("document.getElementById('dbl-click').scrollIntoViewIfNeeded()");

        // find element and perform operation
        WebElement source = driver.findElement(By.id("dbl-click"));

        Actions actions = new Actions(driver);
        actions.doubleClick(source).build().perform();

        // wait for the element
        WebDriverWait wait = new WebDriverWait(driver, 120);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.accept();
        logger.info("double-click example");

        driver.close();

    }
}
