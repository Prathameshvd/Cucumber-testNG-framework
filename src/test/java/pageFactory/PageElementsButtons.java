package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageElementsButtons extends ParentPage {

    public Actions actions;

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

    public void clickOnOptionButtons()
    {
        waitUntilElementIsInteractable(optionButtons);
        optionButtons.click();
        logger.info("User clicked on Buttons options successfully");
    }

    public void clickOnbtnDoubleClickMe()
    {
        javascriptExecutor.executeScript("window.scrollBy(0,500);");
        waitUntilElementIsInteractable(btnDoubleClickMe);
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
        // Execute JavaScript to perform a left-click
        javascriptExecutor.executeScript("var event = new MouseEvent('click', {bubbles: true, cancelable: true, view: window}); arguments[0].dispatchEvent(event);", btnClickMe);
        //Assertion has to be implemented
        softAssert.assertEquals(txtClickMe.getText(), "You have done a dynamic click", "Third assertion Successfully !");
        softAssert.assertAll();
        logger.info("User clicked on ClickMe button successfully");
    }
}