package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.testpages.TestBase;
import com.qa.testutilities.ExcelUtility;

public class TC_ASSIGNLEAVE_001 extends TestBase
{
	
	@Test(dataProvider="LoginData")
	public void assignleave(String[] inputData) throws InterruptedException 
	{	
		orangeHrm.leavelnk().click();
		orangeHrm.asgnleave().click();
		Thread.sleep(1000);
		System.out.println(inputData[0]);
		orangeHrm.empname().sendKeys(inputData[0]);
		Select s = new Select(orangeHrm.leavetype());
		s.selectByVisibleText(inputData[1]);
		orangeHrm.getFromDate().clear();
	    orangeHrm.getFromDate().sendKeys(inputData[2]+", "+inputData[5]+"-"+inputData[4]+"-"+inputData[3]);
	    orangeHrm.getToDate().clear();
	    orangeHrm.getToDate().sendKeys(inputData[2]+", "+inputData[5]+"-"+inputData[4]+"-"+inputData[3]);
		orangeHrm.setcomment().sendKeys(inputData[6]);
		Thread.sleep(2000);
	    orangeHrm.getAssignBtn().click();
	    Thread.sleep(2000);
	    }
		/*
		 * @DataProvider(name = "Sheet1") public String[][] AssignLeave() throws
		 * IOException {
		 * 
		 * 
		 * String sheet="Sheet1"; String[][] data= getExcelData(sheet);
		 * 
		 * return data; }
		 */
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException, Exception
	{
		
		String path=".\\src\\test\\java\\com\\qa\\testdata\\leave_list.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
		int rownum = xlutil.getRowCount("Sheet2");
		int colnum = xlutil.getCellCount("Sheet2", 1);
		System.out.println(rownum);
		System.out.println(colnum);
		String data[][] = new String[rownum][colnum];
		for (int r = 1; r <= rownum; r++) {
			for (int c = 0; c < colnum; c++) {
				data[r - 1][c] = xlutil.getCellData("Sheet2", r, c);
			}
		}
		return data;

		}
}

