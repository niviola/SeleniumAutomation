package tests;

import java.util.Date;

import model.Tag;
import model.User;

import org.junit.*;

import business.logic.ApplicationLogic;
import business.logic.TagLogic;
import business.logic.UserLogic;

public class TagTests {

	private static TagLogic tagLogic;
	private static UserLogic userLogic;
	protected static ApplicationLogic app;
	
	@BeforeClass
	public static void beforeAll() throws Exception {
		app = new ApplicationLogic();
		userLogic = new UserLogic();
		tagLogic = new TagLogic();

		User usr = new User();
		usr.login = "admin";
		usr.password = "admin";		
		
		app.start();
		userLogic.login(usr);
		tagLogic.openManageTagsPage();
	}	
	
	@Test
	public void testTagCreation() throws Exception {
		Tag tag = new Tag();
		tag.name = "New Account" + new Date().getTime();
		
		tagLogic.createTag(tag);
	}

	@Test
	public void testTagModification() throws Exception {
		Tag tag = new Tag();
		tag.name = "Updated Tag" + new Date().getTime();
				
		tagLogic.updateTag(tag);
	}

	@Test
	public void testTagErase() throws Exception {
		 tagLogic.deleteTag();
	}
	
	@Test
	public void checkTagElements() throws Exception {
		tagLogic.checkElementsOnManageTagsPage();
	}
	
	@AfterClass
	public static void afterAll() throws Exception {
		app.stop();
	}	
}
