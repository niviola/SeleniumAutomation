package tests;

import java.util.Date;

import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import business.logic.ApplicationLogic;
import business.logic.EntryLogic;
import business.logic.TagLogic;
import business.logic.UserLogic;

public class TestBase {
	protected static EntryLogic entryLogic;
	protected static UserLogic userLogic;
	protected static ApplicationLogic app;
	protected static TagLogic tagLogic;
	private static int testCount = 0;
	private static int counter = 0;

	@BeforeClass
	public static void beforeAll() throws Exception {
		if (testCount == 0) {
			beforeAllTests();
		}
		beforeEachClass();
	}

	private static void beforeAllTests() {
		System.out.println("TestBase: before all tests");
		app = new ApplicationLogic();
		userLogic = new UserLogic();
		entryLogic = new EntryLogic();
		tagLogic = new TagLogic();
		
		User usr = new User();
		usr.login = "admin";
		usr.password = "admin";

		app.start();
		userLogic.login(usr);
	}

	private static void beforeEachClass() {
		System.out.println("TestBase: before each class");
	}

	@Before
	public void beforeEachTest() throws Exception {
		testCount++;
		System.out.println("TestBase: before each test");
		System.out.println("Test Number: " + testCount);		
	}
	
	@AfterClass
	public static void afterAll() throws Exception {
		if (counter == testCount) {
		afterAllTests();
		}
		afterEachClass();
	}
	
	private static void afterEachClass() {
		System.out.println("TestBase: after each class");
	}
	
	@After
	public static void afterEachTest() throws Exception{
		counter++;
		System.out.println("TestBase: after each test");
		System.out.println("counter: " + counter);
	}

	private static void afterAllTests() {
		System.out.println("TestBase: after all tests");
		app.stop();
	}
	
	protected long generateUniqueNumber() {
		return new Date().getTime();
	}
	
}
