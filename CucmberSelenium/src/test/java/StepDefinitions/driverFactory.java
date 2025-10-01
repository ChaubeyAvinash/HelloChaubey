package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class driverFactory {
	private Properties properties;
	
    public WebDriver getDriver(String browser) {
        WebDriver driver = null;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        if (browser.equalsIgnoreCase("chrome")) {
    		System.getProperty("webdriver.chrome.driver","E:/JavaPro/src/test/resources/driver/chromedriver.exe");
    	    driver=new ChromeDriver();
    	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	    driver.manage().window().maximize();
    	    
        }

        return driver;
    }
     public driverFactory() {
         // Initialize the Properties object and load the properties file
         properties = new Properties();
         try {
             // Update the path to the properties file to match your project structure
             FileInputStream file = new FileInputStream("src/test/resources/config.properties");
             properties.load(file);
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

     public String getXPath(String key) {
         return properties.getProperty(key);
     }
}
