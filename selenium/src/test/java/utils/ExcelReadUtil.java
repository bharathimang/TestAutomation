package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class ExcelReadUtil {
	public static XSSFSheet sheet;
	
	public ExcelReadUtil() throws Throwable {
		File file=new File("src/test/resources/testDatas/Testing.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet("Sheet1");
	}
	
	public String getFirstName(int row, int cell) {
		return sheet.getRow(row).getCell(cell).toString();
	}
	
	public String getMiddleName(int row, int cell) {
		return sheet.getRow(row).getCell(cell).toString();
	}
	
	public String getLastName(int row, int cell) {
		return sheet.getRow(row).getCell(cell).toString();
	}
	
	@Test
	public void compareSheets() throws Throwable {
		File file=new File("C:\\Users\\bhara\\Desktop\\Testing1.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		File file2=new File("C:\\Users\\bhara\\Desktop\\Testing2.xlsx");
		FileInputStream fis2=new FileInputStream(file2);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFWorkbook wb2=new XSSFWorkbook(fis2);
		String sheet1="Test";
		String sheet2="Test";
		
		XSSFSheet s1=wb.getSheet(sheet1);
		XSSFSheet s2=wb2.getSheet(sheet2);
		
		LinkedList<String> ls1=new LinkedList<String>();
		LinkedHashMap<String, Integer> hm1=new LinkedHashMap<String, Integer>();
		LinkedList<String> ls2=new LinkedList<String>();
		LinkedHashMap<String, Integer> hm2=new LinkedHashMap<String, Integer>();
		
		for(int i=0;i<=s1.getLastRowNum();i++) {
			XSSFRow row=s1.getRow(i);
			for(int j=0;j<=row.getLastCellNum();j++) {
				try {
				String value=row.getCell(j).getStringCellValue().toString();
				ls1.add(value);
				hm1.put(value, i);
				}
				catch(Exception e) {
					ls1.add(null);
					hm1.put(null, j);
				}
			}
		}
		
		for(int i=0;i<=s2.getLastRowNum();i++) {
			XSSFRow row=s2.getRow(i);
			for(int j=0;j<=row.getLastCellNum();j++) {
				try {
				String value=row.getCell(j).getStringCellValue().toString();
				ls2.add(value);
				hm2.put(value, i);
				}
				catch(Exception e) {
					ls2.add(null);
					hm2.put(null, j);
				}
			}
		}
		
		System.out.println(ls1);
		System.out.println(hm1);
		System.out.println(ls2);
		System.out.println(hm2);
		
		ls1.removeAll(ls2);
		System.out.println(ls1);
		
		for(String li:ls1) {
			System.out.println(li+":"+hm1.get(li)+"");
		}
		
	}

}
