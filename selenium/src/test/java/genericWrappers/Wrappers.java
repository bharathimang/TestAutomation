package genericWrappers;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.Base;

public class Wrappers extends Base {
	
	public static String randomString(int length) {
		String s="abcdefghijklkmn";
		Random random=new Random();
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<length;i++) {
			int index=random.nextInt(s.length());
			char c=s.charAt(index);
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static void captureScreenshot() throws Throwable {
		TakesScreenshot ss=(TakesScreenshot) driver;
		File src=ss.getScreenshotAs(OutputType.FILE);
		File dest=new File("src//test//resources//Output//Screenshots//"+randomString(8)+".png");
		FileHandler.copy(src, dest);
	}
	
	public static void handleAlerts(String action) {
		Alert a=driver.switchTo().alert();
		if(action.equalsIgnoreCase("Accept")) {
			a.accept();
		}
		else if(action.equalsIgnoreCase("Dismiss")) {
			a.dismiss();
		}
		
	}
	
	public static void waitForTheVisiblityOfElement(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}


}
