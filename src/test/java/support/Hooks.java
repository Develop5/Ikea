package support;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

import static support.TestContest.getDriver;

public class Hooks {
  @Before(order = 0)
  public void scenarioStart() {
    TestContest.initialize();
    getDriver().manage().deleteAllCookies();
    getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @After(order = 0)
  public void scenarioEnd(Scenario scenario) {
    if (scenario.isFailed()) {
      TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
      byte[] screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
      scenario.embed(screenshot, "image/png");
    }
    TestContest.teardown();
  }
}

