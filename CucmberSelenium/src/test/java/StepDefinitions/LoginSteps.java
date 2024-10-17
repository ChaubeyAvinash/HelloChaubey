package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	@Given("User is on login page")
	public void user_is_on_login_page() {
		System.out.println("BAba");
	}

	@And("User enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("BAba");
	}

	@When("Clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("BAba");
	}

	@Then("User is navigated to homepage")
	public void user_is_navigated_to_homepage() {
		System.out.println("BAba");
	}

}
