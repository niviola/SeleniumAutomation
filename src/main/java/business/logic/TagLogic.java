package business.logic;

import org.openqa.selenium.By;
import model.Tag;
import ru.yandex.qatools.allure.annotations.Step;
import technical.level.GenericMethods;

public class TagLogic extends GenericMethods {
	
	@Step
	public void createTag(Tag tag) {
		openManageTagsPage();
		initTagCreation();
		fillTagCreationForm(tag);
		saveTagCreationForm();		
	}

	@Step
	public void updateTag(Tag tag) {
		openManageTagsPage();
		openFirstTag();
		fillTagUpdateForm(tag);
		saveTagUpdateForm();
	}

	@Step
	public void deleteTag() {
		openManageTagsPage();
		click(By.cssSelector("table.items a.delete"));
	    closeAlertAndGetItsText();
	}

	public void openManageTagsPage() {
		openURL("http://localhost/passwordManager/index.php?r=tag/index");
	}
	
	private void initTagCreation() {
		click(By.cssSelector("nav ul.left > li:nth-of-type(2) > a"));
		click(By.cssSelector("nav ul.left > li:nth-of-type(2) > ul a[href*=create]"));
	}
	
	private void fillTagCreationForm(Tag tag) {
		type(By.id("Tag_name"), tag.name);
	}
	
	private void saveTagCreationForm() {
		click(By.name("yt0"));
	}
	
	private void openFirstTag() {
		int index = 0;
		openTagByIndex(index);
	}
	
	private void openTagByIndex(int index) {
		//findElements(By.cssSelector("table.items a[title=Update]")).get(index).click();
		click(By.cssSelector("table.items tr:nth-of-type(" + (index + 1) + ") a[title=Update]"));
		waitWhileAjaxCompleted(10);
	}
	
	private void fillTagUpdateForm(Tag tag){
		type(By.cssSelector("input#Tag_name"), tag.name);
	}
	
	private void saveTagUpdateForm(){
		click(By.name("yt0"));
	}
	
	public void checkElementsOnManageTagsPage() {
		System.out.println("****************************************************");
		System.out.println("Manage Tags page elements");
		System.out.println("****************************************************");
		openManageTagsPage();
		System.out.println("Title - is present = " 				+ isElementPresent(By.cssSelector("div.row div#content h1")));
		System.out.println("Advanced Search - is present = " 	+ isElementPresent(By.cssSelector("div.row div#content p a")));
		System.out.println("Name - is present = " 				+ isElementPresent(By.cssSelector("th#yw1_c0")));
		System.out.println("User Name - is present = " 			+ isElementPresent(By.cssSelector("th#yw1_c1")));
		System.out.println("first Delete icon - is present = " 	+ isElementPresent(By.cssSelector("a[href='/passwordManager/index.php?r=entry/delete&id=21']")));
		System.out.println("Most Viewed title - is present = " 	+ isElementPresent(By.cssSelector("div#most-viewed-entries h5")));
		System.out.println("Most Viewed icon - is present = " 	+ isElementPresent(By.cssSelector("div#most-viewed-entries div.settings")));
		System.out.println("Update icon 1 - is present = " 		+ isElementPresent(By.cssSelector("table.items tr:nth-of-type(1) a[title=Update]")));
	}
}
