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

public class DragAndDrop {

    public static void main(String[] args) throws AWTException {

        final Logger logger = LoggerFactory.getLogger(DragAndDrop.class);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://codetoautomate.com/educative-selenium-demo/");

        // Scroll to the end of the page
        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
        jsDriver.executeScript("document.getElementById('div1').scrollIntoViewIfNeeded()");

        WebElement source = driver.findElement(By.id("drag1"));
        WebElement target = driver.findElement(By.id("div1"));

        // Use Robot, move the mouse pointer to the target element
        Robot robot = new Robot();

        // get coordinates to the center of the target element
        int x = target.getLocation().getX() + target.getRect().getWidth() / 2;
        int y = target.getLocation().getY() / 2 - target.getRect().getHeight();

        // move the mouse pointer to the coordinates
        robot.mouseMove(x, y);

        // perform drag-drop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();

        //driver.quit();
    }
}
