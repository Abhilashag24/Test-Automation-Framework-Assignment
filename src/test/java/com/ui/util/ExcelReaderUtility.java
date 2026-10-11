package com.ui.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {
		XSSFWorkbook workbook = null;
		
			try {
				workbook = new XSSFWorkbook(
						Thread.currentThread().getContextClassLoader().getResourceAsStream("testData/"+fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		XSSFSheet sheet	= workbook.getSheet("LoginTestData");
		
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		List<User> userList = new ArrayList<User>();
		User user;
		Row row ;
		Cell firstCell;
		Cell secondCell;
		while(rowIterator.hasNext()) {
			
			 row = rowIterator.next();
			 firstCell =row.getCell(0);
			 secondCell =row.getCell(1);
			user = new User(firstCell.toString(), secondCell.toString());
			userList.add(user);
		}

		return userList.iterator();
	}

}
