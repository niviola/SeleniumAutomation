package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import model.Entry;
import model.User;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EntryTests {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/passwordManager";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testEntryCreation() throws Exception {
		User usr = new User();
		usr.login = "admin";
		usr.password = "admin";

		Entry entry = new Entry();
		entry.name = "Google Account";
		entry.userName = "John";
		entry.password = "1234";
		entry.url = "";
		entry.tag = "";
		entry.comment = "";

		openApplication();
		login(usr);
		createEntry(entry);
	}

	@Test
	public void testEntryModification() throws Exception {
		// TODO add modify entry
		Entry entry1 = new Entry();
		entry1.name = "entry1";
		entry1.userName = "user1";
		entry1.password = "123456";
		entry1.url = "yahoo.com";
		entry1.tag = "9"; 
		entry1.comment = "modified entry";
		fillEntryCreationForm(entry1);
	}

	@Test
	public void testEntryErase() throws Exception {
		// TODO delete entry
	}

	private void openApplication() {
		driver.get(baseUrl);
	}

	private void login(User usr) {
		fillLoginForm(usr);
		submitLogin();
	}

	private void fillLoginForm(User usr) {
		driver.findElement(By.id("LoginForm_username")).clear();
		driver.findElement(By.id("LoginForm_username")).sendKeys(usr.login);
		driver.findElement(By.id("LoginForm_password")).clear();
		driver.findElement(By.id("LoginForm_password")).sendKeys(usr.password);
	}

	private void submitLogin() {
		driver.findElement(By.cssSelector("a.button")).click();
	}

	private void createEntry(Entry entry) {
		initEntryCreation();
		fillEntryCreationForm(entry);
		submitEntryCreationForm();
	}

	private void initEntryCreation() {
		driver.findElement(By.linkText("Entries")).click();
		driver.findElement(By.linkText("Create")).click();
	}

	private void fillEntryCreationForm(Entry entry) {
		driver.findElement(By.id("Entry_name")).clear();
		driver.findElement(By.id("Entry_name")).sendKeys(entry.name);
		driver.findElement(By.id("Entry_username")).clear();
		driver.findElement(By.id("Entry_username")).sendKeys(entry.userName);
		driver.findElement(By.id("Entry_password")).clear();
		driver.findElement(By.id("Entry_password")).sendKeys(entry.password);
		driver.findElement(By.id("Entry_url")).clear();
		driver.findElement(By.id("Entry_url")).sendKeys(entry.url);
		driver.findElement(By.id("Entry_tagList")).clear();
		driver.findElement(By.id("Entry_tagList")).sendKeys(entry.tag);
		driver.findElement(By.id("Entry_comment")).clear();
		driver.findElement(By.id("Entry_comment")).sendKeys(entry.comment);
	}

	private void submitEntryCreationForm() {
		driver.findElement(By.name("yt0")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
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
}
