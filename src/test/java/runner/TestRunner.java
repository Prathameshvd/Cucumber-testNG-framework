package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "FeatureFiles/DemoQA.feature",               //Feature file path
        glue = {"stepDefinations","supportingClasses"},         //StepDefination and CucumberHooks path
        tags = "@DemoQA_Elements_Buttons_MouseAction",
        plugin = {
                "pretty", // Prints a readable version of the test results
                "html:target/cucumber-reports/cucumber.html", // Generates an HTML report
                "json:target/cucumber-reports/cucumber.json", // Generates a JSON report
                "junit:target/cucumber-reports/cucumber.xml" // Generates a JUnit XML report
        },
        monochrome = true // Makes the output more readable
)
public class TestRunner extends AbstractTestNGCucumberTests {
}