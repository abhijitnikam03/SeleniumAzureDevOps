package PageFactory.SwagLab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//#################### Page Object ####################
	
	@FindBy(id="user-name")
	WebElement usernametxtbx;
	
	@FindBy(id="password")
	WebElement passtxtbx;
	
	@FindBy(id="login-button")
	WebElement loginbtn;
	
//#################### Web Method ####################
	
	public void enterusername(String uname) {
		usernametxtbx.sendKeys(uname);
	}
	
	public void enterpassword(String pass) {
		passtxtbx.sendKeys(pass);
	}
	
	public void clicksubmit() {
		loginbtn.click();
	}
}
