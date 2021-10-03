package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginSteps_pom {
	
	
	WebDriver driver;
	static LoginPage login;
	
//============================================================================	
	@Given("User is at kite loginpage")
	public void user_is_at_kite_loginpage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://kite.zerodha.com/");
		
		System.out.println(driver.getTitle());
	}

	@When("^enters kite (.*) and (.*)$")
	public void enters_kite_ye4707_and_ok_ojas1805(String username, String password) throws InterruptedException {
	    login = new LoginPage(driver);
	    login.enterUsername(username);
	    Thread.sleep(3000);
	    login.enterPassword(password);
	    Thread.sleep(3000);
	}

	@And("Click on kite Login button")
	public void click_on_kite_login_button() throws InterruptedException {
		login.clickLogin();
		Thread.sleep(3000);
	}

	@Then("Validate Pin Page")
	public void Validate_Pin_Page() {
		login.validateLogin();
	}

	

}
