package stepDefinationsImplementation;

import org.openqa.selenium.*;
import pageFactory.PageBookStoreApplication;
import pageFactory.PageForms;
import pageFactory.PageInteractions;
import supportingClasses.ConfigLoader;
import supportingClasses.DriverSetup;
import java.util.Map;

public class StepDefinationImplementation {

    //Instance variable
    public WebDriver driver;
    public DriverSetup driverSetupMethods = new DriverSetup();
    public ConfigLoader configLoader = new ConfigLoader();
    public PageBookStoreApplication pageBookStoreApplication = new PageBookStoreApplication();
    public PageInteractions pageInteractions = new PageInteractions();
    public PageForms pageForms = new PageForms();
    public JavascriptExecutor javascriptExecutor;

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
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,1000);");

        PageBookStoreApplication.Login.click();
    }

    public void logoutUser() {
//        Logout.click();
    }

    public void clickOnFormsTab() {
        PageForms.FormsTab.click();
    }

    public void clickOnPracticeFormOption() {
        PageForms.PracticeFormOption.click();
    }

    public void fillAndSubmitForm() {
        PageForms.FirstName.sendKeys("Rahul");
        PageForms.LastName.sendKeys("Desai");
        javascriptExecutor.executeScript("window.scrollBy(0,1000);");
        PageForms.GenderMale.click();
        PageForms.Email.sendKeys("RahulPatil@gmail.com");
        PageForms.Mobile.sendKeys("1234567890");
//        PageForms.Subjects.click();
//        PageForms.Subjects.sendKeys("History");
        PageForms.HobbiesSports.click();
        PageForms.HobbiesMusic.click();
        javascriptExecutor.executeScript("window.scrollBy(0,1000);");
        PageForms.CurrentAddress.sendKeys("Pune");
        PageForms.State.click();
    }
}