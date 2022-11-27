package com.stepDefinition;

import java.awt.AWTException;

import org.junit.Assert;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import cucumber.api.java.en.Then;

public class TC5_CancelBookingStep extends BaseClass{

	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should verify after book hotel with success message {string} and saved order id")
	public void user_should_verify_after_book_hotel_with_success_message_and_saved_order_id(String string) throws InterruptedException {
	    Thread.sleep(10000);
		String getorderId = pom.getBookingConfirmationpage().getorderId();
	    System.out.println(string);
	    System.out.println("Generated Order Id:"+getorderId);
	}

	@Then("User should cancel created order id")
	public void user_should_cancel_created_order_id() throws AWTException {
	    pom.getCancelBookingpage().cancelcreated(pom.getBookingConfirmationpage().getorderId());
	}

	@Then("User should verify after cancel order id with success message {string}")
	public void user_should_verify_after_cancel_order_id_with_success_message(String expected) throws InterruptedException {
		Thread.sleep(2000);
	    String actual = pom.getCancelBookingpage().getErrormsg().getText();
	    Assert.assertEquals(expected, actual);
	}

	@Then("User should cancel existing order id {string}")
	public void user_should_cancel_existing_order_id(String orderid) throws AWTException {
	   pom.getCancelBookingpage().cancelexisting(orderid);
	}



}
