package tests;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Entry;
import ru.yandex.qatools.allure.annotations.Step;

public class SearchTest extends TestBase {
	private static String uniqueName;

	@Step
	@BeforeClass
	public static void createEntryBeforeSearchTests() {
		Entry entry = new Entry();
		entry.name = "New Account" + generateUniqueNumber();
		entry.userName = "Bill";
		entry.password = "1234";
		entry.url = "";
		entry.tag = "1";
		entry.comment = "Search test";
		entryLogic.createEntry(entry);
		uniqueName = entry.name;
	}
	
	@Test
	public void searchExistingtEntry() {
		entryLogic.searchEntry(uniqueName);
		entryLogic.checkEntryExists(uniqueName);
	}

	@Test
	public void searchNonExistingEntry() {
		String text = "sdrgerhsaerherh";
		entryLogic.searchEntry(text);
		entryLogic.checkEntryDoesntExist();
	}
}
