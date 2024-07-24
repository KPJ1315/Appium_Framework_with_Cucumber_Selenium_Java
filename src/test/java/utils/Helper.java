package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Helper {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public static String[] readExcelData(String filePath, String sheetName) {

		List<String> listStr = new ArrayList<String>(); 

		try {
			File excelFile = new File(filePath);

			if(!excelFile.exists()) {
				System.out.println("File doesn't exists!!!");
				//				return null;
				return null;
			}
			FileInputStream fis = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(excelFile);

			sheet = workbook.getSheet(sheetName); 
			int rows = sheet.getPhysicalNumberOfRows();
			for(int i = 1;i<rows;i++) {
				Row row = sheet.getRow(i);				
				String s = row.getCell(0).toString();
				listStr.add(s);				
			}
			fis.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		String arrStr[] = new String[listStr.size()];
		for(int i=0;i<arrStr.length;i++) {
			arrStr[i]=listStr.get(i);
		}

		Arrays.sort(arrStr);
		return arrStr;		

	}

	

}
