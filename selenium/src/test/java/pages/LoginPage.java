package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericWrappers.Wrappers;
import utils.ReadConfigData;
import utils.ReportUtils;

public class LoginPage {
	public static WebDriver lDriver;
	
	@FindBy(id="txtUsername")
	WebElement userName;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	public static ReadConfigData config;
	public static ReportUtils reportObj;
	
	public LoginPage(WebDriver driver) throws Throwable {
		lDriver=driver;
		PageFactory.initElements(driver, this);
		config=new ReadConfigData();
	}
	
	public void do_Login(ExtentTest test) throws Throwable {
		Wrappers.captureScreenshot();
		try {
		userName.sendKeys(config.getUserName("userName"));
		password.sendKeys(config.getPassword("password"));
		loginBtn.click();
		test.log(Status.PASS, "Login is success");
		}
		catch(Exception e) {
			test.log(Status.FAIL, "Login is NOT success");
		}
		finally {
		Wrappers.captureScreenshot();
		}
	}

}
