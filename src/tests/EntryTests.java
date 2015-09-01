package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import model.Entry;
import model.User;

import org.junit.*;

import business.logic.ApplicationLogic;
import business.logic.EntryLogic;
import business.logic.UserLogic;


public class EntryTests {

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
	public void testEntryCreation() throws Exception {
		Entry entry = new Entry();
		entry.name = "Google Account";
		entry.userName = "John";
		entry.password = "1234";
		entry.url = "";
		entry.tag = "1";
		entry.comment = "";

		entryLogic.createEntry(entry);
		assertThat(entryLogic.getTextAfterEntryCreation(), containsString("The entry was created successfully."));
	}

	@Test
	public void testEntryModification() throws Exception {
		Entry entry = new Entry();
		entry.name = "entry1";
		entry.userName = "user1";
		entry.password = "123456";
		entry.url = "yahoo.com";
		entry.tag = "2"; 
		entry.comment = "modified entry";
		
		entryLogic.modifyEntry(entry);
	}

	@Test
	public void testEntryErase() throws Exception {
		 entryLogic.deleteEntry();
	}
	
	@Test
	public void checkEntryElements() throws Exception {
	entryLogic.checkElementsOnManageEntriesPage();
	}
	
	@AfterClass
	public static void afterAll() throws Exception {
		app.stop();
		 app.Ending();
	}	
}
