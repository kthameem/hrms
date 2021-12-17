package com.qa.TestData;

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
import com.qa.baseclass.BaseClass;

public class ExcelReadData extends BaseClass {
	public static int column = 0;
	public static int row = 0;
	public static Sheet sheet = null;
	public static Workbook workbook = null;
	public static FileInputStream fs = null;
	final public static String path = "src\\test\\resources\\Invalid_UserPassword_TestData.xlsx";
	public static List<String> userNameList = new ArrayList<String>();
	public static List<String> passwordList = new ArrayList<String>();

	public static void excelReadDAta() throws IOException {
		fs = new FileInputStream(path);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheetAt(0);
		Iterator<Row> row = sheet.iterator();
		while (row.hasNext()) {
			Row row1 = row.next();
			// important now i call row1 is change to cell(column);
			Iterator<Cell> column = row1.cellIterator();
			int i = 1;
			while (column.hasNext()) {
				if (i % 2 != 0) {
					userNameList.add(column.next().toString());
				} else {
					passwordList.add(column.next().toString());
				}
				i++;
			}
		}
	}

	public static String[][] excelDataExtentDisplay() {
		int count = 0;
		String[][] data = new String[userNameList.size()][2];
		for (int i = 0; i < userNameList.size(); i++) {
			data[count][0] = userNameList.get(i);
			data[count][1] = passwordList.get(i);
			count++;
		}

		return data;

	}
}
