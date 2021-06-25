package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import tests.Base;

public class ReportUtils extends Base {
	
	public ReportUtils() {
		
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("src//test//resources//Output//reports//report.html");		
		report=new ExtentReports();
		report.attachReporter(reporter);
		test=report.createTest("Modification");
		
	}
	
	public void reportPass(String message) {
		test.log(Status.PASS, message);
	}
	
	public void reportFail(String message) {
		test.log(Status.FAIL, message);
	}
	

}
