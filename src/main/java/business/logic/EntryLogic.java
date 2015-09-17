package business.logic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

import org.openqa.selenium.By;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import model.Entry;
import ru.yandex.qatools.allure.annotations.Step;
import technical.level.GenericMethods;


public class EntryLogic extends GenericMethods {
	
	@Step
	public void createEntry(Entry entry) {
		initEntryCreation();
		fillEntryCreationForm(entry);
		submitEntryCreationForm();
	}
	
	@Step
	public void modifyFirstEntry(Entry entry) {
		openFirstEntry();
		fillEntryModificationForm(entry);
		submitEntryModifyForm();
	}
	
	@Step
	public void deleteEntry(){
		click(By.cssSelector("a.delete"));
	    closeAlertAndGetItsText();
	}
	
	public String getTextAfterEntryCreation() {
		return findElement(By.cssSelector("div.alert-box.success")).getText();
	}
	
	public String getTextAfterEntryModification() {
		return findElement(By.cssSelector("div.alert-box.success")).getText();
		
	}
	
	private void openFirstEntry() {
		int index = 0;
		openEntryByIndex(index);
	}

	private void openEntryByIndex(int index) {
		findElements(By.cssSelector("table.items a.update-entry")).get(index).click();
		waitWhileAjaxCompleted(10);
	}
	
	private void initEntryCreation() {
		click(By.linkText("Entries"));
		waitWhileAjaxCompleted(10);
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
	
	public void openManageEntriesPage() {
		openURL("http://localhost/passwordManager/index.php?r=entry/index");
	}
	
	@Step
	public void checkTextAfterEntryCreation() {
		assertThat(getTextAfterEntryCreation(), containsString("The entry was created successfully."));
	}
	
	@Step
	public void checkTextAfterEntryModification() {
		assertThat(getTextAfterEntryModification(), containsString("The entry was saved successfully."));
	}

	public void checkElementsOnManageEntriesPage() {
		System.out.println("****************************************************");
		System.out.println("Manage Entry page elements");
		System.out.println("****************************************************");
		/*System.out.println("Search - is present = " 			+ isElementPresent(By.cssSelector("input.ui-autocomplete-input"))); // TODO change to assertThat
		if (isElementPresent(By.cssSelector("input.ui-autocomplete-input")))
			System.out.println("Search - is present");
		else 
			System.out.println("Search - is missing");*/
		openManageEntriesPage();
		
		assertTrue("Search is missing", isElementPresent(By.cssSelector("input.ui-autocomplete-input")));
				
		//System.out.println("Advanced Search - is present = " 	+ isElementPresent(By.cssSelector("a.search-button")));
		assertTrue("Advanced Search is missing", isElementPresent(By.cssSelector("a.search-button")));
		
		//System.out.println("Displaying results - is present = " + isElementPresent(By.cssSelector("div.summary")));
//		assertTrue("Displaying results is missing", isElementPresent(By.cssSelector("div.summary")));
		
		//System.out.println("Username(1) - is present = " 		+ isElementPresent(By.cssSelector("a.sort-link[href*='username']")));
		assertTrue("Username(1) is missing", isElementPresent(By.cssSelector("a.sort-link[href*='username']")));
		
		//System.out.println("Username(2) - is present = " 		+ isElementPresent(By.cssSelector("th#yw1_c1 a")));
		assertTrue("Username(2) is missing", isElementPresent(By.cssSelector("th#yw1_c1 a")));
		
		//System.out.println("Cloud Settings(1) - is present = " 	+ isElementPresent(By.cssSelector("div#tag-cloud i.foundicon-settings")));
		assertTrue("Cloud Settings(1) is missing", isElementPresent(By.cssSelector("div#tag-cloud i.foundicon-settings")));
		
		//System.out.println("Cloud Settings(2) - is present = " 	+ isElementPresent(By.cssSelector("div#tag-cloud div.settings")));
		assertTrue("Cloud Settings(2) is missing", isElementPresent(By.cssSelector("div#tag-cloud div.settings")));
		
		//System.out.println("Cloud Settings(3) - is present = " 	+ isElementPresent(By.cssSelector("#tag-cloud .settings")));
		assertTrue("Cloud Settings(3) is missing", isElementPresent(By.cssSelector("#tag-cloud .settings")));
		
		//System.out.println("search first cell by raw index(1) - is present = " 	+ isElementPresent(By.cssSelector("tbody tr:nth-of-type(2) td:nth-of-type(1)")));
		assertTrue("search first cell by raw index(1) is missing", isElementPresent(By.cssSelector("tbody tr:nth-of-type(1) td:nth-of-type(1)")));
		
		//System.out.println("search first cell by raw index(2) - is present = " 	+ isElementPresent(By.cssSelector("tbody tr:nth-of-type(2) td:first-of-type")));
//		assertTrue("search first cell by raw index(2) is missing", isElementPresent(By.cssSelector("tbody tr:nth-of-type(2) td:first-of-type")));
		
		//System.out.println("Tags(1) - is present = " 				+ isElementPresent(By.cssSelector("li.has-dropdown > a[href='/passwordManager/index.php?r=tag/index']")));
		assertTrue("Tags(1) is missing", isElementPresent(By.cssSelector("li.has-dropdown > a[href='/passwordManager/index.php?r=tag/index']")));
		
		//System.out.println("Tags(2) - is present = " 			+ isElementPresent(By.cssSelector("li.has-dropdown:nth-of-type(2) > a")));
		assertTrue("Tags(2) is missing", isElementPresent(By.cssSelector("li.has-dropdown:nth-of-type(2) > a")));
		
		//System.out.println("Tags(3) - is present = " 			+ isElementPresent(By.cssSelector("li.has-dropdown > a[href*='tag/index']")));
		assertTrue("Tags(3) is missing", isElementPresent(By.cssSelector("li.has-dropdown > a[href*='tag/index']")));
		
		//System.out.println("Tags(4) - is present = " 			+ isElementPresent(By.cssSelector("nav .has-dropdown > a[href*=tag]")));
		assertTrue("Tags(4) is missing", isElementPresent(By.cssSelector("nav .has-dropdown > a[href*=tag]")));
	}

	public Object getFirstEntryNameFromTable() {
		return getElementText(By.cssSelector("locator")); // TODO build locator
	}
}
