package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class Baseclass {
	WebDriver driver;
	LoginPage loginPage = new LoginPage(driver);

	@Parameters("browser")
	@BeforeTest
	public void lunchbrower(String browser) throws InterruptedException {
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		Thread.sleep(4000);
//		driver.navigate().back();
//		driver.getWindowHandle();
//		driver.navigate().refresh();
//		driver.getCurrentUrl();
	}
	
	@Test(invocationCount = 1) // run the testcase mulitiple times 
	public void test() {
		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
	}

	@AfterTest
	public void closeBrowser() {
		// driver.quit();
		// driver.quit();
	}

}
