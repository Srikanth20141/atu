package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	By username = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='password']");
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterUsername(String username ) {
		driver.findElement(this.username).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(this.password).sendKeys(password);
	}
}
