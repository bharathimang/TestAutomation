package genericWrappers;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class CompareExcelData {
	
	public static LinkedList<String> columns=new LinkedList<String>();
	public static LinkedList<String> sheetData1=new LinkedList<String>();
	public static LinkedList<String> sheetData2=new LinkedList<String>();
	
	@Test
	public static void sendRowObjects() throws Throwable {
		File file1=new File("C:\\Users\\bhara\\Documents\\DesktopItems\\Testing1.xlsx");//Excel path should be given
		FileInputStream fis1=new FileInputStream(file1);
		XSSFWorkbook wb1=new XSSFWorkbook(fis1);
		XSSFSheet sheet1=wb1.getSheet("Test");
		
		File file2=new File("C:\\Users\\bhara\\Documents\\DesktopItems\\Testing2.xlsx");//Excel path should be given
		FileInputStream fis2=new FileInputStream(file2);
		XSSFWorkbook wb2=new XSSFWorkbook(fis2);
		XSSFSheet sheet2=wb2.getSheet("Test");
		for(int i=0;i<=sheet1.getLastRowNum();i++) {
			compareExcelData(sheet1.getRow(0), sheet1.getRow(i), sheet2.getRow(i));
		}
		System.out.println(sheetData1);
		System.out.println(sheetData2);
	}
	
	public static void compareExcelData(XSSFRow row0, XSSFRow row1, XSSFRow row2) {

		
		for(int i=0;i<row0.getLastCellNum();i++) {
			String data1=null;
			try {
			data1 = row1.getCell(i).getStringCellValue();
			}
			catch(Exception e) {
				data1=e.getMessage();
			}
			
			String data2=null;
			try {
			data2 = row2.getCell(i).getStringCellValue();
			}
			catch(Exception e) {
				data2=e.getMessage();
			}
			
			if(!(data1.equals(data2))) {
				try {
				columns.add(row0.getCell(i).getStringCellValue());
				}
				catch(Exception e) {
					columns.add(e.getMessage());
				}
				sheetData1.add(data1);
				sheetData2.add(data2);
			}
		}


	}
}
