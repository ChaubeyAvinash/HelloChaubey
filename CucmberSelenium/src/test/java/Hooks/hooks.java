package Hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {
	
    private WebDriver driver;

    // Initialize WebDriver in @Before hook
    @Before
    public void setup() {
        // Initialize WebDriver (Ensure the correct path to your WebDriver executable is set in the system)
        System.setProperty("webdriver.chrome.driver", "E:/JavaPro/src/test/resources/driver/chromedriver.exe");  // Make sure the path is correct
        driver = new ChromeDriver();  // You can use any other WebDriver based on your needs
    }

    // Capture screenshot before each scenario
    @Before
    public void captureScreenshot(Scenario scenario) throws IOException {
        // Ensure WebDriver is initialized and supports taking screenshots
        if (driver instanceof TakesScreenshot) {
            // Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourcePath = screenshot.getScreenshotAs(OutputType.FILE);
            
            // Define destination path
            String screenshotName = scenario.getName().replaceAll(" ", "_") + ".png";
            File destinationPath = new File("C:\\Users\\DELL\\git\\repository1\\CucmberSelenium\\screenshot" + screenshotName);

            // Copy the screenshot to the destination path
            FileUtils.copyFile(sourcePath, destinationPath);
            
            // Optionally, attach the screenshot to the Cucumber report
            byte[] fileContent = FileUtils.readFileToByteArray(destinationPath);
            scenario.attach(fileContent, "image/png", screenshotName);  // Attach the screenshot to the Cucumber report
        } else {
            System.out.println("WebDriver does not support screenshots.");
        }
    }

    // Quit WebDriver after each scenario
    @After
    public void tearDown() {
        // Make sure to quit WebDriver after each scenario
        if (driver != null) {
            driver.quit();
        }
    }

    // Getter for the WebDriver (optional, if you want to access it outside this class)
    public WebDriver getDriver() {
        return driver;
    }
    
}

