package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericWrappers.Wrappers;
import utils.ExcelReadUtil;

public class ViewMyDetailsPage {
	
	@FindBy(xpath="//input[@value='Edit']")
	WebElement editBtn;
	
	@FindBy(id="personal_txtEmpFirstName")
	WebElement firstName;
	
	@FindBy(id="personal_txtEmpMiddleName")
	WebElement middleName;
	
	@FindBy(id="personal_txtEmpLastName")
	WebElement lastName;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement saveBtn;
	
	public ViewMyDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void editMyPersonalDetails(ExtentTest test) throws Throwable {
		ExcelReadUtil excel=new ExcelReadUtil();
		editBtn.click();
		firstName.clear();
		firstName.sendKeys(excel.getFirstName(1, 0));	
		middleName.clear();
		middleName.sendKeys(excel.getMiddleName(1, 1));	
		lastName.clear();
		lastName.sendKeys(excel.getLastName(1, 2));
		Wrappers.captureScreenshot();
		saveBtn.click();
		Wrappers.captureScreenshot();
		test.log(Status.PASS, "Details has been modified");
	}

}
