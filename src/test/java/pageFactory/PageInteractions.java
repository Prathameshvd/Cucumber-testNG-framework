package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageInteractions {
    public WebDriver driver;

//    public PageInteractions(){} Commented as its working fine

    {
        driver = PageBookStoreApplication.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[normalize-space()='Interactions']") public static WebElement abcd;

}
