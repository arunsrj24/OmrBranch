package com.pages;

import com.base.BaseClass;

public class BookingConfirmationpage extends BaseClass{

	public String getorderId() {
		
		String orderId = byId("order_no").getAttribute("value");
		return orderId;

	}
	
}
