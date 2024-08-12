package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="@smoke and not @regression or @tag1",
				features = {"src/test/resources/Feature/SwagLab/rahulshettyclass.feature"},
				glue = {"apphook","stepDefination.SwagLab"},
				plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/"})

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
