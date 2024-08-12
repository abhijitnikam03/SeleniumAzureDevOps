package PageFactory.SwagLab;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutInformation {
	
	WebDriver driver;
	WebDriverWait wait;

	public CheckOutInformation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//################### Page Factory ###################

	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="postal-code")
	WebElement postalcode;
	
	@FindBy(xpath="//input[@value='CONTINUE']")
	WebElement continuebtn;
	
	
	//################### Web Element ###################
	
	
	public void enter_firstname(String fname) {
		wait.until(ExpectedConditions.visibilityOf(firstname));
		firstname.sendKeys(fname);
	}
	
	public void enter_lastname(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void enter_postalcode(String pcode) {
		postalcode.sendKeys(pcode);
	}

	public void click_continuebtn() {
		continuebtn.click();
	}
}
