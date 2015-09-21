package tests;

import model.Tag;

import org.junit.Test;

public class TagTest extends TestBase {

	@Test
	public void testTagCreation() throws Exception {
		System.out.println("<- TagTest.testTagCreation");
		Tag tag = new Tag();
		tag.name = "New Account" + generateUniqueNumber();
		
		tagLogic.createTag(tag);
		System.out.println("-> TagTest.testTagCreation");
	}

	@Test
	public void testTagModification() throws Exception {
		System.out.println("<- TagTest.testTagModification");
		Tag tag = new Tag();
		tag.name = "Updated Tag" + generateUniqueNumber();
				
		tagLogic.updateTag(tag);
		System.out.println("-> TagTest.testTagModification");
	}

	@Test
	public void testTagErase() throws Exception {
		System.out.println("<- TagTest.testTagErase");
		 tagLogic.deleteTag();
		 System.out.println("-> TagTest.testTagErase");
	}
	
}
