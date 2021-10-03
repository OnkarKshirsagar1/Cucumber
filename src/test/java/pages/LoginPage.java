package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	private By txt_username = By.id("userid");
	private By txt_password = By.id("password");
	private By btn_login = By.xpath("//button[@type='submit']");
	private By btn_logout = By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
	
	public boolean validateLogin() {
		boolean s = driver.findElement(btn_logout).isDisplayed();
		driver.close();
		return s;		
	}

}
