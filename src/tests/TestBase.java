package tests;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import model.User;
import business.logic.ApplicationLogic;
import business.logic.EntryLogic;
import business.logic.TagLogic;
import business.logic.UserLogic;

public class TestBase {
	protected static EntryLogic entryLogic;
	protected static UserLogic userLogic;
	protected static ApplicationLogic app;
	protected static TagLogic tagLogic;

	@BeforeClass
	public static void beforeAll() throws Exception {
		System.out.println("TestBase: beforeAll");
		
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

	@AfterClass
	public static void afterAll() throws Exception {
		System.out.println("TestBase: afterAll");
		app.stop();
//		app.Ending();
	}
	
	protected long generateUniqueNumber() {
		return new Date().getTime();
	}
}
