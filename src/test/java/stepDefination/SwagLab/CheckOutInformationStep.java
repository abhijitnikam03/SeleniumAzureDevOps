package stepDefination.SwagLab;

import PageFactory.SwagLab.CheckOutInformation;
import factory.DriverFactory;
import io.cucumber.java.en.And;

public class CheckOutInformationStep {
	
	CheckOutInformation cp;

	public CheckOutInformationStep() {
		cp=new CheckOutInformation(DriverFactory.getDriver());
	}
	
	@And("Enter firstname {string} and Lastname {string} and postalcode {string}")
	public void enter_username_and_password_and_postalcode(String uname, String lname, String pcode) {
		cp.enter_firstname(uname);
		cp.enter_lastname(lname);
		cp.enter_postalcode(pcode);
	}
	
	@And ("click on continue button of check confirmation page")
	public void click_on_continue_button_of_check_confirmation_page() {
		cp.click_continuebtn();
	}
}
