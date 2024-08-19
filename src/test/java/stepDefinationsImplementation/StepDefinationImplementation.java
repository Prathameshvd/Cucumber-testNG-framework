package stepDefinationsImplementation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageFactory.PageBookStoreApplication;
import pageFactory.PageForms;
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PageForms.PracticeFormOption.click();
    }

    public void fillAndSubmitForm() throws InterruptedException {
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
//        PageForms.State.click();
//        driver.findElement(By.xpath("(//*[name()='path'])[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//        WebDriverWait wait = new WebDriverWait(driver);
//        WebElement element = wait.until(
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=' css-1uccc91-singleValue' and text()='NCR']"))
//        );
//        System.out.println(element.getText());

//        Thread.sleep(5000);
//
//        driver.findElement(By.xpath("//*[@class=' css-1uccc91-singleValue' and text()='NCR']")).click();
        PageForms.Submit.click();
        driver.navigate().back();
        Thread.sleep(5000);
    }
}