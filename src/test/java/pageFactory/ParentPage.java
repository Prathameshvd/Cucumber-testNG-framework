package pageFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ParentPage {
    public Logger logger = LogManager.getLogger(this.getClass());
    public JavascriptExecutor javascriptExecutor;
    public SoftAssert softAssert = new SoftAssert();

    {
        javascriptExecutor = (JavascriptExecutor) PageBookStoreApplication.driver;
    }

    public void waitUntilElementIsInteractable(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(PageBookStoreApplication.driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .withMessage("Element not found within the timeout period");

        wait.until(driver -> {
            if (element.isDisplayed() && element.isEnabled()) {
                return element;
            } else {
                logger.error("The expected element is not interactable");
                return null;
            }
        });
    }
}
