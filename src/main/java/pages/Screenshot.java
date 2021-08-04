package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void main(String[] args) throws IOException {

        Screenshot.takeScreenshot();

    }

    // taking screenshot of the whole window as a file
    public static File takeScreenshot() throws IOException {

        final Logger logger = LoggerFactory.getLogger(Screenshot.class);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://codetoautomate.com/educative-selenium-demo/");

        // take screenshot of the whole window
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("./src/main/resources/screenshot.png");
        // source.renameTo(destination);
        FileUtils.copyFile(source, destination);

        logger.info("Destination exist? " + destination.exists());

        return destination;

        // driver.close();
    }
}
