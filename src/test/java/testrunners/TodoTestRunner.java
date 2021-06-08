package testrunners;

//Runner with cucumber reports and extent report

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/parallel/TodoPage1.feature",
		glue= {"stepDefinitions"},
		plugin = { "pretty", "json:target/cucumber-reports/TodoPage1.json",
				"junit:target/cucumber-reports/TodoPage1.xml",
				"html:target/cucumber-reports","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html","json:target/cucumber-reports/Cucumber.json" },
		monochrome = true
)


public class TodoTestRunner {
	@AfterClass
	public static void setup() {
		// Loads the extent config xml to customize on the report.

		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows");
		Reporter.setTestRunnerOutput("Sample test runner output message");


	}

}
