package Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import ScreenShotHandle.screenshot;

import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class hook {
	private WebDriver driver; // Assume driver is initialized elsewhere

    public void Hooks(WebDriver driver) {
        this.driver = driver;
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_") + ".png";
            screenshot.takeScreenshot(driver, screenshotName);
        }
        // Additional teardown actions can be performed here
    }
}
