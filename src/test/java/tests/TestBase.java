package tests;

import java.util.Date;

import model.User;
import technical.level.JunitExtention;
import technical.level.LoggerHelper;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

import business.logic.ApplicationLogic;
import business.logic.EntryLogic;
//import business.logic.LoginLogic;
import business.logic.TagLogic;
import business.logic.UserLogic;

public class TestBase {
	protected static EntryLogic entryLogic;
	protected static UserLogic userLogic;
	protected static ApplicationLogic app;
	protected static TagLogic tagLogic;
	private static int classCounter = 0;
	protected static Logger log;

	@BeforeClass
	public static void beforeAll() throws Exception {
		log = LoggerHelper.getInstance().getLogger();
		log.info("<- TestBase.beforeAll");
		if (classCounter == 0) {
			beforeAllTests();
		}
		beforeEachClass();
		log.info("-> TestBase.beforeAll");
	}

	private static void beforeAllTests() {
		log.info("<- TestBase: before all tests");
		app = new ApplicationLogic();
		userLogic = new UserLogic();
		entryLogic = new EntryLogic();
		tagLogic = new TagLogic();
		
		User usr = new User();
		usr.login = "admin";
		usr.password = "admin";

		app.start();
		userLogic.login(usr);
		log.info("-> TestBase: before all tests");
	}

	private static void beforeEachClass() {
		classCounter++;
		log.info("TestBase: before each class");
		log.info("Class Number: " + classCounter);
	}

	@Rule 
	public TestName testName = new TestName();
	
	@Before
	public void beforeEachTest() throws Exception {
		log.info("<- Run test: " + testName.getMethodName());
	}
	
	@AfterClass
	public static void afterAll() throws Exception {
		log.info("<- TestBase.afterAll");
		afterEachClass();
		int maxNumberOfClasses = JunitExtention.getClasses("tests").size() - 1;
		if (classCounter == maxNumberOfClasses) {
		    afterAllTests();
		    log.info("-> TestBase.afterAll");
		}
	}
	
	private static void afterEachClass() {
		log.info("TestBase: after each class");
	}
	
	@After
	public void afterEachTest() throws Exception{
		log.info("-> End test: " + testName.getMethodName());
	}

	private static void afterAllTests() {
		log.info("TestBase: after all tests");
		app.stop();
	}
	
	protected static long generateUniqueNumber() {
		return new Date().getTime();
	}
	
}
