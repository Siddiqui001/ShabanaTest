package com.sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MySele {

	public void readExcel(String fileName) {
		FileInputStream testdatareader = null;
		try {
			testdatareader = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + "file path incorrect please check...");
		}
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(testdatareader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet shb = wb.getSheet("MySheet");

		int sixe = shb.getRow(1).getLastCellNum();

	System.out.println(shb.getRow(0).getCell(0).getStringCellValue());

	}

	public static void main(String[] args) {
		MySele m = new MySele();
		m.readExcel("C:\\Users\\MATEEQ\\Documents\\Data.xlsx");
		System.out.println("hello");
	}
}
