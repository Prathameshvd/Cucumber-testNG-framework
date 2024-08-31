package pageFactory;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import supportingClasses.DatabaseMethods;
import supportingClasses.DummyDatabase;


public class PageElements {
    public DummyDatabase dummyDatabase = new DummyDatabase();
    public DatabaseMethods databaseMethods = new DatabaseMethods();
    public JavascriptExecutor javascriptExecutor;

    {
        PageFactory.initElements(PageBookStoreApplication.driver, this);
    }

    @FindBy(xpath = "//div[normalize-space()='Elements']") private WebElement TabElements;
    @FindBy(xpath = "//span[normalize-space()='Web Tables']") private WebElement OptionWebTables;

    @FindBy(id = "addNewRecordButton") private WebElement btnAdd;

    @FindBy(id = "firstName") private WebElement txtFirstName;
    @FindBy(id = "lastName") private WebElement txtLastName;
    @FindBy(id = "userEmail") private WebElement txtEmail;
    @FindBy(id = "age") private WebElement txtAge;
    @FindBy(id = "salary") private WebElement txtSalary;
    @FindBy(id = "department") private WebElement txtDepartment;
    @FindBy(id = "submit") private WebElement btnSubmit;

    @FindBy(id = "searchBox") private WebElement searchBox;
    @FindBy(xpath = "(//*[name()='path'])[54]") private WebElement btnEdit;
    @FindBy(xpath = "(//*[name()='path'])[55]") private WebElement btnDelete;


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

    public void fillRegistrationForm(String Value)
    {
        String FirstName = getRandomString();
        txtFirstName.sendKeys(FirstName);

        String LatsName = getRandomString();
        txtLastName.sendKeys(LatsName);

        txtEmail.sendKeys(FirstName + LatsName + "@gmail.com");
        dummyDatabase.addValueInDummyDB(Value, FirstName + LatsName + "@gmail.com");

        txtAge.sendKeys(getRandomAge());
        txtSalary.sendKeys(getRandomSalary());
        txtDepartment.sendKeys(getRandomString());
        btnSubmit.click();
    }

    // Instance method to get random string and numeric value
    public String getRandomString()
    {
        return RandomStringUtils.randomAlphabetic(9);
    }

    public String getRandomAge()
    {
        return RandomStringUtils.randomNumeric(2);
    }

    public String getRandomSalary()
    {
        return RandomStringUtils.randomNumeric(3);
    }

    public void searchRecord(String Value) {
        searchBox.sendKeys(dummyDatabase.getValueInDummyDB(Value));
        javascriptExecutor = (JavascriptExecutor) PageBookStoreApplication.driver;
        javascriptExecutor.executeScript("window.scrollBy(0,100);");
        btnEdit.click();
    }

    public void editRecord() {
        txtAge.sendKeys(getRandomAge());
        txtSalary.sendKeys(getRandomSalary());
        txtDepartment.sendKeys(getRandomString());
    }

    public void saveRecord()
    {
        databaseMethods.saveRecordIntoDatabase(txtFirstName.getAttribute("Value"),txtLastName.getAttribute("Value"),
                txtEmail.getAttribute("Value"), Integer.parseInt(txtAge.getAttribute("Value")), Double.parseDouble(txtSalary.getAttribute("Value")),
                txtDepartment.getAttribute("Value"));
        btnSubmit.click();
    }

    public void deleteRecord(String Value) {
        searchBox.clear();
        searchBox.sendKeys(dummyDatabase.getValueInDummyDB(Value));
        btnDelete.click();
    }
}
