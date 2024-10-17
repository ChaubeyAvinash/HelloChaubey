package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/Naukri.feature",
		glue= {"StepDefinitions", "hook"},
		monochrome=false,
		tags = "@smoke",
		plugin= {"pretty","html:target/HtmlReports/report.html"}
		//plugin= {"pretty","json:target/HtmlReports/report.json"}
		)
public class TestRunner {

}
