package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

public class PageElementsButtons extends ParentPage {

    public Actions actions;
    public SoftAssert softAssert = new SoftAssert();

    {
        PageFactory.initElements(PageBookStoreApplication.driver, this);
        actions =new Actions(PageBookStoreApplication.driver);
    }

    @FindBy(xpath = "//div[normalize-space()='Elements']") private WebElement tabElements;
    @FindBy(xpath = "//span[normalize-space()='Buttons']") private WebElement optionButtons;

    @FindBy(id = "doubleClickBtn") private WebElement btnDoubleClickMe;
    @FindBy(id = "rightClickBtn") private WebElement btnRightClickMe;
    @FindBy(xpath = "(//button[normalize-space()='Click Me'])[1]") private WebElement btnClickMe;

    @FindBy(id = "doubleClickMessage") private WebElement txtDoubleClickMe;
    @FindBy(id = "rightClickMessage") private WebElement txtRightClickMe;
    @FindBy(id = "dynamicClickMessage") private WebElement txtClickMe;


    public void clickOnTabElements()
    {
        tabElements.click();
        logger.info("User clicked on Elements Tab successfully");
    }

    public void clickOnOptionButtons()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        optionButtons.click();
        logger.info("User clicked on Buttons options successfully");
    }

    public void clickOnbtnDoubleClickMe()
    {
        javascriptExecutor.executeScript("window.scrollBy(0,500);");
        actions.doubleClick(btnDoubleClickMe).perform();
        softAssert.assertEquals(txtDoubleClickMe.getText(), "You have done a double click", "First assertion Successfully !");
        logger.info("User clicked on DoubleClickMe button successfully");
    }

    public void clickOnbtnRightClickMe()
    {
        // Execute JavaScript to perform a right-click
        javascriptExecutor.executeScript("var event = new MouseEvent('contextmenu', {bubbles: true, cancelable: true, view: window}); arguments[0].dispatchEvent(event);", btnRightClickMe);
        softAssert.assertEquals(txtRightClickMe.getText(), "You have done a right click", "Second assertion Successfully !");
        logger.info("User clicked on RightClick button successfully");
    }

    public void clickOnbtnClickMe()
    {
        actions.contextClick(btnClickMe).perform();
        // Execute JavaScript to perform a left-click
        javascriptExecutor.executeScript("var event = new MouseEvent('click', {bubbles: true, cancelable: true, view: window}); arguments[0].dispatchEvent(event);", btnClickMe);
        btnClickMe.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Assertion has to be implemented
        System.out.println("ABCD" + txtClickMe.getText());
        softAssert.assertEquals(txtClickMe.getText(), "You have done a dynamic click", "Third assertion Successfully !");
        softAssert.assertAll();
        logger.info("User clicked on ClickMe button successfully");
    }
}