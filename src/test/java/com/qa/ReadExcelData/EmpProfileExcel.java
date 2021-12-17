package com.qa.ReadExcelData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
	public static int lastCellNum;
	final public static String path = "src\\test\\resources\\Book1.xlsx";
	public static List<String> excelempData = new ArrayList<>();

	public void excelReadDAta() throws IOException, InterruptedException {
		fs = new FileInputStream(path);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheetAt(0);
		Iterator<Row> row = sheet.iterator();
		while (row.hasNext()) {
			Row row1 = row.next();
			Iterator<Cell> column = row1.cellIterator();
			while (column.hasNext()) {
				excelempData.add(column.next().toString().replace(".0", "").replace(".", "")
						.replaceAll("gmail", "gmail.").replace("E8", "").replace("E9", "").replace("jpg", ".jpg")
						.replace("jpeg", ".jpeg").replace("png", ".png").trim());
			}
			lastCellNum = row1.getLastCellNum();
		}
	}

	public List<String> employeeExcelInitilizer() throws InterruptedException, IOException {
		return excelempData;
	}

}
