package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import supportingClasses.DriverSetup;

public class PageBookStoreApplication {

    //Instance variable
    public static WebDriver driver;
    public DriverSetup driverSetupMethods = new DriverSetup();

    //PageFactory is declared inside constructor of the class to initiate all the elements inside this class
    public PageBookStoreApplication() {
        driver = driverSetupMethods.driverSetup();
        PageFactory.initElements(driver, this);
    }

    //All the required locators
    @FindBy(id = "userName") public static WebElement UserName;
    @FindBy(id = "password") public static WebElement Password;
    @FindBy(id = "login") public static WebElement Login;

    @FindBy(xpath = "//div[normalize-space()='Book Store Application']") public static WebElement BookStoreApplication;
    @FindBy(xpath = "//span[contains(text(),'Profile')]") public static WebElement Profile;
    @FindBy(xpath = "//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']") public static WebElement Logout;

}
