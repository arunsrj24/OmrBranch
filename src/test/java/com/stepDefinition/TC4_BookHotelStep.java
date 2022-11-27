package com.stepDefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import cucumber.api.java.en.Then;

public class TC4_BookHotelStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();

	@Then("User should book a hotel by entering following details {string}, {string} and {string}")
	public void user_should_book_a_hotel_by_entering_following_details_and(String firstname, String lastname, String address, io.cucumber.datatable.DataTable dataTable) {
	    pom.getBookHotelpage().bookHotel(firstname, lastname, address, dataTable);
	}

	@Then("User should verify after book hotel with success message {string}")
	public void user_should_verify_after_book_hotel_with_success_message(String expected) throws InterruptedException {
		Thread.sleep(10000);
	    String actual = pom.getBookHotelpage().getSuccessmsg().getText();
	    Assert.assertEquals(expected, actual);
	}

	@Then("User should book a hotel without entering any fields")
	public void user_should_book_a_hotel_without_entering_any_fields() {
	    pom.getBookHotelpage().bookHotel();
	}

	@Then("User should verify after book hotel with error message {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void user_should_verify_after_book_hotel_with_error_message_and(String expected1, String expected2, String expected3, String expected4, String expected5, String expected6, String expected7) throws InterruptedException {
	  Thread.sleep(2000);
	  String actual1 = pom.getBookHotelpage().getError1().getText();
	  String actual2 = pom.getBookHotelpage().getError2().getText();
	  String actual3 = pom.getBookHotelpage().getError3().getText();
	  String actual4 = pom.getBookHotelpage().getError4().getText();
	  String actual5 = pom.getBookHotelpage().getError5().getText();
	  String actual6 = pom.getBookHotelpage().getError6().getText();
	  String actual7 = pom.getBookHotelpage().getError7().getText();
	  
	  Assert.assertEquals(expected1, actual1);
	  Assert.assertEquals(expected2, actual2);
	  Assert.assertEquals(expected3, actual3);
	  Assert.assertEquals(expected4, actual4);
	  Assert.assertEquals(expected5, actual5);
	  Assert.assertEquals(expected6, actual6);
	  Assert.assertEquals(expected7, actual7);
	  
	}
	
}
