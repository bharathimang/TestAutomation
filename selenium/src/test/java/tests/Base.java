package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ReadConfigData;
import utils.ReportUtils;

public class Base {
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
	public static ReportUtils repObj;
	
	@BeforeTest
	public void initializeBrowser() throws Throwable {
		ReadConfigData config=new ReadConfigData();
		repObj=new ReportUtils();
		try {
		System.setProperty("webdriver.chrome.driver", config.getChromePath("chromeDriver"));
		driver=new ChromeDriver();
		driver.get(config.getURL("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.log(Status.PASS, "Application has been launched successfully");
		}
		catch(Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}
	
	@AfterTest
	public void tearDown() {
		report.flush();
		driver.close();
		
	}

}
