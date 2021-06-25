package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ViewMyDetailsPage;

public class LoginTest extends Base {
	
	@Test
	public void modifyPersonalDetails() throws Throwable {	
		LoginPage lp=new LoginPage(driver);
		lp.do_Login(test);
		HomePage hp=new HomePage(driver);
		hp.clickOnMyInfoTab(test);
		ViewMyDetailsPage vp=new ViewMyDetailsPage(driver);
		vp.editMyPersonalDetails(test);	
		hp.logOut();
		
	}
	
	@Test
	public void verifyTitle() throws Throwable {
		LoginPage lp=new LoginPage(driver);
		lp.do_Login(test);
		HomePage hp=new HomePage(driver);
		hp.verifyTitle();
	}

}
