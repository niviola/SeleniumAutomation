package tests;

import model.Entry;
import model.User;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import business.logic.ApplicationLogic;
import business.logic.EntryLogic;
import business.logic.UserLogic;

public class UiTest {
	
	private static EntryLogic entryLogic;
	private static UserLogic userLogic;
	protected static ApplicationLogic app;
	
	@BeforeClass
	public static void beforeAll() throws Exception {
		app = new ApplicationLogic();
		userLogic = new UserLogic();
		entryLogic = new EntryLogic();

		User usr = new User();
		usr.login = "admin";
		usr.password = "admin";		
		
		app.start();
		userLogic.login(usr);		
	}	
	
	@Test
	public void testElements() throws Exception {
		entryLogic.checkElementsOnManageEntriesPage();
	}
	
	/*@Test
	
	@Test*/

	@AfterClass
	public static void afterAll() throws Exception {
		app.stop();
	}	

}
