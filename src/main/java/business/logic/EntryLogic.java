package business.logic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import model.Entry;
import ru.yandex.qatools.allure.annotations.Step;
import technical.level.GenericMethods;


public class EntryLogic extends GenericMethods {
	
	@Step
	public void createEntry(Entry entry) {
		log.info("<--- EntryLogic.createEntry");
		initEntryCreation();
		fillEntryCreationForm(entry);
		submitEntryCreationForm();
		log.info("---> EntryLogic.createEntry");
	}
	
	@Step
	public void modifyFirstEntry(Entry entry) {
		log.info("<--- EntryLogic.modifyFirstEntry");
		openFirstEntry();
		fillEntryModificationForm(entry);
		submitEntryModifyForm();
		log.info("---> EntryLogic.modifyFirstEntry");
	}
	
	@Step
	public void exportEntryToCSV() {
		exportEntry();
	}
	
	@Step
	public void checkEntryFileExists() {
		File file = new File("c:\\Users\\Viktor-VM\\Downloads");
	}
	
	private void exportEntry() {
		log.debug("<--- EntryLogic.");
		click(By.linkText("Entries"));
		waitWhileAjaxCompleted(10);
		click(By.linkText("Export to CSV"));
		log.debug(">---");
	}

	@Step
	public void deleteEntry(){
		log.info("<--- EntryLogic.deleteEntry");
		click(By.cssSelector("a.delete"));
	    closeAlertAndGetItsText();
	    log.info("---> EntryLogic.deleteEntry");
	}
	
	public String getTextAfterEntryCreation() {
		return findElement(By.cssSelector("div.alert-box.success")).getText();
	}
	
	public String getTextAfterEntryModification() {
		return findElement(By.cssSelector("div.alert-box.success")).getText();
	}
	
	private void openFirstEntry() {
		log.debug("<--- EntryLogic.openFirstEntry");
		int index = 0;
		openEntryByIndex(index);
		log.debug(">---");
	}

	private void openEntryByIndex(int index) {
		log.debug("<--- EntryLogic.");
		findElements(By.cssSelector("table.items a.update-entry")).get(index).click();
		waitWhileAjaxCompleted(10);
		log.debug(">---");
	}
	
	private void initEntryCreation() {
		log.debug("<--- EntryLogic.");
		click(By.linkText("Entries"));
		waitWhileAjaxCompleted(10);
		click(By.linkText("Create"));
		log.debug(">---");
	}

	private void fillEntryCreationForm(Entry entry) {
		log.debug("<--- EntryLogic.fillEntryCreationForm" + entry);
		type(By.id("Entry_name"), entry.name);
		type(By.id("Entry_username"), entry.userName);
		type(By.id("Entry_password"), entry.password);
		type(By.id("Entry_url"), entry.url);
		type(By.id("Entry_tagList"), entry.tag);
		type(By.id("Entry_comment"), entry.comment);
		log.debug(">---");
	}

	private void fillEntryModificationForm(Entry entry) {
		log.debug("<--- EntryLogic.fillEntryModificationForm" + entry);
		type(By.cssSelector("div#entry-form-modal #Entry_name"), entry.name);
		type(By.cssSelector("div#entry-form-modal #Entry_username"), entry.userName);
		type(By.cssSelector("div#entry-form-modal #Entry_password"), entry.password);
		type(By.cssSelector("div#entry-form-modal #Entry_url"), entry.url);
		type(By.cssSelector("div#entry-form-modal #Entry_tagList"), entry.tag);
		type(By.cssSelector("div#entry-form-modal #Entry_comment"), entry.comment);
		log.debug(">---");
	}	
	
	private void submitEntryCreationForm() {
		log.debug("<--- EntryLogic.");
		click(By.name("yt0"));
		log.debug(">---");
	}

	private void submitEntryModifyForm() {
		log.debug("<--- EntryLogic.");
		click(By.name("yt1"));
		log.debug(">---");
	}
	
	public void openManageEntriesPage() {
		log.info("<--- EntryLogic.openManageEntriesPage");
		openURL("http://localhost/passwordManager/index.php?r=entry/index");
		log.info("---> EntryLogic.openManageEntriesPage");
	}
	
	@Step
	public void checkTextAfterEntryCreation() {
		log.info("<--- EntryLogic.checkTextAfterEntryCreation");
		assertThat(getTextAfterEntryCreation(), containsString("The entry was created successfully."));
		log.info("---> EntryLogic.checkTextAfterEntryCreation");
	}
	
	@Step
	public void checkTextAfterEntryModification() {
		log.info("<--- EntryLogic.checkTextAfterEntryModification");
		assertThat(getTextAfterEntryModification(), containsString("The entry was saved successfully."));
		log.info("---> EntryLogic.checkTextAfterEntryModification");
	}

	public void checkElementsOnManageEntriesPage() {
		log.info("<--- EntryLogic.checkElementsOnManageEntriesPage");
		log.info("****************************************************");
		log.info("Manage Entry page elements");
		log.info("****************************************************");
		/*log.info("Search - is present = " 			+ isElementPresent(By.cssSelector("input.ui-autocomplete-input"))); // TODO change to assertThat
		if (isElementPresent(By.cssSelector("input.ui-autocomplete-input")))
			log.info("Search - is present");
		else 
			log.info("Search - is missing");*/
		openManageEntriesPage();
		
		assertTrue("Search is missing", isElementPresent(By.cssSelector("input.ui-autocomplete-input")));
				
		//log.info("Advanced Search - is present = " 	+ isElementPresent(By.cssSelector("a.search-button")));
		assertTrue("Advanced Search is missing", isElementPresent(By.cssSelector("a.search-button")));
		
		//log.info("Displaying results - is present = " + isElementPresent(By.cssSelector("div.summary")));
//		assertTrue("Displaying results is missing", isElementPresent(By.cssSelector("div.summary")));
		
		//log.info("Username(1) - is present = " 		+ isElementPresent(By.cssSelector("a.sort-link[href*='username']")));
		assertTrue("Username(1) is missing", isElementPresent(By.cssSelector("a.sort-link[href*='username']")));
		
		//log.info("Username(2) - is present = " 		+ isElementPresent(By.cssSelector("th#yw1_c1 a")));
		assertTrue("Username(2) is missing", isElementPresent(By.cssSelector("th#yw1_c1 a")));
		
		//log.info("Cloud Settings(1) - is present = " 	+ isElementPresent(By.cssSelector("div#tag-cloud i.foundicon-settings")));
		assertTrue("Cloud Settings(1) is missing", isElementPresent(By.cssSelector("div#tag-cloud i.foundicon-settings")));
		
		//log.info("Cloud Settings(2) - is present = " 	+ isElementPresent(By.cssSelector("div#tag-cloud div.settings")));
		assertTrue("Cloud Settings(2) is missing", isElementPresent(By.cssSelector("div#tag-cloud div.settings")));
		
		//log.info("Cloud Settings(3) - is present = " 	+ isElementPresent(By.cssSelector("#tag-cloud .settings")));
		assertTrue("Cloud Settings(3) is missing", isElementPresent(By.cssSelector("#tag-cloud .settings")));
		
		//log.info("search first cell by raw index(1) - is present = " 	+ isElementPresent(By.cssSelector("tbody tr:nth-of-type(2) td:nth-of-type(1)")));
		assertTrue("search first cell by raw index(1) is missing", isElementPresent(By.cssSelector("tbody tr:nth-of-type(1) td:nth-of-type(1)")));
		
		//log.info("search first cell by raw index(2) - is present = " 	+ isElementPresent(By.cssSelector("tbody tr:nth-of-type(2) td:first-of-type")));
//		assertTrue("search first cell by raw index(2) is missing", isElementPresent(By.cssSelector("tbody tr:nth-of-type(2) td:first-of-type")));
		
		//log.info("Tags(1) - is present = " 				+ isElementPresent(By.cssSelector("li.has-dropdown > a[href='/passwordManager/index.php?r=tag/index']")));
		assertTrue("Tags(1) is missing", isElementPresent(By.cssSelector("li.has-dropdown > a[href='/passwordManager/index.php?r=tag/index']")));
		
		//log.info("Tags(2) - is present = " 			+ isElementPresent(By.cssSelector("li.has-dropdown:nth-of-type(2) > a")));
		assertTrue("Tags(2) is missing", isElementPresent(By.cssSelector("li.has-dropdown:nth-of-type(2) > a")));
		
		//log.info("Tags(3) - is present = " 			+ isElementPresent(By.cssSelector("li.has-dropdown > a[href*='tag/index']")));
		assertTrue("Tags(3) is missing", isElementPresent(By.cssSelector("li.has-dropdown > a[href*='tag/index']")));
		
		//log.info("Tags(4) - is present = " 			+ isElementPresent(By.cssSelector("nav .has-dropdown > a[href*=tag]")));
		assertTrue("Tags(4) is missing", isElementPresent(By.cssSelector("nav .has-dropdown > a[href*=tag]")));
		log.info("---> EntryLogic.checkElementsOnManageEntriesPage");
	}

	@Step
	public Object getFirstEntryNameFromTable() {
		return getElementText(By.cssSelector("locator")); // TODO build locator
	}

	@Step
	public void searchEntry(String text) {
		log.info("<--- EntryLogic.searchEntry");
		type(By.cssSelector("input[type=search]"), text);
		findElement(By.cssSelector("input[type=search]")).sendKeys(Keys.ENTER);
		log.info(">---");
	}

	@Step
	public void checkEntryExists(String uniqueName) {
		log.info("<--- EntryLogic.checkEntryExists");
		assertThat(getElementText(By.cssSelector(".summary")), containsString("Displaying 1-1 of 1 result."));
		assertThat(getElementText(By.cssSelector("table.items tbody td:first-of-type")), containsString(uniqueName));
		log.info(">---");
	}

	@Step
	public void checkEntryDoesntExist() {
		log.info("<--- EntryLogic.checkEntryDoesntExist");
		assertTrue("span class=empty not found", isElementPresent(By.cssSelector("span.empty")));
		assertThat(getElementText(By.cssSelector("span.empty")), containsString("No results found."));
		log.info(">---");
	}

}
