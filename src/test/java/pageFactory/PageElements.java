package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageElements {
    public WebDriver driver;

    {
        PageFactory.initElements(PageBookStoreApplication.driver, this);
    }

    @FindBy(xpath = "//div[normalize-space()='Elements']") private static WebElement TabElements;
    @FindBy(xpath = "//span[normalize-space()='Web Tables']") private static WebElement OptionWebTables;

    @FindBy(id = "addNewRecordButton") private static WebElement btnAdd;

    @FindBy(id = "firstName") private static WebElement txtFirstName;
    @FindBy(id = "lastName") private static WebElement txtLastName;
    @FindBy(id = "userEmail") private static WebElement txtEmail;
    @FindBy(id = "age") private static WebElement txtAge;
    @FindBy(id = "salary") private static WebElement txtSalary;
    @FindBy(id = "department") private static WebElement txtDepartment;
    @FindBy(id = "submit") private static WebElement btnSubmit;

    public void clickOnTabElements()
    {
        TabElements.click();
    }

    public void clickOnOptionWebTables()
    {
        OptionWebTables.click();
    }

    public void clickOnbtnAdd()
    {
        btnAdd.click();
    }

    public void fillRegistrationForm()
    {
        txtFirstName.sendKeys("abd");
        txtLastName.sendKeys("shajka");
        txtEmail.sendKeys("abcd@gmail.com");
        txtAge.sendKeys("25");
        txtSalary.sendKeys("12345");
        txtDepartment.sendKeys("ABC");
        btnSubmit.click();
    }

}
