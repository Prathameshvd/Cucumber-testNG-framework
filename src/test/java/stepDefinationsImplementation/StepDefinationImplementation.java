package stepDefinationsImplementation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import pageFactory.PageBookStoreApplication;
import pageFactory.PageInteractions;
import supportingClasses.ConfigLoader;
import supportingClasses.DriverSetup;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StepDefinationImplementation {

    //Instance variable
    public WebDriver driver;
    public DriverSetup driverSetupMethods = new DriverSetup();
    public ConfigLoader configLoader = new ConfigLoader();
    PageBookStoreApplication pageBookStoreApplication = new PageBookStoreApplication();
    PageInteractions pageInteractions = new PageInteractions();

    //PageFactory is declared inside constructor of the class to initiate all the elements inside this class
    public StepDefinationImplementation() {
    }

    //To load ConfigFileData from the Config YAML file
    Map<String, String> ConfigFileData = configLoader.configReader();

    //All the required locators
//    @FindBy(id = "userName")
//    public WebElement UserName;
//    @FindBy(id = "password")
//    public WebElement Password;
//    @FindBy(id = "login")
//    public WebElement Login;
//
//    @FindBy(xpath = "//div[normalize-space()='Book Store Application']")
//    public WebElement BookStoreApplication;
//    @FindBy(xpath = "//span[contains(text(),'Profile')]")
//    public WebElement Profile;
//    @FindBy(xpath = "//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']")
//    public WebElement Logout;

    //Instance Methods
    public void openURL() {
        driver=PageBookStoreApplication.driver;
        driver.manage().window().maximize();
        driver.get(ConfigFileData.get("AppURL"));
    }


    public void loginUser() {
        PageBookStoreApplication.UserName.sendKeys(ConfigFileData.get("UserName"));
        PageBookStoreApplication.Password.sendKeys(ConfigFileData.get("Password"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,1000);");

        PageBookStoreApplication.Login.click();
        driver.findElement(By.xpath("//div[normalize-space()='Interactions']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Sortable')]")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        javascriptExecutor.executeScript("window.scrollBy(0, 1000);");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        PageBookStoreApplication.BookStoreApplication.click();
        PageBookStoreApplication.Profile.click();

        PageInteractions.abcd.click();
    }

    public void logoutUser() {
//        Logout.click();
    }
}