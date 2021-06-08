package stepDefinitions;

import Loggerutil.Log;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static org.apache.logging.log4j.LogManager.getLogger;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
       Reporter.assignAuthor("Ketan");
        Log.info("Scenario "+scenario+" Started " +
                getLogger().toString() );
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {

                File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
                Files.copy(sourcePath, destinationPath);
                Reporter.addScreenCaptureFromPath(destinationPath.toString());

                // This takes a screenshot from the driver at save it to the specified location
                            TakesScreenshot ts = (TakesScreenshot) testContext.getWebDriverManager().getDriver();
                            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                            scenario.embed(screenshot, "image/png");
                Log.info("Screenshot is attached "+scenario+ " with screenshot name "+screenshotName + " " +getLogger().toString() );

            }catch (IOException e) {
                Log.error("Error :" +e.toString());
            }

        }
    }


    @After(order = 0)
    public void AfterSteps() {

        testContext.getWebDriverManager().quitDriver();
    }

}
