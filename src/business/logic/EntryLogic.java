package business.logic;

import org.openqa.selenium.By;

import technical.level.GenericMethods;
import model.Entry;

public class EntryLogic extends GenericMethods {
	
	public void createEntry(Entry entry) {
		initEntryCreation();
		fillEntryCreationForm(entry);
		submitEntryCreationForm();
	}
	
	public void modifyEntry(Entry entry) {
		openFirstEntry();
		fillEntryModificationForm(entry);
		submitEntryModifyForm();
	}
	
	private void openFirstEntry() {
		findElements(By.cssSelector("table.items a.update-entry")).get(0).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Entry_name")));
//		sleep(7);
	}
	
	private void initEntryCreation() {
		click(By.linkText("Entries"));
		click(By.linkText("Create"));
	}

	private void fillEntryCreationForm(Entry entry) {
		type(By.id("Entry_name"), entry.name);
		type(By.id("Entry_username"), entry.userName);
		type(By.id("Entry_password"), entry.password);
		type(By.id("Entry_url"), entry.url);
		type(By.id("Entry_tagList"), entry.tag);
		type(By.id("Entry_comment"), entry.comment);
	}

	private void fillEntryModificationForm(Entry entry) {
		type(By.cssSelector("div#entry-form-modal #Entry_name"), entry.name);
		type(By.cssSelector("div#entry-form-modal #Entry_username"), entry.userName);
		type(By.cssSelector("div#entry-form-modal #Entry_password"), entry.password);
		type(By.cssSelector("div#entry-form-modal #Entry_url"), entry.url);
		type(By.cssSelector("div#entry-form-modal #Entry_tagList"), entry.tag);
		type(By.cssSelector("div#entry-form-modal #Entry_comment"), entry.comment);
	}	
	
	private void submitEntryCreationForm() {
		click(By.name("yt0"));
	}

	private void submitEntryModifyForm() {
		click(By.name("yt1"));
	}
}
