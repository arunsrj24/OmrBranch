package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotelpage extends BaseClass{
	
	public SearchHotelpage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="location")
	private WebElement location;
	@FindBy(name="hotels")
	private WebElement hotels;
	@FindBy(name="room_type")
	private WebElement room_type;
	@FindBy(name="room_nos")
	private WebElement room_nos;
	@FindBy(name="datepick_in")
	private WebElement datepick_in;
	@FindBy(name="datepick_out")
	private WebElement datepick_out;
	@FindBy(name="adult_room")
	private WebElement adult_room;
	@FindBy(name="child_room")
	private WebElement child_room;
	@FindBy(id="Submit")
	private WebElement Submit;
	@FindBy(xpath="//td[@class='login_title']")
	private WebElement successmsg;
	@FindBy(id="checkin_span")
	private WebElement dateerror1;
	@FindBy(id="checkout_span")
	private WebElement dataerror2;
	@FindBy(id="location_span")
	private WebElement locationerror;
	

	
	public WebElement getLocationerror() {
		return locationerror;
	}

	public WebElement getDataerror2() {
		return dataerror2;
	}

	public WebElement getDateerror1() {
		return dateerror1;
	}

	public WebElement getSuccessmsg() {
		return successmsg;
	}

	public WebElement getSubmit() {
		return Submit;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoom_type() {
		return room_type;
	}

	public WebElement getRoom_nos() {
		return room_nos;
	}

	public WebElement getDatepick_in() {
		return datepick_in;
	}

	public WebElement getDatepick_out() {
		return datepick_out;
	}

	public WebElement getAdult_room() {
		return adult_room;
	}

	public WebElement getChild_room() {
		return child_room;
	}

	public void searchHotelButton() {
		getSubmit().click();
	}
	
	public void searchHotelCommonStep(String location, String numberofrooms, String checkindate, String checkoutdate, String adultsperroom) {
	
		elementsendkeys(getLocation(), location);
		elementsendkeys(getRoom_nos(), numberofrooms);
		getDatepick_in().clear();
		elementsendkeys(getDatepick_in(), checkindate);
		getDatepick_out().clear();
		elementsendkeys(getDatepick_out(), checkoutdate);
		elementsendkeys(getAdult_room(), adultsperroom);
		
	}
	
	public void searchHotel(String location, String numberofrooms, String checkindate, String checkoutdate, String adultsperroom) {
	
		searchHotelCommonStep(location, numberofrooms, checkindate, checkoutdate, adultsperroom);
		searchHotelButton();
	}
	
	public void searchHotel(String location, String hotels, String roomtype, String numberofrooms, String checkindate, String checkoutdate, String adultsperroom, String childrenperroom) {
		searchHotelCommonStep(location, numberofrooms, checkindate, checkoutdate, adultsperroom);
		
		elementsendkeys(getHotels(), hotels);
		elementsendkeys(getRoom_type(), roomtype);
		elementsendkeys(getChild_room(), childrenperroom);
		searchHotel();
		
	}
	
	public void searchHotel() {
		
		searchHotelButton();

	}
}
