package com.qa.testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrm 
{
	public OrangeHrm(WebDriver driver)
	{
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"txtUsername\"]")
	@CacheLookup
	WebElement userName;
	public WebElement userName()
	{
	 return userName;
	 
	}
	
	@FindBy(xpath = "//*[@id=\"txtPassword\"]")
	@CacheLookup
	WebElement password;
	
	public WebElement password()
	{
	 return password;
	 
	}
	
	@FindBy(xpath = "//*[@id=\"btnLogin\"]")
	@CacheLookup
	WebElement login;
	public WebElement login()
	{
	 return login;
	 
	} 
	
	@FindBy(xpath="//b[contains(text(),'Leave')]")		// //*[@id="menu_leave_viewLeaveModule"]/b
	WebElement leave;
	public WebElement leavelnk()
	{
		return leave;
	}
	
	@FindBy(xpath="//a[@id='menu_leave_assignLeave']")
	WebElement asgnleave;
	
	public WebElement asgnleave()
	{
		return asgnleave;
	}
	
	@FindBy(xpath="//input[@id='assignleave_txtEmployee_empName']")		////*[@id="menu_leave_assignLeave"]
	WebElement txtempName;
	public WebElement empname()
	{
		return txtempName;
		
	}
	
	@FindBy(xpath="//select[@id='assignleave_txtLeaveType']")
	WebElement ddltype;
	public WebElement leavetype()
	{
		return ddltype;
		
	}
	
	@FindBy(id="assignleave_txtFromDate")
	WebElement fromdate;
	public WebElement getFromDate()
	{
		return fromdate;
	}
	
	@FindBy(xpath="//input[@id='assignleave_txtToDate']") ////*[@id="ui-datepicker-div"]/table/tbody/tr[2]/td[3]/a
	WebElement todate;
	public WebElement getToDate()
	{
		return todate;
	}
	
	@FindBy(xpath="//textarea[@id='assignleave_txtComment']")
	WebElement comment;
	public WebElement setcomment() {
		return comment;
		
	}
	
	
	
	@FindBy(id="assignBtn")
	WebElement Assignbtn;
	public WebElement getAssignBtn()
	{
		return Assignbtn;
	}
	
	@FindBy(xpath="//a[@id='menu_leave_viewLeaveList']")
	WebElement leavelist;
	public WebElement listleave()
	{
		return leavelist;
	}
	
	@FindBy(xpath="//input[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']")
	WebElement leavestatus;
	public WebElement getLeavelist()
	{
		 return leavestatus;
	}
	
	@FindBy(xpath="//input[@id='leaveList_txtEmployee_empName']")		////*[@id="menu_leave_assignLeave"]
	WebElement txtempName1;
	public WebElement getempname()
	{
		return txtempName1;
		
	}
	
	@FindBy(xpath="//input[@id='btnSearch']")
	WebElement searchbtn;
	public WebElement getSearchBtn()
	{
		return searchbtn;
	}
}
	
	

