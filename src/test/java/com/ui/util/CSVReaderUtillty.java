package com.ui.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtillty {

	private CSVReaderUtillty() {
	}

	public static Iterator<User> readCSVFile(String fileName) {

		// /automation-assignment/src/test/resources/testData;
		File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "testData" + File.separator + fileName);
		System.out.println(file);
		FileReader fileReader = null;
		CSVReader csvReader = null;
		String[] line = null;
		List<User> userList = new ArrayList<User>();
		User userData = null;
		try {
			fileReader = new FileReader(file);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();
			while ((line = csvReader.readNext()) != null) {
				userData = new User(line[0], line[1]);
				userList.add(userData);

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {

			e.printStackTrace();
		}
		return userList.iterator();
	}

}
