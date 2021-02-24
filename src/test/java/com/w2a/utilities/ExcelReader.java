package com.w2a.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelReader {
	

	public static Workbook wb;
	public static Sheet sh;
	public static FileInputStream fis;
	static int rownum;
	static int colnum;
	public static Cell cell;

	public ExcelReader(String path) {
		File file = new File(path);

		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("exbfhn" + e);
		}

	}

	public int getRowCount(String Sheetname) {

		sh = wb.getSheet(Sheetname);
		rownum = sh.getLastRowNum() + 1;
		return rownum;

	}

	public int getColCount() {
		colnum = sh.getRow(0).getLastCellNum();
		return colnum;
  
	}

	public String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			cell = sh.getRow(RowNum).getCell(ColNum);
		

			String CellData = cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return "";

		}
	}
}