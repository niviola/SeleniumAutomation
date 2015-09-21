package tests;

import org.junit.Test;

public class UiTest extends TestBase {
	
	@Test
	public void testElementsOnManageEntriesPage() throws Exception {
		System.out.println("<- UiTest.testElementsOnManageEntriesPage");
		entryLogic.checkElementsOnManageEntriesPage();
		System.out.println("-> UiTest.testElementsOnManageEntriesPage");
	}
	
	@Test
	public void checkTagElements() throws Exception {
		System.out.println("<- UiTest.checkTagElements");
		tagLogic.checkElementsOnManageTagsPage();
		System.out.println("-> UiTest.checkTagElements");
	}
}
