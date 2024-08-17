package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageForms {
    public WebDriver driver;

//    public PageInteractions(){} Commented as its working fine

    {
        driver = PageBookStoreApplication.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[normalize-space()='Forms']") public static WebElement FormsTab;
    @FindBy(xpath = "//span[normalize-space()='Practice Form']") public static WebElement PracticeFormOption;


    @FindBy(id = "firstName") public static WebElement FirstName;
    @FindBy(id = "lastName") public static WebElement LastName;
    @FindBy(id = "userEmail") public static WebElement Email;
    @FindBy(xpath = "//label[normalize-space()='Male']") public static WebElement GenderMale;
    @FindBy(id = "userNumber") public static WebElement Mobile;

    @FindBy(xpath = "(//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3'])[1]") public static WebElement Subjects;
    @FindBy(xpath = "//label[normalize-space()='Sports']") public static WebElement HobbiesSports;
    @FindBy(xpath = "//label[normalize-space()='Music']") public static WebElement HobbiesMusic;
    @FindBy(xpath = "//span[normalize-space()='Practice Form']") public static WebElement Picture;
    @FindBy(id = "currentAddress") public static WebElement CurrentAddress;
    @FindBy(xpath = "//span[normalize-space()='Practice Form']") public static WebElement State;
    @FindBy(xpath = "//span[normalize-space()='Practice Form']") public static WebElement City;

    @FindBy(id = "submit") public static WebElement Submit;

}
