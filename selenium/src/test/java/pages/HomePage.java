package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericWrappers.Wrappers;

public class HomePage {
	
	public static WebDriver lDriver;
	
	@FindBy(id="menu_pim_viewMyDetails")
	WebElement myInfoTab;
	
	@FindBy(xpath="//a[@id='welcome']")
	WebElement user;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logOut;
	
	public HomePage(WebDriver driver) {
		lDriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnMyInfoTab(ExtentTest test) throws Throwable {
		myInfoTab.click();
		Wrappers.captureScreenshot();
		test.log(Status.PASS, "Clicked on my info tab");
	}
	
	public void logOut() {
		user.click();
		logOut.click();
	}
	
	public void verifyTitle() {
		String actualTitle=lDriver.getTitle();
		String expTitle="OrangeHRM";
		if(actualTitle.equals(expTitle)) {
			System.out.println("Pass: Title verification is success");
		}else {
			System.err.println("Fail: Title verificaiton is failed");
		}
	}

}
