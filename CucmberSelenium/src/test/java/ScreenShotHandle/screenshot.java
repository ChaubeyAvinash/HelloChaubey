package ScreenShotHandle;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class screenshot {
	 public void takeScreenshot(WebDriver driver, String fileName) {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        File destination = new File("target/screenshot/" + fileName+".png");
	        try {
	            FileHandler.copy(source, destination);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 

}
