package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	
	//################################ Page Object ################################
	private WebDriver driver=null;
	
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='app_logo']")
	List<WebElement> logo;

	//################################ Web Element Method ################################

	
	public int lbllogo() {
		System.out.println(logo.size());
		return logo.size();
	}
}
