package stepDefinationsImplementation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import supportingClasses.ConfigLoader;
import supportingClasses.DriverSetup;

import javax.xml.xpath.XPath;
import java.util.Map;

public class StepDefinationImplementation {

    //Instance variable
    public WebDriver driver;
    public DriverSetup driverSetupMethods = new DriverSetup();
    public ConfigLoader configLoader = new ConfigLoader();

    //PageFactory is declared inside constructor of the class to initiate all the elements inside this class
    public StepDefinationImplementation() {
        driver = driverSetupMethods.driverSetup();
        PageFactory.initElements(driver, this);
    }

    //To load ConfigFileData from the Config YAML file
    Map<String, String> ConfigFileData = configLoader.configReader();

    //All the required locators
    @FindBy(id = "userName") public WebElement UserName;
    @FindBy(id = "password") public WebElement Password;
    @FindBy(id = "login") public WebElement Login;

    @FindBy(xpath = "//div[normalize-space()='Book Store Application']") public WebElement BookStoreApplication;
    @FindBy(xpath = "//span[contains(text(),'Profile')]") public WebElement Profile;

    @FindBy(xpath = "//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']") public WebElement Logout;

    //Instance Methods
    public void openURL() {
        driver.manage().window().maximize();
        driver.get(ConfigFileData.get("AppURL"));
    }

    public void loginUser() {
        UserName.sendKeys(ConfigFileData.get("UserName"));
        Password.sendKeys(ConfigFileData.get("Password"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,1000);");

        Login.click();
        driver.findElement(By.xpath("//div[normalize-space()='Interactions']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Sortable')]")).click();
        javascriptExecutor.executeScript("window.scrollBy(0,1000);");
        try {
            driver.wait(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Have to implement logout functionality
        System.out.println(BookStoreApplication.isEnabled());
        System.out.println(Profile.isEnabled());
        Profile.click();
//        Logout.click();
    }

    public void logoutUser() {

        Logout.click();
    }

}
