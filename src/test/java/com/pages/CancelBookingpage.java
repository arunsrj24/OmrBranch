package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CancelBookingpage extends BaseClass{
	
	public CancelBookingpage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="my_itinerary")
	private WebElement my_itinerary;
	@FindBy(id="order_id_text")
	private WebElement order_id_text;
	@FindBy(id="search_hotel_id")
	private WebElement search_hotel_id;
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement cancelbutton;
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement bookeditinerary;
	@FindBy(id="search_result_error")
	private WebElement errormsg;
	
	public WebElement getErrormsg() {
		return errormsg;
	}

	public WebElement getBookeditinerary() {
		return bookeditinerary;
	}

	public WebElement getMy_itinerary() {
		return my_itinerary;
	}

	public WebElement getOrder_id_text() {
		return order_id_text;
	}
	public WebElement getSearch_hotel_id() {
		return search_hotel_id;
	}

	public WebElement getCancelbutton() {
		return cancelbutton;
	}
	
	public void cancelcreated(String createdorderid) throws AWTException {
		clickelement(getMy_itinerary());
		elementsendkeys(getOrder_id_text(), createdorderid);
		clickelement(getSearch_hotel_id());
		clickelement(getCancelbutton());
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void cancelexisting(String orderid) throws AWTException {
		clickelement(getBookeditinerary());
		elementsendkeys(getOrder_id_text(), orderid);
		clickelement(getSearch_hotel_id());
		clickelement(getCancelbutton());
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	
	}

}
