package tests;

import model.Entry;
import model.User;

import org.junit.*;

import business.logic.ApplicationLogic;
import business.logic.EntryLogic;
import business.logic.UserLogic;

public class EntryTests {

	private static EntryLogic entryLogic;
	private static UserLogic userLogic;
	private static ApplicationLogic app;

	// Test Level =============================================================================
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
	public void testEntryCreation() throws Exception {
		Entry entry = new Entry();
		entry.name = "Google Account";
		entry.userName = "John";
		entry.password = "1234";
		entry.url = "";
		entry.tag = "";
		entry.comment = "";

		entryLogic.createEntry(entry);
	}

	@Test
	public void testEntryModification() throws Exception {
		Entry entry = new Entry();
		entry.name = "entry1";
		entry.userName = "user1";
		entry.password = "123456";
		entry.url = "yahoo.com";
		entry.tag = "9"; 
		entry.comment = "modified entry";
		
		entryLogic.modifyEntry(entry);
	}

	@Test
	public void testEntryErase() throws Exception {
		// TODO delete entry
		 entryLogic.deleteEntry();
	}
	
	@AfterClass
	public static void afterAll() throws Exception {
		app.stop();
	}	
	
	
}
