package Utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputDataProvider {

	String fileWithPath = System.getProperty("user.dir")+"\\TestData\\TestData.xlsx";

	public Object[][] testdata(String SheetName) throws Exception {
		XSSFRow row;
		Object[][] excelData = null;
		File src = new File(fileWithPath);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(SheetName);
		int rowcount = sh.getLastRowNum() - sh.getFirstRowNum();
		System.out.println("rowcount is" + rowcount);
		int rows = sh.getPhysicalNumberOfRows();
		System.out.println("number of rows" + rows);
		int cells = sh.getRow(0).getPhysicalNumberOfCells();
		System.out.println("number of coulum" + cells);
		excelData = new Object[rows - 1][cells];

		for (int i = 1; i < rows; i++) {
			row = sh.getRow(i);
			for (int j = 0; j < cells; j++) {
				excelData[i - 1][j] = row.getCell(j).getStringCellValue();
				System.out.println(excelData[i - 1][j]);

			}
		}

		return excelData;

	}

}