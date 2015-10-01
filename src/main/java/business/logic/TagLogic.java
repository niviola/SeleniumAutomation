package business.logic;

import org.openqa.selenium.By;
import model.Tag;
import ru.yandex.qatools.allure.annotations.Step;
import technical.level.GenericMethods;

public class TagLogic extends GenericMethods {
	
	@Step
	public void createTag(Tag tag) {
		log.info("<--- TagLogic.createTag" + tag);
		openManageTagsPage();
		initTagCreation();
		fillTagCreationForm(tag);
		saveTagCreationForm();
		log.info(">---");
	}

	@Step
	public void updateTag(Tag tag) {
		log.info("<--- " + tag);
		openManageTagsPage();
		openFirstTag();
		fillTagUpdateForm(tag);
		saveTagUpdateForm();
		log.info("--->");
	}

	@Step
	public void deleteTag() {
		log.info("<--- TagLogic.deleteTag");
		openManageTagsPage();
		click(By.cssSelector("table.items a.delete"));
	    closeAlertAndGetItsText();
	    log.info("---> TagLogic.deleteTag");
	}

	private void openManageTagsPage() {
		String url = "http://localhost/passwordManager/index.php?r=tag/index";
		log.debug("<--- " + url);
		openURL(url);
		log.debug("--->");
	}
	
	private void initTagCreation() {
		log.debug("<--- TagLogic.initTagCreation");
		click(By.cssSelector("nav ul.left > li:nth-of-type(2) > a"));
		click(By.cssSelector("nav ul.left > li:nth-of-type(2) > ul a[href*=create]"));
		log.debug("--->");
	}
	
	private void fillTagCreationForm(Tag tag) {
		log.debug("<--- TagLogic.fillTagCreationForm");
		type(By.id("Tag_name"), tag.name);
		log.debug("--->");
	}
	
	private void saveTagCreationForm() {
		log.debug("<--- TagLogic.saveTagCreationForm");
		click(By.name("yt0"));
		log.debug("--->");
	}
	
	private void openFirstTag() {
		log.debug("<--- TagLogic.openFirstTag");
		openTagByIndex(0);
		log.debug("--->");
	}
	
	private void openTagByIndex(int index) {
		log.debug("<--- openTagByIndex");
		click(By.cssSelector("table.items tr:nth-of-type(" + (index + 1) + ") a[title=Update]"));
		waitWhileAjaxCompleted(10);
		log.debug("--->");
	}
	
	private void fillTagUpdateForm(Tag tag){
		log.debug("<--- TagLogic.openTagByIndex");
		type(By.cssSelector("input#Tag_name"), tag.name);
		log.debug("--->");
	}
	
	private void saveTagUpdateForm(){
		log.debug("<--- TagLogic.saveTagUpdateForm");
		click(By.name("yt0"));
		log.debug("--->");
	}
	
	public void checkElementsOnManageTagsPage() {
		log.info("<--- TagLogic.checkElementsOnManageTagsPage");
		log.info("****************************************************");
		log.info("Manage Tags page elements");
		log.info("****************************************************");
		openManageTagsPage();
		log.info("Title - is present = " 				+ isElementPresent(By.cssSelector("div.row div#content h1")));
		log.info("Advanced Search - is present = " 	+ isElementPresent(By.cssSelector("div.row div#content p a")));
		log.info("Name - is present = " 				+ isElementPresent(By.cssSelector("th#yw1_c0")));
		log.info("User Name - is present = " 			+ isElementPresent(By.cssSelector("th#yw1_c1")));
		log.info("first Delete icon - is present = " 	+ isElementPresent(By.cssSelector("a[href='/passwordManager/index.php?r=entry/delete&id=21']")));
		log.info("Most Viewed title - is present = " 	+ isElementPresent(By.cssSelector("div#most-viewed-entries h5")));
		log.info("Most Viewed icon - is present = " 	+ isElementPresent(By.cssSelector("div#most-viewed-entries div.settings")));
		log.info("Update icon 1 - is present = " 		+ isElementPresent(By.cssSelector("table.items tr:nth-of-type(1) a[title=Update]")));
		log.info("---> TagLogic.checkElementsOnManageTagsPage");
	}
}
