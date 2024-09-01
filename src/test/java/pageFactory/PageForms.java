package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageForms extends ParentPage {
    public WebDriver driver;
    public JavascriptExecutor javascriptExecutor;

    {
        PageFactory.initElements(PageBookStoreApplication.driver, this);
    }

    @FindBy(xpath = "//div[normalize-space()='Forms']") public static WebElement FormsTab;
    @FindBy(xpath = "//*[@class='text' and text()='Practice Form']") public static WebElement PracticeFormOption;


    @FindBy(id = "firstName") public static WebElement FirstName;
    @FindBy(id = "lastName") public static WebElement LastName;
    @FindBy(id = "userEmail") public static WebElement Email;
    @FindBy(xpath = "//label[normalize-space()='Male']") public static WebElement GenderMale;
    @FindBy(id = "userNumber") public static WebElement Mobile;

    @FindBy(xpath = "//*[@id='subjectsContainer']/div[1]//div[1][@class='//*[@id=\"subjectsContainer\"]//div[1]//div[1][@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']") public static WebElement Subjects;
    @FindBy(xpath = "//label[normalize-space()='Sports']") public static WebElement HobbiesSports;
    @FindBy(xpath = "//label[normalize-space()='Music']") public static WebElement HobbiesMusic;
    @FindBy(xpath = "//span[normalize-space()='Practice Form']") public static WebElement Picture;
    @FindBy(id = "currentAddress") public static WebElement CurrentAddress;
    @FindBy(xpath = "(//*[name()='path'])[3]") public static WebElement State;
    @FindBy(xpath = "//span[normalize-space()='Practice Form']") public static WebElement City;

    @FindBy(id = "submit") public static WebElement Submit;

    public void clickOnFormsTab() {
        FormsTab.click();
        logger.info("User clicked on Form Tab successfully");
    }

    public void clickOnPracticeFormOption() {
        PracticeFormOption.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        PracticeFormOption.click();
        logger.info("User clicked on Form Option successfully");
    }

    public void fillAndSubmitForm() throws InterruptedException {
        FirstName.sendKeys("Rahul");
        LastName.sendKeys("Desai");
        driver=PageBookStoreApplication.driver;
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,1000);");
        GenderMale.click();
        Email.sendKeys("RahulPatil@gmail.com");
        Mobile.sendKeys("1234567890");
//        PageForms.Subjects.click();
//        PageForms.Subjects.sendKeys("History");
        HobbiesSports.click();
        HobbiesMusic.click();
        javascriptExecutor.executeScript("window.scrollBy(0,1000);");
        CurrentAddress.sendKeys("Pune");
//        PageForms.State.click();
//        driver.findElement(By.xpath("(//*[name()='path'])[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]")).click();
//        WebDriverWait wait = new WebDriverWait(driver);
//        WebElement element = wait.until(
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=' css-1uccc91-singleValue' and text()='NCR']"))
//        );
//        System.out.println(element.getText());

//        Thread.sleep(5000);
//
//        driver.findElement(By.xpath("//*[@class=' css-1uccc91-singleValue' and text()='NCR']")).click();
        Submit.click();
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);
        logger.info("User filled Practice Form successfully");
    }
}