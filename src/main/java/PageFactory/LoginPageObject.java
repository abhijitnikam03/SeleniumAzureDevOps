package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	
	//################################ Page Object ################################
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
       
	}
		
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginbtn;
	
	//################################ Web Element Method ################################

	public void enterUserName(String uname) {
		System.out.println(uname);
		username.sendKeys(uname);
	}
	
	public void enterPassWord(String pass) {
		password.sendKeys(pass);
	}
	
	public void btnLogin() {
		loginbtn.click();
	}
	
}
