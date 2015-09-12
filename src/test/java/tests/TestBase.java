package tests;

import java.util.Date;

import model.User;

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
	
	/*@AfterClass
	public static void afterAll() throws Exception {
		System.out.println("TestBase: afterAll");
		app.stop();
//		app.Ending();
	}*/
	
	protected long generateUniqueNumber() {
		return new Date().getTime();
	}
	
}
