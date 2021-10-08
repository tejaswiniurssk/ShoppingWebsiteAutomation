package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"stepDefinitions", "appHooks"},
        //tags = {@fillForm},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        		"timeline:test-output-thread/"
        },
        monochrome = true,
        dryRun = false
)
public class MyTestRunner {

}
