package com.qa.TestData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EmpProfileExcel {

	public static int column = 0;
	public static int row = 0;
	public static Sheet sheet = null;
	public static Workbook workbook = null;
	public static FileInputStream fs = null;
	final public static String path = "src\\test\\resources\\EmplloyeeProfileData.xlsx";

	public static void excelReadDAta() throws IOException {
		fs = new FileInputStream(path);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheetAt(0);
		Iterator<Row> row = sheet.iterator();
		while (row.hasNext()) {
			row.next().setRowNum(1);
			Row row1 = row.next();
			Iterator<Cell> column = row1.cellIterator();
			while (column.hasNext()) {
				System.out.println(column.next());
			}
		}
	}

	public void employeeDetails() {

	}
}