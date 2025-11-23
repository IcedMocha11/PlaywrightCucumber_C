package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions", "utils"},
        tags = ""
)
public class TestRunner extends AbstractTestNGCucumberTests {




}
