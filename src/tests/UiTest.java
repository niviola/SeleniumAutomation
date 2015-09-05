package tests;

import org.junit.Test;

public class UiTest extends TestBase {
	
	@Test
	public void testElementsOnManageEntriesPage() throws Exception {
		entryLogic.checkElementsOnManageEntriesPage();
	}
}
