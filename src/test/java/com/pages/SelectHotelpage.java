package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotelpage extends BaseClass {
	
	public SelectHotelpage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="radiobutton_0")
	private WebElement selectbutton;
	@FindBy(name="continue")
	private WebElement submitbutton;
	@FindBy(xpath="(//td[@class='login_title'])[2]")
	private WebElement successmsg;
	@FindBy(id="radiobutton_span")
	private WebElement errormsg;
	
	public WebElement getErrormsg() {
		return errormsg;
	}

	public WebElement getSuccessmsg() {
		return successmsg;
	}

	public WebElement getSelectbutton() {
		return selectbutton;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}

	public void selectHotelCommonStep() {
		
		clickelement(getSubmitbutton());
	}
	
	public void selectHotel() {
		
		clickelement(getSelectbutton());
		selectHotelCommonStep();
	}
	
	public void clickContinue() {
		selectHotelCommonStep();
	}
	
}
