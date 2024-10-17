package dockerExecution;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class executeTestInDocker {
	WebDriver driver=null;
	@Test
	public void localTest() throws MalformedURLException {
		//WebDriverManager.chromedriver().setup();
		
		DesiredCapabilities DC = new DesiredCapabilities();
		//DC.setBrowserName(BrowserType.CHROME);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DC);
		driver.get("https://google.co.in");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
