package tests;

import model.Tag;

import org.junit.Test;

public class TagTests extends TestBase {

	@Test
	public void testTagCreation() throws Exception {
		Tag tag = new Tag();
		tag.name = "New Account" + generateUniqueNumber();
		
		tagLogic.createTag(tag);
	}

	@Test
	public void testTagModification() throws Exception {
		Tag tag = new Tag();
		tag.name = "Updated Tag" + generateUniqueNumber();
				
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
}
