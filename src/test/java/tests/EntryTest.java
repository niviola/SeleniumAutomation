package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import model.Entry;

import org.junit.Test;

public class EntryTest extends TestBase {

	@Test
	public void testEntryCreation() throws Exception {
		System.out.println("EntryTests: testEntryCreation");
		Entry entry = generateEntry(); // data
		entryLogic.createEntry(entry); // action
		assertThat(entryLogic.getTextAfterEntryCreation(), containsString("The entry was created successfully.")); // check
		//assertThat(entry.name, equalTo(entryLogic.getFirstEntryNameFromTable()));
	}

	@Test
	public void testEntryModification() throws Exception {
		System.out.println("EntryTests: testEntryModification");
		Entry entry = generateEntry(); // data
		entry.name = "Modified Account";
		entry.comment = "Modified Entry";

		entryLogic.modifyFirstEntry(entry); // action
		assertThat(entryLogic.getTextAfterEntryModification(), containsString("The entry was saved successfully.")); //check
	}

	@Test
	public void testEntryErase() throws Exception {
		System.out.println("EntryTests: testEntryErase");
		entryLogic.deleteEntry();
	}
	
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
