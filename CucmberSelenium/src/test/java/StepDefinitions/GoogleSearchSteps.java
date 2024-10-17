package StepDefinitions;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	WebDriver driver=null;
	@Given("browser is open")
	public void browser_is_open() {
	    System.getProperty("webdriver.chrome.driver","E:/JavaPro/src/test/resources/driver/chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    driver.manage().window().maximize();    }

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		driver.get("https://www.facebook.com/login/");
//		String actualText = driver.findElement(By.xpath("//*[@id=\\\"header_block\\\"]/span/div")).getText();
//
//        Assert.assertEquals("Log in to Facebook", actualText);
	}

	@When("user enters a text insearch box")
	public void user_enters_a_text_insearch_box() {
		driver.findElement(By.id("email")).sendKeys("9135178078");
		driver.findElement(By.id("pass")).sendKeys("Achaubey@123");

	    
	}

	@And("hits enter")
	public void hits_enter() {
		driver.findElement(By.id("loginbutton")).click();; 
	    
	}

	@Then("User is navigated to search results")
	public void user_is_navigated_to_search_results() {
	    
	}

}
