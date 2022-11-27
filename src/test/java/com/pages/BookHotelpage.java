package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookHotelpage extends BaseClass{

	public BookHotelpage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	private WebElement firstname;
	@FindBy(id="last_name")
	private WebElement lastname;
	@FindBy(id="address")
	private WebElement address;
	@FindBy(id="cc_num")
	private WebElement creditcardno;
	@FindBy(id="cc_type")
	private WebElement cctype;
	@FindBy(id="cc_exp_month")
	private WebElement expmonth;
	@FindBy(id="cc_exp_year")
	private WebElement expyear;
	@FindBy(id="cc_cvv")
	private WebElement cvv;
	@FindBy(id="book_now")
	private WebElement booknow;
	@FindBy(className="login_title")
	private WebElement successmsg;
	@FindBy(id="first_name_span")
	private WebElement error1;
	@FindBy(id="last_name_span")
	private WebElement error2;
	@FindBy(id="address_span")
	private WebElement error3;
	@FindBy(id="cc_num_span")
	private WebElement error4;
	@FindBy(id="cc_type_span")
	private WebElement error5;
	@FindBy(id="cc_expiry_span")
	private WebElement error6;
	@FindBy(id="cc_cvv_span")
	private WebElement error7;
	
	public WebElement getError1() {
		return error1;
	}

	public WebElement getError2() {
		return error2;
	}

	public WebElement getError3() {
		return error3;
	}

	public WebElement getError4() {
		return error4;
	}

	public WebElement getError5() {
		return error5;
	}

	public WebElement getError6() {
		return error6;
	}

	public WebElement getError7() {
		return error7;
	}

	public WebElement getSuccessmsg() {
		return successmsg;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCreditcardno() {
		return creditcardno;
	}

	public WebElement getCctype() {
		return cctype;
	}

	public WebElement getExpmonth() {
		return expmonth;
	}

	public WebElement getExpyear() {
		return expyear;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBooknow() {
		return booknow;
	}

	public void bookHotelCommonstep() {
		getBooknow().click();
	}
	
	public void bookHotel(String firstname, String lastname, String address, io.cucumber.datatable.DataTable dataTable) {
		
		elementsendkeys(getFirstname(), firstname);
		elementsendkeys(getLastname(), lastname);
		elementsendkeys(getAddress(), address);
		
	   List<Map<String, String>> data = dataTable.asMaps();
	    Map<String, String> map = data.get(1);
	    String creditcard = map.get("CreditcardType");
	    String ccnumber = map.get("CreditcardNumber");
	    String month = map.get("SelectMonth");
	    String year = map.get("SelectYear");
	    String cvv = map.get("Cvv");
	    
	    elementsendkeys(getCctype(), creditcard);
	    elementsendkeys(getCreditcardno(), ccnumber);
	    elementsendkeys(getExpmonth(), month);
	    elementsendkeys(getExpyear(), year);
	    elementsendkeys(getCvv(), cvv);
	    
	    bookHotelCommonstep();
	}
	
	public void bookHotel() {
		clickelement(getBooknow());
		
	}
}
