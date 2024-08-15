package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "FeatureFiles/DemoQA.feature",
        glue = {"stepDefinations"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
