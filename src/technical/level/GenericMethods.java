package technical.level;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

	protected WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	@SuppressWarnings("unused")
	private WebDriverWait wait;
	
	public GenericMethods() {
		driver = DriverHelper.getInstance().getDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	
	// Technical Level
	// =====================================================================================
	// Should not be locators specific to application
	
	protected void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void click(By locator) {
		findElement(locator).click();
	}

	protected void type(By locator, String text) {
		if (text == null || text == "")
			return;
		WebElement element = findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	protected WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	protected boolean isElementPresent(By locator) {
		try {
			findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	protected String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	protected void openURL(String url) {
		driver.get(url);
	}

	protected List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}
	
	protected void quit() {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}		
	}
	
	protected Object executeJavaScript(String script) {
	    return ((JavascriptExecutor) driver).executeScript(script);
	} 

	protected void waitWhileAjaxCompleted(int sec) {
	    for (int i = 0; i < sec && !isAjaxCompleted(); i++)
	        sleep(1);
	}

	private boolean isAjaxCompleted() {
	    return (Long) executeJavaScript("return window.jQuery.active") == 0;
	} 
	
}
