package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/** 
 * 
 * @author Arunsrj
 * @Description Maintain all resuable methods
 * @Date 16-Oct-2022
 */
public class BaseClass {

	public static WebDriver driver;
	/**
	 * @Description cross browser selection 
	 * @param browsername
	 * @Date 16-Oct-2022
	 */
	public static void crossBrowser(String browsername) {
		
		switch (browsername) {
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		default:
			System.out.println("Browser is Invalid");
			break;
		}
	}
	
	/**
	 * @Description Taking Screenshot
	 * @return byte[]
	 * @Date 16-Oct-2022
	 */
	
	public byte[] screenshot() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;

	}
	/**
	 * @Description Getting property file values
	 * @param key
	 * @return String
	 * @throws IOException
	 * @Date 16-Oct-2022
	 */
	public static String getpropertyfilevalue(String key) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Arunsrj\\eclipse-workspace\\OmrBranchAdactinAutomation\\src\\test\\resources\\Properties\\Config.properties");
		Properties property = new Properties();
		property.load(file);
		Object object = property.get(key);
		String value = object.toString();
		return value;
	}
	/**
	 * @Description Url launch
	 * @param url
	 * @Date 16-Oct-2022
	 */
	public static void urllaunch(String url) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	/**
	 * @Description Launch only url 
	 * @param url
	 */
	public static void urlonly(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}
	/**
	 * @Description Find webelement and sendkeys to that 
	 * @param element
	 * @param value
	 * @Date 16-Oct-2022
	 */
	public static void elementsendkeys(WebElement element, String value) {
		element.sendKeys(value);
		
	}
	/**
	 * @Description 
	 * @param element
	 */
	public static void clickelement(WebElement element){
		element.click();
	}
	/**
	 * @Description 
	 * @param Id
	 * @return
	 */
	public WebElement byId(String Id) {
		WebElement findElement = driver.findElement(By.id(Id));
		return findElement;
	}
	
	/**
	 * @Description 
	 * @param Xpath
	 * @return
	 */
	public WebElement byxpath(String Xpath) {
		WebElement findElement = driver.findElement(By.xpath(Xpath));
		return findElement;
	}
	public List<WebElement> findElements(String Xpath) {
		List<WebElement> findElements = driver.findElements(By.xpath(Xpath));
		return findElements;
	}
	public void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	public void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	public void close() {
		driver.close();
	}
	public void pageresource() {
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}
	public String getWindowHandle(){
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	public Set<String> getWindowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	public Alert alert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	public void scrolldownjavascript(String xpath) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath(xpath)));
	}
	public void scrollupjavascript(String xpath) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", driver.findElement(By.xpath(xpath)));
	}
	public void framebyindex(int i) {
		driver.switchTo().frame(i);
	}
	public void framebyelement(String xpath) {
		WebElement frameelement = driver.findElement(By.xpath(xpath));
		driver.switchTo().frame(frameelement);
	}
	public void movetoElement(String xpath) {
		Actions act = new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath(xpath));
		act.moveToElement(findElement).perform();
	}
	public void rightClick(String xpath) {
		Actions act = new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath(xpath));
		act.contextClick(findElement).perform();
	}
	public void doubleClick(String xpath) {
		Actions act = new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath(xpath));
		act.doubleClick(findElement).perform();
	}
	public void click(String webElement) {
		Actions act = new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath(webElement));
		act.click(findElement).perform();
	}
	public void dragandDrop(String dragxpath, String dropxpath) {
		Actions act = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath(dragxpath));
		WebElement drop = driver.findElement(By.xpath(dropxpath));
		act.dragAndDrop(drag, drop).perform();
	}
	public void dropdowns(String xpath, String value) {
		WebElement selectoptions = driver.findElement(By.xpath(xpath));
		Select s = new Select(selectoptions);
		s.selectByValue(value);
	}
	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public String gettext(String xpath) {
		WebElement text = driver.findElement(By.xpath(xpath));
		String text2 = text.getText();
		return text2;
	}
	public String getattribute(String xpath) {
		WebElement attribute = driver.findElement(By.xpath(xpath));
		String attribute2 = attribute.getAttribute("value");
		return attribute2;
	}
	public void robotEnter() throws AWTException {
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
	}
	public void robotDown() throws AWTException {
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_DOWN);
		rob.keyRelease(KeyEvent.VK_DOWN);
	}
	public void screenShot(String screenpath) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(screenpath));
	}
}
