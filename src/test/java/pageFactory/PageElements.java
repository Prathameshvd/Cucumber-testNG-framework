package pageFactory;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import supportingClasses.DatabaseMethods;
import supportingClasses.DummyDatabase;


public class PageElements extends ParentPage {
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
        logger.info("User clicked on Elements Tab successfully");
    }

    public void clickOnOptionWebTables()
    {
        OptionWebTables.click();
        logger.info("User clicked on Web Table successfully");
    }

    public void clickOnbtnAdd()
    {
        btnAdd.click();
        logger.info("User clicked on Add button successfully");
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
        logger.info("User filled Registration Form successfully");
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
        logger.info("User search record successfully");
    }

    public void editRecord() {
        txtAge.clear(); txtAge.sendKeys(getRandomAge());
        txtSalary.clear(); txtSalary.sendKeys(getRandomSalary());
        txtDepartment.clear(); txtDepartment.sendKeys(getRandomString());
        logger.info("User edited record successfully");
    }

    public void saveRecord()
    {
        databaseMethods.saveRecordIntoDatabase(txtFirstName.getAttribute("Value"),txtLastName.getAttribute("Value"),
                txtEmail.getAttribute("Value"), Integer.parseInt(txtAge.getAttribute("Value")), Double.parseDouble(txtSalary.getAttribute("Value")),
                txtDepartment.getAttribute("Value"));
        btnSubmit.click();
        logger.info("User save record successfully");
    }

    public void deleteRecord(String Value) {
        searchBox.clear();
        searchBox.sendKeys(dummyDatabase.getValueInDummyDB(Value));
        btnDelete.click();
        logger.info("User deleted record successfully");
    }
}
