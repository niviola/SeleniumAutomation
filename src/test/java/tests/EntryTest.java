package tests;

import model.Entry;
import ru.yandex.qatools.allure.annotations.Step;

import org.junit.Test;

public class EntryTest extends TestBase {

	@Test
	public void testEntryCreation() throws Exception {
		Entry entry = generateEntry(); // data
		entryLogic.createEntry(entry); // action
		entryLogic.checkTextAfterEntryCreation(); // check
	}

	@Test
	public void testEntryModification() throws Exception {
		Entry entry = generateEntry(); // data
		entry.name = "Modified Account";
		entry.comment = "Modified Entry";

		entryLogic.modifyFirstEntry(entry); // action
		entryLogic.checkTextAfterEntryModification(); //check
	}

	@Test
	public void testEntryErase() throws Exception {
		entryLogic.deleteEntry();
	}
	
	@Step
	private Entry generateEntry() {
		Entry entry = new Entry();
		entry.name = "New Account" + generateUniqueNumber();
		entry.userName = "John";
		entry.password = "1234";
		entry.url = "";
		entry.tag = "1";
		entry.comment = "New Entry";
		return entry;
	}
	
}
