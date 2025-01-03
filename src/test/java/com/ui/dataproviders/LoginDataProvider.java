package com.ui.dataproviders;

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
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {
	
	@DataProvider(name="LoginTestDataProvider")
	public Iterator<Object[]> logindataprovider() throws FileNotFoundException {
		
		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir")+"/testData/logindata.json");
		FileReader filereader = new FileReader(testDataFile);
		TestData data = gson.fromJson(filereader, TestData.class);
		
		
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		
		for(User user : data.getData()) {
			
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();
		
	}
	
	@DataProvider(name="LogincsvTestDataProvider")
	public Iterator<User> logincsvdataprovider() {
		
		Iterator<User> userdata = CSVReaderUtility.readCSVFile("loginData.csv");
		return userdata;
				
	}
	
	@DataProvider(name="LoginexcelTestDataProvider")
	public Iterator<User> loginexceldataprovider() {
		
		Iterator<User> userdata = ExcelReaderUtility.readExcelFile("LoginData.xlsx");
		return userdata;
}
	}
