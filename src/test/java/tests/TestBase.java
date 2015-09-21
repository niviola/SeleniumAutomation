package tests;

import java.util.Date;

import model.User;
import technical.level.JunitExtention;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

import business.logic.ApplicationLogic;
import business.logic.EntryLogic;
import business.logic.TagLogic;
import business.logic.UserLogic;

public class TestBase {
	protected static EntryLogic entryLogic;
	protected static UserLogic userLogic;
	protected static ApplicationLogic app;
	protected static TagLogic tagLogic;
	private static int classCounter = 0;

	@BeforeClass
	public static void beforeAll() throws Exception {
		System.out.println("<- TestBase.beforeAll");
		if (classCounter == 0) {
			beforeAllTests();
		}
		beforeEachClass();
		System.out.println("-> TestBase.beforeAll");
	}

	private static void beforeAllTests() {
		System.out.println("<- TestBase: before all tests");
		app = new ApplicationLogic();
		userLogic = new UserLogic();
		entryLogic = new EntryLogic();
		tagLogic = new TagLogic();
		
		User usr = new User();
		usr.login = "admin";
		usr.password = "admin";

		app.start();
		userLogic.login(usr);
		System.out.println("-> TestBase: before all tests");
	}

	private static void beforeEachClass() {
		classCounter++;
		System.out.println("TestBase: before each class");
		System.out.println("Class Number: " + classCounter);
	}

	@Rule 
	public TestName testName = new TestName();
	
	@Before
	public void beforeEachTest() throws Exception {
		System.out.println("<- Run test: " + testName.getMethodName());
	}
	
	@AfterClass
	public static void afterAll() throws Exception {
		System.out.println("<- TestBase.afterAll");
		afterEachClass();
		int maxNumberOfClasses = JunitExtention.getClasses("tests").size() - 1;
		if (classCounter == maxNumberOfClasses) {
		    afterAllTests();
		    System.out.println("-> TestBase.afterAll");
		}
	}
	
	private static void afterEachClass() {
		System.out.println("TestBase: after each class");
	}
	
	@After
	public void afterEachTest() throws Exception{
		System.out.println("-> End test: " + testName.getMethodName());
	}

	private static void afterAllTests() {
		System.out.println("TestBase: after all tests");
		app.stop();
	}
	
	protected long generateUniqueNumber() {
		return new Date().getTime();
	}
	
}
