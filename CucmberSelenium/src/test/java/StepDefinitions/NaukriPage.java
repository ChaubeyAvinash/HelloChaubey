 package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import naukri.naukriHomePage;

import java.time.Duration;

public class NaukriPage {
	LoginSteps ls = new LoginSteps();
	naukriHomePage NaukriHomePage = new naukriHomePage();
	//driverFactory df = new driverFactory();
	private WebDriver driver;
	private driverFactory df;


	@Given("User is on the Naukri.com login page")
	public void user_is_on_the_naukri_com_login_page() {
		NaukriHomePage.naukriLoginPage();
		
	}
	@When("^User enter the email (.+) and password (.+)$")
	public void user_enter_the_email_and_password(String userName, String pass) {
		NaukriHomePage.naukriLogin(userName, pass);
		}
	
	@Then("^User should see (.+)$")
	public void user_should_see(String userName) {
		NaukriHomePage.naukriUserPage(userName);
        	    
	}

	@Then("User navigate the profile page and update the resume")
	public void user_navigate_the_profile_page_and_update_the_resume() throws InterruptedException {
		NaukriHomePage.resumeUpdate();
	    
	}


 




}
