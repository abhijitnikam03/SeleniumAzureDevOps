package stepDefination.SwagLab;

import PageFactory.SwagLab.LoginPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginPageStep {
	
	LoginPage lp; 
	
	public LoginPageStep() {
		lp=new LoginPage(DriverFactory.getDriver());
	}

	@Given("Navigate to login page with url {string}")
	public void navigate_to_login_page_with_url(String url) {
		DriverFactory.getDriver().get(url);
	}

	@And("Enter username {string} and Password {string}")
	public void enter_username_and_password(String uname, String pass) {
	    lp.enterusername(uname);
	    lp.enterpassword(pass);
	}

	@And("Click on submit button")
	public void click_on_submit_button() {
	    lp.clicksubmit();
	}
}
