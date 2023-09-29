package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	FileInputStream fins;


	
	public ExcelUtils(String Excelpath, String Sheetname) {

		try {
			wb = new XSSFWorkbook(new FileInputStream(Excelpath));
			sheet = wb.getSheet(Sheetname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getRownum() {
		
		return sheet.getPhysicalNumberOfRows();
	}
	
	public int getColnum() {
		
		int colNum = sheet.getRow(0).getLastCellNum();
		return colNum;
	}
	
	
	public String getStringcellData(int row, int col) {
		
		
		DataFormatter fmt = new DataFormatter();
		String cellValue = fmt.formatCellValue(sheet.getRow(row).getCell(col));
		return cellValue;
	}
	
	
	public void closeExcelWB() {
		try {
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
		
	}
	
	

}
