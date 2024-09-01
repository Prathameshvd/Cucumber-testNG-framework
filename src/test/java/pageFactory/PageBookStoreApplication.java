package pageFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import supportingClasses.ConfigLoader;
import supportingClasses.ScreenshotAndCreateWordFile;

import java.util.Map;

public class PageBookStoreApplication extends ParentPage {

    //Instance variable
    public static WebDriver driver;
    public JavascriptExecutor javascriptExecutor;

    //To load ConfigFileData from the Config YAML file
    public ConfigLoader configLoader = new ConfigLoader();
    Map<String, String> ConfigFileData = configLoader.configReader();


    //PageFactory is declared inside constructor of the class to initiate all the elements inside this class
    public PageBookStoreApplication() {
        driver = ScreenshotAndCreateWordFile.driver;
        PageFactory.initElements(driver, this);
    }

    //All the required locators
    @FindBy(id = "userName") public static WebElement UserName;
    @FindBy(id = "password") public static WebElement Password;
    @FindBy(id = "login") public static WebElement Login;

    @FindBy(xpath = "//div[normalize-space()='Book Store Application']") public static WebElement BookStoreApplication;
    @FindBy(xpath = "//span[contains(text(),'Profile')]") public static WebElement Profile;
    @FindBy(xpath = "//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']") public static WebElement Logout;

    //Instance Methods
    public void openURL() {
        driver.manage().window().maximize();
        driver.get(ConfigFileData.get("AppURL"));
        logger.info("App open successfully");
    }

    public void loginUser() {
        UserName.sendKeys(ConfigFileData.get("UserName"));
        Password.sendKeys(ConfigFileData.get("Password"));
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,1000);");
        Login.click();
        logger.info("User login successfully");
    }
}
