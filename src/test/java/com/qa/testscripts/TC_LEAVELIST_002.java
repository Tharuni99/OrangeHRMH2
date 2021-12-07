package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.annotations.DataProvider;

import com.qa.testpages.TestBase;
import com.qa.testutilities.ExcelUtility;

public class TC_LEAVELIST_002 extends TestBase 
{
	
	@Test(dataProvider="Sheet2")
	public void leavelist(String[] inputData) throws InterruptedException
	{
		orangeHrm.listleave().click();
		orangeHrm.getLeavelist().click();
		Thread.sleep(1000);
		orangeHrm.getempname().sendKeys(inputData[0]);
		orangeHrm.getSearchBtn().click();
		
	}
	/*@DataProvider(name = "Sheet2")
	public String[][] Leavelist() throws IOException
	{
		String sheet = "Sheet2";
		String[][] data = getExcelData(sheet);
		
		return data;	
}*/
	
	@DataProvider(name="Sheet2")
	public String[][] getData() throws IOException, Exception
	{
		
		String path=".\\src\\test\\java\\com\\qa\\testdata\\leave_list.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path); 
		int totalrows = xlutil.getRowCount("Sheet2");
		int totalcols =  xlutil.getCellCount("Sheet2",1);
		String loginData[][] = new String[totalrows][totalcols];
		
		for(int i=1 ; i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet2", i,j);
				//Thread.sleep(3000);
			}
			
			
		}
		System.out.println("hai");
		

	return loginData;
		}	
}