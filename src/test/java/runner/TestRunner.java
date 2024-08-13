package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/FetureFiles/DemoQA.feature",
        glue = {"stepDefinations"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
