package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String filename) {

		File excelfile = new File(System.getProperty("user.dir") + "\\testData\\" +filename);
		FileReader filereader;
		XSSFWorkbook xssfworkbook;
		Row row;
		Cell emailAddresscell;
		Cell passwordcell;
		User user;
		List<User> userList = null;
		XSSFSheet xssfsheet;
		Iterator<Row> rowIterator;
		try {
			filereader = new FileReader(excelfile);
			xssfworkbook = new XSSFWorkbook(excelfile);
            userList = new ArrayList<User>();
			xssfsheet = xssfworkbook.getSheet("LoginTestData");
			rowIterator = xssfsheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();

				emailAddresscell = row.getCell(0);
				passwordcell = row.getCell(1);
				user = new User(emailAddresscell.toString(), passwordcell.toString());
				userList.add(user);
			}
			xssfworkbook.close();
		}

		catch (InvalidFormatException | IOException e) {

			e.printStackTrace();
		}
return userList.iterator();
	}

}
