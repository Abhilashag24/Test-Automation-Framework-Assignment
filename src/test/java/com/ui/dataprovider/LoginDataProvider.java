package com.ui.dataprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.ui.util.CSVReaderUtillty;
import com.ui.util.ExcelReaderUtility;

public class LoginDataProvider {

	
	@DataProvider(name="LoginTestDataProvider")
	public Iterator<Object> loginDataProvider() {
		
	 Gson gson = new Gson();
	 File file = new File(System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "testData" +File.separator+"LoginData.json");
	 FileReader fileReader =null;
	try {
		fileReader = new FileReader(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	TestData data = gson.fromJson(fileReader, TestData.class);  // deserialization of json in java object
	List<Object> dataToReturn = new ArrayList<Object>();
	for(User user : data.getData()) {
		dataToReturn.add(user);
	}
	
	return dataToReturn.iterator();
	}
	
	@DataProvider(name="LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		
		return CSVReaderUtillty.readCSVFile("loginData.csv");
		
	}
	
	@DataProvider(name="LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {
		
		return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
		
	}
	
	
}
