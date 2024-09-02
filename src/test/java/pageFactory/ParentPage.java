package pageFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    public Logger logger = LogManager.getLogger(this.getClass());
    public JavascriptExecutor javascriptExecutor;

    {
//        PageFactory.initElements(PageBookStoreApplication.driver, this);
        javascriptExecutor = (JavascriptExecutor) PageBookStoreApplication.driver;
    }
}
