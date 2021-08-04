package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.sql.DriverManager;

public class MouseHover {

    public static void main (String[] args) {

        final Logger logger = LoggerFactory.getLogger(MouseHover.class);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://codetoautomate.com/educative-selenium-demo/");

        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

        // scroll to element
        jsDriver.executeScript("document.getElementById('mouseover').scrollIntoViewIfNeeded()");

        WebElement source = driver.findElement(By.id("mouseover"));
        Actions action = new Actions(driver);
        action.moveToElement(source).build().perform();

        logger.info("mouse over example");

        //driver.close();
    }


}
