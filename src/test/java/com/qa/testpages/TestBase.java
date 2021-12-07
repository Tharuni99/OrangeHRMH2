package com.qa.testpages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

//import com.qa.testutilities.ExcelUtility;

public class TestBase 
{
	public static WebDriver driver;
	 public static OrangeHrm orangeHrm;
	 @Parameters({ "OrangeHrmURL", "BrowserURL" ,"Browser","userName","password"})
	 @BeforeTest
		public void Setup(String OrangeHrmURL,String browserURL,String browserName,String userName,String password) {
			if (browserName.equalsIgnoreCase("Chrome")) {
				  System.setProperty("webdriver.chrome.driver",browserURL);
				        driver =new ChromeDriver();
				        driver.manage().window().maximize();
				        orangeHrm = new OrangeHrm(driver);
			        driver.get(OrangeHrmURL);
			        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			    	orangeHrm.userName().sendKeys(userName);
					orangeHrm.password().sendKeys(password);
					orangeHrm.login().click();
					
					
			}
			


}
	 
		@AfterTest
		public void TearDown() throws InterruptedException {
		
		//driver.quit();
		}
		
	public void captureScreenshot(WebDriver driver,String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot captured");
		
		
		
	}	
	
	/*
	 * public String[][] getExcelData(String sheet) throws IOException{ String path=
	 * "C:\\Users\\tharu\\eclipse-workspace\\OrangehrmH2\\src\\test\\java\\com\\qa\\testdata\\leave_list.xlsx";
	 * ExcelUtility excelUtils =new ExcelUtility(path,sheet);
	 * 
	 * int rowCount=excelUtils.getRowCount(); int colCount=excelUtils.getColCount();
	 * 
	 * String data[][] = new String[rowCount-1][colCount];
	 * 
	 * for(int i=1;i<=rowCount;i++) { for(int j=0;j<colCount;j++) {
	 * if(excelUtils.getCellType(i, j)) { String cellData=
	 * excelUtils.getCellDataString(i, j);
	 * 
	 * data[i-1][j]=cellData; } else { double cellData=
	 * excelUtils.getCellNumaricString(i, j);
	 * 
	 * int intVal=(int)cellData; String s=Integer.toString(intVal); data[i-1][j]=s;
	 * 
	 * }
	 * 
	 * } }
	 * 
	 * 
	 * return data;
	 * 
	 * 
	 * 
	 * }
	 */
}
