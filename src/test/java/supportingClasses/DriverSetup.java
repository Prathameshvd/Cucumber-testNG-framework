package supportingClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

public class DriverSetup {
    public WebDriver driver;
    ConfigLoader configLoader = new ConfigLoader();

    //To store Config.yml file data into the map
    Map<String, String> ConfigFileData = configLoader.configReader();

    //To set up driver
    public WebDriver driverSetup() {
        if((ConfigFileData.get("Browser").equalsIgnoreCase("Chrome")) && (ConfigFileData.get("Grid").equalsIgnoreCase("NoGrid"))) {
            ChromeOptions chromeOptions =new ChromeOptions();
            chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
            System.setProperty(ConfigFileData.get("ChromeDriverClassName"), ConfigFileData.get("ChromeDriverClassPath"));
            driver = new ChromeDriver(chromeOptions);
        }

        if (ConfigFileData.get("Browser").equalsIgnoreCase("Edge") && (ConfigFileData.get("Grid").equalsIgnoreCase("NoGrid"))){
            System.setProperty(ConfigFileData.get("EdgeDriverClassName"), ConfigFileData.get("EdgeDriverClassPath"));
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setExperimentalOption("useAutomationExtension","false");
            edgeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            driver=new EdgeDriver(edgeOptions);
        }

        if(ConfigFileData.get("Browser").equalsIgnoreCase("Chrome") && ConfigFileData.get("Grid").equalsIgnoreCase("Grid")) {
            System.setProperty(ConfigFileData.get("ChromeDriverClassName"), ConfigFileData.get("ChromeDriverClassPath"));
            try {
                URL GridUrl = new URL(ConfigFileData.get("GridURL"));
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName("chrome");

                ChromeOptions chromeOptions =new ChromeOptions();
                desiredCapabilities.merge(chromeOptions);
                chromeOptions.setAcceptInsecureCerts(true);
                chromeOptions.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
                driver = new RemoteWebDriver(GridUrl,desiredCapabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        else if (ConfigFileData.get("Browser").equalsIgnoreCase("Edge") && ConfigFileData.get("Grid").equalsIgnoreCase("Yes")){
            driver=new EdgeDriver();
        }
        return driver;
    }
}
