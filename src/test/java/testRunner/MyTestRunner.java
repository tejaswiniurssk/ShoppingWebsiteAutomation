package testRunner;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//Uncomment @RunWith if you are using Junit to run Test
//@RunWith(Cucumber.class)

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

public class MyTestRunner extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
		
}
	
	
	
	


