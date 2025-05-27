package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/Naukri.feature",
		glue= {"StepDefinitions"},
		monochrome=true,
		tags = "@smoke",
		plugin= {"pretty","html:target/HtmlReports/report.html","pretty","json:target/HtmlReports/report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		//plugin= {"pretty","json:target/HtmlReports/report.json"}
		)
public class TestRunner {

}
