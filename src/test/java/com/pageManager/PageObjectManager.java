package com.pageManager;

import com.pages.BookHotelpage;
import com.pages.BookingConfirmationpage;
import com.pages.CancelBookingpage;
import com.pages.Loginpage;
import com.pages.SearchHotelpage;
import com.pages.SelectHotelpage;

public class PageObjectManager {

	private Loginpage loginpage;
	private SearchHotelpage searchHotelpage;
	private SelectHotelpage selectHotelpage;
	private BookHotelpage bookHotelpage;
	private BookingConfirmationpage bookingConfirmationpage;
	private CancelBookingpage cancelBookingpage;

	public Loginpage getLoginpage() {
		return (loginpage==null)?loginpage=new Loginpage():loginpage;
	}
	public SearchHotelpage getSearchHotelpage() {
		return (searchHotelpage==null)?searchHotelpage=new SearchHotelpage():searchHotelpage;
	}
	public SelectHotelpage getSelectHotelpage() {
		return (selectHotelpage==null)?selectHotelpage=new SelectHotelpage():selectHotelpage;
	}
	public BookHotelpage getBookHotelpage() {
		return (bookHotelpage==null)?bookHotelpage=new BookHotelpage():bookHotelpage;
	}
	public BookingConfirmationpage getBookingConfirmationpage() {
		return (bookingConfirmationpage==null)?bookingConfirmationpage=new BookingConfirmationpage():bookingConfirmationpage;
	}
	public CancelBookingpage getCancelBookingpage() {
		return (cancelBookingpage==null)?cancelBookingpage=new CancelBookingpage():cancelBookingpage;
	}
	
	
}
