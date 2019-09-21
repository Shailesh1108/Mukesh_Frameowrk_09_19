package com.crmUtilty;

import java.io.File;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider
{
	
	public Workbook wb;
	
	public void readExcel(String filePath,String fileName,String sheetName) throws IOException
	{
		

	    //Create an object of File class to open xlsx file

	    File src =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream fis = new FileInputStream(src);

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    wb = new XSSFWorkbook(fis);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of HSSFWorkbook class

	        wb = new HSSFWorkbook(fis);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet sheet = wb.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it

	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = sheet.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console

	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }

	        System.out.println();
	    } 

	    }  

	    //Main function is calling readExcel function to read data from excel file

	    public static void main(String...strings) throws IOException{

	    //Create an object of ReadGuru99ExcelFile class

	    	ExcelDataProvider objExcelFile = new ExcelDataProvider();

	    //Prepare the path of excel file

	    String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";

	    //Call read file method of the class to read data

	    objExcelFile.readExcel(filePath,"ExportExcel.xlsx","ExcelGuru99Demo");

	    }
	    
	    
	    
	    public void WriteExcel(String filePath,String fileName,String sheetName,String[] dataToWrite) throws IOException
	    {
	    	
	    	File src =    new File(filePath+"\\"+fileName);

	        //Create an object of FileInputStream class to read excel file

	        FileInputStream fos = new FileInputStream(src);

	        //Find the file extension by splitting  file name in substring and getting only extension name

	        String fos = fileName.substring(fileName.indexOf("."));

	        //Check condition if the file is xlsx file

	        if(fos.equals(".xlsx")){

	        //If it is xlsx file then create object of XSSFWorkbook class

	        wb = new XSSFWorkbook(fos);

	        }

	        //Check condition if the file is xls file

	        else if(fileExtensionName.equals(".xls")){

	            //If it is xls file then create object of XSSFWorkbook class

	            wb = new HSSFWorkbook(fos);

	        }    

	    //Read excel sheet by sheet name    

	    Sheet sheet = wb.getSheet(sheetName);

	    //Get the current count of rows in excel file

	    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

	    //Get the first row from the sheet

	    Row row = sheet.getRow(0);

	    //Create a new row and append it at last of sheet

	    Row newRow = sheet.createRow(rowCount+1);

	    //Create a loop over the cell of newly created Row

	    for(int j = 0; j < row.getLastCellNum(); j++){

	        //Fill data in row

	        Cell cell = newRow.createCell(j);

	        cell.setCellValue(dataToWrite[j]);

	    }

	    //Close input stream

	    fos.close();

	    //Create an object of FileOutputStream class to create write data in excel file

	    FileOutputStream outputStream = new FileOutputStream(src);

	    //write data in the excel file

	    wb.write(outputStream);

	    //close output stream

	    outputStream.close();
		
	    }

	    public static void main1(String...strings) throws IOException{

	        //Create an array with the data in the same order in which you expect to be filled in excel file

	        String[] valueToWrite = {"Mr. E","Noida"};

	        //Create an object of current class

	        ExcelDataProvider objExcelFile = new ExcelDataProvider();

	        //Write the file using file name, sheet name and the data to be filled

	        objExcelFile.WriteExcel(System.getProperty("user.dir")+"\\src\\excelExportAndFileIO","ExportExcel.xlsx","ExcelGuru99Demo",valueToWrite);

	    }
	    	
	    }




