package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NaukriPage {
	WebDriver driver=null;

	@Given("User is on the Naukri.com login page")
	public void user_is_on_the_naukri_com_login_page() {
		System.getProperty("webdriver.chrome.driver","E:/JavaPro/src/test/resources/driver/chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    driver.manage().window().maximize();    
	    driver.get("https://www.naukri.com/");
	}
	@When("^User enter the email (.+) and password (.+)$")
	public void user_enter_the_email_and_password(String userName, String pass) {
		driver.findElement(By.id("login_Layer")).click();; 
		driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input")).sendKeys(userName);
		driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div/div[2]/div/form/div[3]/input")).sendKeys(pass);
	    
	}
	@When("User click on the login button")
	public void user_click_on_the_login_button() {
		driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div/div[2]/div/form/div[6]/button")).click();; 
	}
	@Then("^User should see (.+)$")
	public void user_should_see(String userName) {
        String actualTitle = driver.findElement(By.xpath("//div[@class='info__heading']")).getText();
        System.out.println(actualTitle);
        //Assert.assertEquals(userName, actualTitle); 
	    
	}

	@Then("User navigate the profile page and update the resume")
	public void user_navigate_the_profile_page_and_update_the_resume() throws InterruptedException {
	    driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__icon-img-wrapper']")).click();
	    driver.findElement(By.xpath("//a[@class='nI-gNb-info__sub-link']")).click();
	    driver.findElement(By.id("attachCV")).sendKeys("C:\\Users\\DELL\\Downloads\\AvinashResume.pdf"); 
        //driver.findElement(By.xpath("//input[@value='Update resume']")).sendKeys("C:\\Users\\DELL\\Downloads\\Rescued document.pdf"); 

        //driver.findElement(By.id("")).sendKeys("file:///C:/Users/DELL/Downloads/AvinashResume.pdf");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //driver.quit();
	}


 




}
