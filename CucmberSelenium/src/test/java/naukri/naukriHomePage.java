package naukri;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import ScreenShotHandle.screenshot;
import StepDefinitions.driverFactory;

public class naukriHomePage {
	
	
	screenshot sc=new screenshot();
	//driverFactory df = new driverFactory();
	private WebDriver driver;
	private driverFactory df;

	public naukriHomePage() {
        df = new driverFactory();  // Initialize driverFactory
        driver = df.getDriver("chrome");  // Use a fixed browser name like "chrome"
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized");
        }
    }
	public void naukriLoginPage() {
		driver.get("https://www.naukri.com/");
		sc.takeScreenshot(driver, "naukriHomePage");
	}
	public void naukriLogin(String userName, String pass) {
		driver.findElement(By.id("login_Layer")).click();
		String username_field = df.getXPath("username_field");
		System.out.println("Username XPath: " + username_field);
		driver.findElement(By.xpath(username_field)).sendKeys("avikashyap5mar@gmail.com");
		String pass_field = df.getXPath("pass_field");
		driver.findElement(By.xpath(pass_field)).sendKeys(pass);
		String button_xpath = df.getXPath("button_xpath");
		driver.findElement(By.xpath(button_xpath)).click();
		sc.takeScreenshot(driver, "LoginPage");
		
	}
	public void naukriUserPage(String userName) {
		String actualTitle = driver.findElement(By.xpath("//div[@class='info__heading']")).getText();
        System.out.println(actualTitle);
        int width = 600;
        int height = 400; 
        Dimension dimension = new Dimension(width, height);
        //driver.manage().window().setSize(dimension); 
        sc.takeScreenshot(driver, "UserPage");
        //Assert.assertEquals(userName, actualTitle);
	}
	public void resumeUpdate() {
		
		driver.findElement(By.xpath(df.getXPath("view_profile"))).click();
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Data\\Avinash_Resume.pdf";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement update_resume = wait.until(
		    ExpectedConditions.elementToBeClickable(By.xpath(df.getXPath("update_resume"))));
		//update_resume.sendKeys(filePath);

		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", update_resume, filePath);

		
	    driver.quit();
	   
	}
	

	
}
