package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;

public class Testcase_01 extends Baseclass{
	
	LoginPage loginPage = new LoginPage(driver);
	
	@Test
	public void test() {
		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
	}

}
