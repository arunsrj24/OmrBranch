package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;


public class Loginpage extends BaseClass{
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement textusername;
	@FindBy(id="password")
	private WebElement textpassword;
	@FindBy(id="login")
	private WebElement textlogin;
	@FindBy(xpath="//b[contains(text(),'Invalid ')]")
	private WebElement texterrorlogin;
	@FindBy(id="username_show")
	private WebElement textsuccess;

		
	public WebElement getTextusername() {
		return textusername;
	}

	public WebElement getTextpassword() {
		return textpassword;
	}

	public WebElement getTextlogin() {
		return textlogin;
	}

	public WebElement getTexterrorlogin() {
		return texterrorlogin;
	}

	public WebElement getTextsuccess() {
		return textsuccess;
	}

	public void LoginCommonStep(String username, String password) {
		
		elementsendkeys(getTextusername(), username);
		elementsendkeys(getTextpassword(), password);
		
	}
	
	public void login(String username, String password) {
		LoginCommonStep(username, password);
		getTextlogin().click();
	}
	
	public void loginwithenterkey(String username,String password) throws AWTException {
		
		LoginCommonStep(username, password);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
}
		
}
